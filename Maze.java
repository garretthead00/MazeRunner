package mazerunner;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Maze {
	
	
	//private static Position position;
	private static char[][] Maze;
	private static int Start_X, Start_Y, Exit_X, Exit_Y;
	private final char VISIT = '*';
	
	/**Constructor: Maze
	 * This will create the maze passed in through the parameters
	 * to be used in the class
	 * @param maze
	 */
	public Maze(char[][] maze)
	{
		Maze = maze;
	}
	
	/**Method: buildMaze
	 * This method will build the maze and display it to the user
	 */
	public void buildMaze()
	{
		for(int row= 0; row<Maze.length;row++)
		{
			for(int col = 0; col <Maze[0].length; col++)
			{
				//Locates and assigns the Starting coordinates
				if(Maze[row][col] == 'S')
				{
					Start_X = row;
					Start_Y = col;
				}
				//Locates and assigns the Exiting coordinates
				if(Maze[row][col] == 'E')
				{
					Exit_X = row;
					Exit_Y = col;
				}
				System.out.print(Maze[row][col] + " ");
			}
			System.out.println("");
		}		
	}
	
	private char[][] cloneMaze()
	{
		char[][] clone = new char[Maze.length][Maze[0].length];
	
		for(int row= 0; row<Maze.length;row++)
		{
			for(int col = 0; col <Maze[0].length; col++)
			{	
				clone[row][col] = Maze[row][col];
			}
		}
		return clone;
	}
	
	private void restart(char[][] maze)
	{
		for(int row= 0; row<Maze.length;row++)
		{
			for(int col = 0; col <Maze[0].length; col++)
			{	
				Maze[row][col] = maze[row][col];
			}
		}
	}
	
	public void getCoordinates()
	{
		System.out.println("\nStarting Coordinates: " + Start_X + " " + Start_Y);
		System.out.println("Exit Coordinates: " + Exit_X + " " + Exit_Y);
	}
	
	/**Method: visit
	 * This method will score each position in the maze as visited once
	 * the traversal reaches this spot. This will allow the traversal to skip
	 * previously visited positions.
	 * @param position
	 * @param x
	 * @return temp
	 */
	private char visit(Position position, char x)
	{
		char temp = Maze[position.row][position.col];
		Maze[position.row][position.col] = x;
		return temp;		
	}
	
	/**Method: isVisited
	 * This method will check to determine whether or not the current position
	 * passed in through the parameter has been visited or not, returning a boolean value
	 * whether true or false
	 * @param position
	 * @return boolean
	 */
	private boolean isVisited(Position position)
	{
		if(Maze[position.row][position.col] != VISIT && Maze[position.row][position.col] != 'X')
			return true;
		else
			return false;
	}
	
	/**Method: hasEscaped
	 * This method will check to determine whether or not the current position
	 * passed in through the parameter has escaped the maze, returning a boolean value
	 * whether true or false
	 * @param position
	 * @return boolean
	 */
	private boolean hasEscaped(Position position)
	{
		if(position.row == Exit_X && position.col == Exit_Y)
			return true;
		else
			return false;
	}
	
	public void DPS()
	{
		//Save the initial maze to we can restart with a new traversal
		char[][] clone = cloneMaze();
		
		//Create a stack of Positions to traverse the maze with each step available in the maze
		Stack<Position> mazeStack = new Stack<Position>();
		
		//Create the root of the traversal using the Start coordinates; push onto stack
		mazeStack.push(new Position(Start_X,Start_Y));
		
		//Create location steps to work with in the traversal
		Position currentPosition, nextPosition;
		
		//loop through until the EXIT is found or there is no way out
		while(!mazeStack.empty())
		{
			//pop off the current position
			currentPosition = mazeStack.pop();
		
			//Check to see if the DPS has escaped
			if(hasEscaped(currentPosition))
			{
				visit(currentPosition,VISIT); //score the location
				System.out.println("_______________\nDPS has ESCAPED!!!!\n");
				buildMaze(); //Display the maze to the user
				System.out.println("");
				break;
			}
			
			// Visit the location
			visit(currentPosition, VISIT);
			
			/**
			 * Check all possible moves (Up, Down, Left, Right) based on the currentPosition
			 * pushing them onto the stack if the location has not been visited or is not blocked by a wall.
			 */
			nextPosition = currentPosition.Up();
			if(isVisited(nextPosition))
				mazeStack.push(nextPosition);
			
			nextPosition = currentPosition.Left();
			if(isVisited(nextPosition))
				mazeStack.push(nextPosition);
			
			nextPosition = currentPosition.Right();
			if(isVisited(nextPosition))
				mazeStack.push(nextPosition);
		
			nextPosition = currentPosition.Down();
			if(isVisited(nextPosition))
				mazeStack.push(nextPosition);
			
			
			//Display each traversal
			buildMaze();
			System.out.println("");
		
		}
		
		// Reset the Maze so we can use a new traversal
		restart(clone);
		
	}// End DPS Traversal
	
	/**Method:BPS
	 * This method will traverse through the list using the Breadth-First-Search technique
	 * This will work the same as the DPS only it will use a Queue rather than a stack
	 */
	public void BPS()
	{
		//Save the initial maze to we can restart with a new traversal
		char[][] clone = cloneMaze();
		
		//Create a queue of Positions to traverse the maze with each step available in the maze
		Queue<Position> mazeQueue = new LinkedList<Position>();
		
		//Create the root of the traversal using the Start coordinates; add to the list
		mazeQueue.add(new Position(Start_X,Start_Y));
		
		//Create location steps to work with in the traversal
		Position currentPosition, nextPosition;
		
		//loop through until the EXIT is found or there is no way out
		while(!mazeQueue.isEmpty())
		{
			//remove the current position
			currentPosition = mazeQueue.remove();
		
			//Check to see if the BPS has escaped
			if(hasEscaped(currentPosition))
			{
				visit(currentPosition,VISIT); //score the location
				System.out.println("_______________\nBPS has ESCAPED!!!!\n");
				buildMaze(); //Display the maze to the user
				System.out.println("");
				break;
			}
			
			// Visit the location
			visit(currentPosition, VISIT);
			
			/**
			 * Check all possible moves (Up, Down, Left, Right) based on the currentPosition
			 * adding them onto the list if the location has not been visited or is not blocked by a wall.
			 */
			nextPosition = currentPosition.Up();
			if(isVisited(nextPosition))
				mazeQueue.add(nextPosition);
			
			nextPosition = currentPosition.Left();
			if(isVisited(nextPosition))
				mazeQueue.add(nextPosition);
			
			nextPosition = currentPosition.Right();
			if(isVisited(nextPosition))
				mazeQueue.add(nextPosition);
		
			nextPosition = currentPosition.Down();
			if(isVisited(nextPosition))
				mazeQueue.add(nextPosition);
			
			
			//Display each traversal
			buildMaze();
			System.out.println("");
		
		}
		// Reset the Maze so we can use a new traversal
		restart(cloneMaze());
	}// END BFS
	
}
