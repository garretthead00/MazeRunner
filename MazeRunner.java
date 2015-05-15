
package mazerunner;

/**
 *
 * @author Garrett
 */
public class MazeRunner {


	
	public static void main(String[] args) {
		
		
		char[][] Maze = 
			{
		    	{'X','X','X','X','X','X','X','X','X'}, 
		    	{'X','S','X','X','X','X',' ','X','X'},
		    	{'X',' ',' ',' ',' ',' ',' ',' ','X'},
		    	{'X',' ','X','X','X','X','X',' ','X'}, 
		    	{'X',' ',' ',' ',' ','X','X',' ','X'},
		    	{'X','X','X','X',' ','X',' ','X','X'},
		    	{'X','X',' ',' ',' ',' ',' ','X','X'},
		    	{'X','X','X','X','X','X','E','X','X'},
		    };
		
		char[][] Maze2 = 
			{
		    	{'X','X','X','X','X','X','X','X','X'}, 
		    	{'X','S','X','X','X','X',' ','X','X'},
		    	{'X',' ',' ',' ',' ',' ',' ',' ','X'},
		    	{'X',' ','X','X','X','X','X',' ','E'}, 
		    	{'X',' ',' ',' ',' ','X','X',' ','X'},
		    	{'X','X','X','X',' ','X',' ','X','X'},
		    	{'X','X',' ',' ',' ',' ',' ','X','X'},
		    	{'X','X','X','X','X','X','X','X','X'},
		    };
		


		Maze maze = new Maze(Maze);
		System.out.println("____MAZE RUNNER____");
		maze.buildMaze();
		maze.getCoordinates();
		System.out.println("\nEscape Maze 1 using DPS");
		maze.DPS();
		System.out.println("\nEscape Maze 1 using BPS");
		maze.BPS();
		
		Maze maze2 = new Maze(Maze2);
		System.out.println("____MAZE RUNNER____");
		maze2.buildMaze();
		maze2.getCoordinates();
		System.out.println("\nEscape Maze 2 using DPS");
		maze2.DPS();
		System.out.println("\nEscape Maze 2 using BPS");
		maze2.BPS();

	}

}

