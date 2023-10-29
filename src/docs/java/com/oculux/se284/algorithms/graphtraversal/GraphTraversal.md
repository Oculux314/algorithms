# Comparison

| Element          |    DFS     |   BFS    |      PFS       |
| :--------------- | :--------: | :------: | :------------: |
| `Time`           |  $n + m$   | $n + m$  | $nlog(n) + m$  |
| `Space`          |    $n$     |   $n$    |      $n$       |
| `Data Structure` |   Stack    |  Queue   | Priority Queue |
| `Ordering`       | Timestamps | Distance |       ?        |

General time complexity of graph traversal: $An + m$
Where $A$ is the time complexity of selecting a grey node from the set of all grey nodes.

$m \rightarrow n^2$ if adjacency matrix is used.

# Arcs

A: Ancestor
D: Descendent
U: Unrelated

| Element    | Definition                     |
| :--------- | :----------------------------- |
| `Tree`     | $A \rightarrow D$ (selected)   |
| `Forward`  | $A \rightarrow D$ (unselected) |
| `Backward` | $D \rightarrow A$              |
| `Cross`    | $U \rightarrow U$              |

# Arcs (Digraph)

For $u \rightarrow v$

| Element   |                DFS                |  BFS  |
| :-------- | :-------------------------------: | :---: |
| `Tree`    | $seen(u)<seen(v)<done(v)<done(u)$ |  $$   |
| `Forward` |                ""                 | $DNE$ |
| `Back`    | $seen(v)<seen(u)<done(u)<done(v)$ |  $$   |
| `Cross`   | $seen(v)<seen(v)<done(u)<done(u)$ |  $$   |

# Arcs (Undirected Graph)

For $u - v$

| Element   |                DFS                |          BFS           |
| :-------- | :-------------------------------: | :--------------------: |
| `Tree`    | $seen(u)<seen(v)<done(v)<done(u)$ |  $\|d(v)-d(u)\| = 1$   |
| `Forward` |                ""                 |         $DNE$          |
| `Back`    | $seen(v)<seen(u)<done(u)<done(v)$ |         $DNE$          |
| `Cross`   | $seen(v)<seen(v)<done(u)<done(u)$ | $\|d(v)-d(u)\| \leq 1$ |
