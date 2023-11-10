// Including package breaks the automarker.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/** A collated version of AVLTree submitted for extra credits in SE284. Cheers Rajko! */
public class AVL {

  private static final int FILE_LENGTH = 1000000; // Number of rows in file

  public static void main(String... args) {
    try {
      readFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void readFile() throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    AVL shell = new AVL();
    AVLTree tree = shell.new AVLTree();

    for (int i = 0; i < FILE_LENGTH; i++) {
      String line = reader.readLine();
      String[] tokens = line.split(" ");
      int command = Integer.valueOf(tokens[0]);
      int value = Integer.valueOf(tokens[1]);

      if (command == 0) {
        tree.put(value, value);
      } else {
        writer.write((tree.contains(value) ? "1" : "0") + System.lineSeparator());
      }
    }

    writer.close();
  }

  public class AVLTree extends RotationTree {

    protected class Node extends BinarySearchTree.Node {
      int height;

      private Node(int key, int value, Node parent) {
        super(key, value, parent);
        height = 0;
      }

      private int getSubHeight(Branch branch) {
        Node child = (Node) getChild(branch);
        return child == null ? -1 : child.height;
      }

      public int getLeftHeight() {
        return getSubHeight(Branch.LEFT);
      }

      public int getRightHeight() {
        return getSubHeight(Branch.RIGHT);
      }

      public int getBalance() {
        // +ve: right heavy
        // -ve: left heavy
        return getRightHeight() - getLeftHeight();
      }

      public void refreshHeight() {
        height = Math.max(getLeftHeight(), getRightHeight()) + 1;
      }
    }

    @Override
    protected Node createNode(int key, int value, BinarySearchTree.Node parent) {
      return new Node(key, value, (Node) parent);
    }

    @Override
    public void put(int key, int value) {
      if (root == null) {
        root = createNode(key, value, null);
        return;
      }

      Node node = (Node) root;
      Node next = null;

      while (true) {
        if (node.key == key) {
          node.value = value;
          return;
        }

        next = (Node) ((key < node.key) ? node.left : node.right);

        if (next == null) {
          if (key < node.key) {
            node.left = createNode(key, value, node);
            balanceFrom((Node) node.left);
          } else {
            node.right = createNode(key, value, node);
            balanceFrom((Node) node.right);
          }
          return;
        }

        node = next;
      }
    }

    private void balanceFrom(Node node) {
      if (node == null) {
        throw new IllegalArgumentException("Cannot balance null node");
      }

      Node parent = (Node) node.parent;
      if (parent == null) {
        return;
      }

      parent.refreshHeight();
      int balance = parent.getBalance();

      if (-1 <= balance && balance <= 1) {
        // Already balanced
        balanceFrom(parent);
        return;
      }

      // Letters correspond to SE284 slides
      if (balance == 2) { // Right-heavy (slides version)
        Node R = (Node) parent.right;
        if (R.getBalance() >= 0) {
          // Slides case 1
          rotate(R);
          balanceFrom(R);
          return;
        } else {
          // Slides case 2
          Node A = (Node) R.left;
          rotate(A);
          rotate(A);
          balanceFrom(A);
          return;
        }
      } else if (balance == -2) { // Left-heavy
        Node L = (Node) parent.left;
        if (L.getBalance() <= 0) {
          // Slides case 1 (flipped)
          rotate(L);
          balanceFrom(L);
          return;
        } else {
          // Slides case 2 (flipped)
          Node B = (Node) L.right;
          rotate(B);
          rotate(B);
          balanceFrom(B);
          return;
        }
      } else {
        throw new IllegalStateException("Invalid balance: " + balance);
      }
    }

    protected void rotate(Node node) {
      Node parent = (Node) node.parent;
      if (parent == null) {
        throw new IllegalArgumentException("Cannot rotate root node");
      }

      boolean isClockwiseRotation = (parent.left == node);
      Node leftTree, middleTree, rightTree;

      if (isClockwiseRotation) {
        leftTree = (Node) node.left;
        middleTree = (Node) node.right;
        rightTree = (Node) parent.right;
      } else {
        leftTree = (Node) parent.left;
        middleTree = (Node) node.left;
        rightTree = (Node) node.right;
      }

      Node grandparent = (Node) parent.parent;
      if (grandparent == null) {
        breakAndConnectNodes(null, null, node);
      } else if (grandparent.left == parent) {
        breakAndConnectNodes(grandparent, Branch.LEFT, node);
      } else {
        breakAndConnectNodes(grandparent, Branch.RIGHT, node);
      }

      if (isClockwiseRotation) {
        breakAndConnectNodes(node, Branch.LEFT, leftTree);
        breakAndConnectNodes(node, Branch.RIGHT, parent);
        breakAndConnectNodes(parent, Branch.LEFT, middleTree);
        breakAndConnectNodes(parent, Branch.RIGHT, rightTree);
      } else {
        breakAndConnectNodes(node, Branch.LEFT, parent);
        breakAndConnectNodes(node, Branch.RIGHT, rightTree);
        breakAndConnectNodes(parent, Branch.LEFT, leftTree);
        breakAndConnectNodes(parent, Branch.RIGHT, middleTree);
      }

      parent.refreshHeight();
      node.refreshHeight();
    }
  }

  public abstract class RotationTree extends BinarySearchTree {

    protected void rotate(Node node) {
      Node parent = node.parent;
      if (parent == null) {
        throw new IllegalArgumentException("Cannot rotate root node");
      }

      boolean isClockwiseRotation = (parent.left == node);
      Node leftTree, middleTree, rightTree;

      if (isClockwiseRotation) {
        leftTree = node.left;
        middleTree = node.right;
        rightTree = parent.right;
      } else {
        leftTree = parent.left;
        middleTree = node.left;
        rightTree = node.right;
      }

      Node grandparent = parent.parent;
      if (grandparent == null) {
        breakAndConnectNodes(null, null, node);
      } else if (grandparent.left == parent) {
        breakAndConnectNodes(grandparent, Branch.LEFT, node);
      } else {
        breakAndConnectNodes(grandparent, Branch.RIGHT, node);
      }

      if (isClockwiseRotation) {
        breakAndConnectNodes(node, Branch.LEFT, leftTree);
        breakAndConnectNodes(node, Branch.RIGHT, parent);
        breakAndConnectNodes(parent, Branch.LEFT, middleTree);
        breakAndConnectNodes(parent, Branch.RIGHT, rightTree);
      } else {
        breakAndConnectNodes(node, Branch.LEFT, parent);
        breakAndConnectNodes(node, Branch.RIGHT, rightTree);
        breakAndConnectNodes(parent, Branch.LEFT, leftTree);
        breakAndConnectNodes(parent, Branch.RIGHT, middleTree);
      }
    }
  }

  public class BinarySearchTree implements Map {

    protected class Node {
      int key;
      int value;
      Node left;
      Node right;
      Node parent;

      Node(int key, int value, Node parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
        size++;
      }

      protected Branch getParentDirection() {
        if (this.parent == null) {
          return null;
        }

        return (this.parent.left == this) ? Branch.LEFT : Branch.RIGHT;
      }

      public Node getChild(Branch direction) {
        return (direction == Branch.LEFT) ? left : right;
      }

      public String toStringIterative() {
        String leftString = (left == null) ? "" : left.toStringIterative();
        String rightString = (right == null) ? "" : right.toStringIterative();
        return String.format("(%s%s%s)", leftString, key, rightString);
      }

      @Override
      public String toString() {
        return String.valueOf(value);
      }
    }

    protected Node root = null;
    private int size = 0;

    protected Node createNode(int key, int value, Node parent) {
      return new Node(key, value, parent);
    }

    public void put(int key, int value) {
      if (root == null) {
        root = createNode(key, value, null);
        return;
      }

      Node node = root;
      Node next = null;

      while (true) {
        if (node.key == key) {
          node.value = value;
          return;
        }

        next = (key < node.key) ? node.left : node.right;

        if (next == null) {
          if (key < node.key) {
            node.left = createNode(key, value, node);
          } else {
            node.right = createNode(key, value, node);
          }
          return;
        }

        node = next;
      }
    }

    @Override
    public void remove(int key) {
      Node node = null;

      try {
        node = getNode(key);
      } catch (NodeNotFoundException e) {
        throw new IllegalArgumentException(e);
      }

      if (node.left == null && node.right == null) {
        connectParentToChild(node, null);
      } else if (node.left == null) {
        connectParentToChild(node, node.right);
      } else if (node.right == null) {
        connectParentToChild(node, node.left);
      } else {
        Node nextLarger = getNextLarger(node);
        node.key = nextLarger.key;
        node.value = nextLarger.value;
        connectParentToChild(nextLarger, nextLarger.right);
      }

      size--;
    }

    private Node getNextLarger(Node node) {
      if (node.right != null) {
        return getMinOfSubtree(node.right);
      } else {
        return getNextRightParent(node);
      }
    }

    private Node getMinOfSubtree(Node node) {
      while (node.left != null) {
        node = node.left;
      }
      return node;
    }

    private Node getNextRightParent(Node node) {
      while (node.parent != null && node.parent.left == node) {
        node = node.parent;
      }
      return node.parent;
    }

    private void connectParentToChild(Node node, Node child) {
      // Connects the specified node's parent to the child in the same direction (left/right)
      // The child must be the only child of the node or null (if the node has no children)
      if (node.parent == null) {
        root = child;
      } else if (node.parent.left == node) {
        connectNodes(node.parent, Branch.LEFT, child);
      } else {
        connectNodes(node.parent, Branch.RIGHT, child);
      }
    }

    @Override
    public boolean contains(int key) {
      try {
        getNode(key);
        return true;
      } catch (NodeNotFoundException e) {
        return false;
      }
    }

    @Override
    public int get(int key) {
      try {
        return getNode(key).value;
      } catch (NodeNotFoundException e) {
        throw new IllegalArgumentException(e);
      }
    }

    @Override
    public int size() {
      return size;
    }

    protected Node getNode(int key) throws NodeNotFoundException {
      Node current = root;

      while (current != null) {
        if (key == current.key) {
          return current;
        } else if (key < current.key) {
          current = current.left;
        } else {
          current = current.right;
        }
      }

      throw new NodeNotFoundException(key);
    }

    private void breakConnection(Node node, Branch connectionDirection) {
      if (node == null) {
        return;
      }

      Node child = node.getChild(connectionDirection);
      if (child == null) {
        return;
      }

      if (connectionDirection == Branch.LEFT) {
        node.left = null;
      } else if (connectionDirection == Branch.RIGHT) {
        node.right = null;
      } else {
        throw new IllegalArgumentException("Invalid connection direction");
      }

      child.parent = null;
    }

    protected void breakAndConnectNodes(Node parent, Branch connectionDirection, Node child) {
      if (parent != null && child != null) {
        breakConnection(parent, connectionDirection);
        breakConnection(child.parent, child.getParentDirection());
      }

      connectNodes(parent, connectionDirection, child);
    }

    protected void connectNodes(Node parent, Branch connectionDirection, Node child) {
      if (parent == null) {
        root = child;
        child.parent = null;
        return;
      }

      if (connectionDirection == Branch.LEFT) {
        parent.left = child;
      } else if (connectionDirection == Branch.RIGHT) {
        parent.right = child;
      } else {
        throw new IllegalArgumentException("Invalid connection direction");
      }

      if (child != null) {
        child.parent = parent;
      }
    }

    @Override
    public String toString() {
      if (root == null) {
        return "()";
      }

      return root.toStringIterative();
    }
  }

  public interface Map {

    void put(int key, int value);

    void remove(int key);

    boolean contains(int key);

    int get(int key);

    int size();
  }

  protected enum Branch {
    LEFT,
    RIGHT
  }

  public class NodeNotFoundException extends Exception {
    public NodeNotFoundException(int key) {
      super("Node with key " + key + " not found");
    }
  }
}