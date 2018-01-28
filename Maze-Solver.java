/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Purpose:
 *   class that contains a single public static method called
 *   "findPath". To involve the method one must have already created
 *   an instance of Maze. The method must return a path through the
 *   maze (if it exists) in the format shown within the Assignment #3
 *   description.
 *
 * Note: You are free to add to this class whatever other methods will
 * help you in writing a solution to A#3 part 2.
 */

 /*
* Name: Ashley Van Spankeren
* Date: Mar. 7/ 2017
* Filename: MazeSolver.java
* Details: \CSC115\ Assignment <3>
*/

public class MazeSolver {

	// takes a maze as a parameter; returns coordinates of path to solve maze
    public static String findPath(Maze maze) {
		boolean[][] path = new boolean[maze.getNumRows()][maze.getNumCols()];
		Stack<MazeLocation> s = new StackRefBased<MazeLocation>();
		s.push(maze.getEntry());
		try{
			// checks that maze isn't empty and end of maze hasn't been reached
			while (emptyMaze(maze) == false && s.peek().equals(maze.getExit()) == false){
				path[s.peek().getRow()][s.peek().getCol()] = true;

				// see if square below has been visited
				if ((s.peek().getRow() != maze.getNumRows() - 1) && (path[s.peek().getRow() + 1][s.peek().getCol()] == false)&& maze.isWall(s.peek().getRow() + 1,s.peek().getCol()) == false){

					s.push(new MazeLocation(s.peek().getRow() + 1, s.peek().getCol()));
				}
				//see if square to the right has been visited
				else if ((s.peek().getCol() != maze.getNumCols() - 1) && (path[s.peek().getRow()][s.peek().getCol() + 1] == false)&& maze.isWall(s.peek().getRow(),s.peek().getCol()+1) == false){

					s.push(new MazeLocation(s.peek().getRow(), s.peek().getCol() + 1));
				}
				//see if square to the left has been visited
				else if ((s.peek().getCol() != 0) && (path[s.peek().getRow()][s.peek().getCol() - 1] == false) && maze.isWall(s.peek().getRow(),s.peek().getCol()-1) == false){

					s.push(new MazeLocation(s.peek().getRow(), s.peek().getCol() - 1));
				}
				// see if square above has been visited
				else if((s.peek().getRow() != 0) && (path[s.peek().getRow() - 1][s.peek().getCol()] == false) && maze.isWall(s.peek().getRow()-1,s.peek().getCol()) == false){

					s.push(new MazeLocation(s.peek().getRow() - 1, s.peek().getCol()));
					}
				// else pop your way back to "fork in road"
				else{
					s.pop();
				}


			}
		}
		catch (StackEmptyException f){
		}
		String coords = "";
		try {
			// stack s has maze locations in reverse; must create new stack with locations in reverse order
			Stack<MazeLocation> temp = new StackRefBased<MazeLocation>();
			while (s.isEmpty() == false){
				temp.push(s.pop());
			}
			coords = temp.toString();
		}
		catch (StackEmptyException k){}

        return coords;
    }


	// returns true if maze is empty, false if otherwise
	public static boolean emptyMaze(Maze m){
		if (m.getNumCols() == 0 && m.getNumRows()==0){
			return true;
		}else
			return false;
	}

	public static void main(String[] args){
	}
}
