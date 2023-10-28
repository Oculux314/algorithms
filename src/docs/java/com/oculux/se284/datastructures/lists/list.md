# Comparison

| Method                           | Array | DynamicArray | LinkedList | DoubleLinkedList |
| :------------------------------- | :---: | :----------: | :--------: | :--------------: |
| `void add(int value)`            |  $n$  |     $1$      |    $1$     |       $1$        |
| `void remove()`                  |  $n$  |     $1$      |    $n$     |       $1$        |
| `int get(int index)`             |  $1$  |     $1$      |    $n$     |       $n$        |
| `void set(int index, int value)` |  $1$  |     $1$      |    $n$     |       $n$        |
| `int size();`                    |  $1$  |     $1$      |    $1$     |       $1$        |
