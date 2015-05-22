# MazeRunner
This repository contains the source code to build a MazeRunner using both Breadth First and Depth First Searches.


The MazeRunner program is pretty cool. The way it works is that both Mazes are predefined and can be changed if you open up the code. Each Maze is an N*N array that makes each element a unique position in the grid, [0][0];[N][N] respectively.

The starting point in each Maze is indicated by an "S"; likewise the Exit is indicated by an "E".

The Runner will traverse through each maze until the find an Exit using both the Breadth First and Depth First Searches. The Runner always finds an Exit no matter how big or little the Maze is.

The one thing to to notice is that both the BFS implements a Stack where as the DFS implements a Queue. This is why both method are exactly the same however, the execution refelcts a Depth-First Search and a Breadth First Search.

This program was developed bty Garrett Head using the C programming language in Visual Studios 2013. -- 5/21/2015
