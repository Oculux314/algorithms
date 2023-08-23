
import algorithms.*;

class Main {
  
  public static void main(String[] args) {
    for (int i = 1; i < 50; i++) {
      test("Test" + i, i);
    }
  }

  private static void test(String name, int iteration) {
    print("\nTest started: " + name);
    long start = System.nanoTime();

    program(iteration);

    long end = System.nanoTime();
    double millis = (end - start) / 1000000.0;
    print("Test ended. Time: " + millis + " ms");
  }

  private static void program(int iteration) {
    int size = iteration;
    int printLen = 10;
    int[] array = new int[size];

    for (int i = 0; i < array.length; i++) {
      array[i] = (int) (Math.random() * size);
    }

    //print(array, printLen);

    MergeSort.run(array);

    //print(array, printLen);
  }

  private static void print(String string) {
    System.out.println(string);
  }

  public static void print(int x) {
    System.out.println(x);
  }

  public static void print(int[] array) {
    print(array, array.length);
  }

  public static void print(int[] array, int x) {
    String end;
    
    if (x >= array.length) {
      end = "]";
      x = array.length;
    } else {
      end = "... ]";
    }

    System.out.print("[ ");

    for (int i = 0; i < x; i++) {
      System.out.print(array[i] + " ");
    }

    System.out.println(end);
  }
}
