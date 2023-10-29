# Comparison

| Element   | Selection | Insertion | Merge (In-Place) | Merge (Stable) |     Quick     |   Heap    | Counting |
| :-------- | :-------: | :-------: | :--------------: | :------------: | :-----------: | :-------: | :------: |
| `Time`    |   $n^2$   | $n^2$`*`  |    $nlog(n)$     |   $nlog(n)$    | $nlog(n)$`**` | $nlog(n)$ |   $n$    |
| `Space`   |    $1$    |    $1$    |       $1$        |    $n$`***`    |  $log(n)$`^`  |    $1$    | $1$`^^`  |
| `Stable?` |    No     |    Yes    |        No        |      Yes       |      No       |    No     | No`^^^`  |

`*` $n$ when list is already sorted.  
`**` Usually faster than mergesort.  
`***` Can be made in-place, but will no longer be stable.  
`^` Due to stack recursion.  
`^^` Assuming few possible values.  
`^^^` Can be made stable, but this requires $n$ space complexity.
