/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazerunner;


public class Position {
	
	int row, col; 
	
    public Position(int row, int col)
    {
    	this.row = row; 
    	this.col = col;
    }
    

    public Position Up()
    {
    	return new Position(row-1,col);
    }
    public Position Down()
    {
    	return new Position(row+1, col);
    }
    public Position Right()
    {
    	return new Position(row, col+1);
    }
    public Position Left()
    {
    	return new Position(row, col-1);
    }
    


}

