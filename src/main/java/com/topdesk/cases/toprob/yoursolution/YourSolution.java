package com.topdesk.cases.toprob.yoursolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.topdesk.cases.toprob.Coordinate;
import com.topdesk.cases.toprob.Grid;
import com.topdesk.cases.toprob.Instruction;
import com.topdesk.cases.toprob.Solution;
import com.topdesk.cases.toprob.helper.GridFactory;

public class YourSolution implements Solution {

	public YourSolution() {
		Grid table = GridFactory.create(
						".rBA......",
						"...o......",
						"......oko.",
						"..o.......",
						"..........",
						"..........",
						"..........",
						"..........",
						"..........",
						"..........");
		System.out.println(SearchPath(table));


	}


	public ArrayList<Coordinate> SearchPath(Grid table) {

		ArrayList<Coordinate> open = new ArrayList<>(); //list of open cells
		ArrayList<Coordinate> closed = new ArrayList<>();//list of closed cells
		ArrayList path = new ArrayList(); //will hold the path once found

		open.add(table.getRoom());
		Coordinate current = table.getRoom();

		while (!open.isEmpty()) {
			Coordinate n = Instruction.NORTH.execute(current);
			Coordinate w = Instruction.WEST.execute(current);
			Coordinate s = Instruction.SOUTH.execute(current);
			Coordinate e = Instruction.EAST.execute(current);

			if (current.equals(table.getKitchen())) {
				return path;
			} else if (isHole(n, table) && isItNotEdge(n, table) && !closed.contains(n) ) {
					open.remove(current);
					closed.add(current);
					open.add(n);
					System.out.println("új FEL");
					current = closest(current, table, open);
					path.add(current);
			} else if (isHole(w, table) && isItNotEdge(w, table) && !closed.contains(w)) {
					open.remove(current);
					closed.add(current);
					open.add(w);
					System.out.println("új BAL");
					current = closest(current, table, open);
					path.add(current);
			} else if (isHole(s, table) && isItNotEdge(s, table) && !closed.contains(s)){
					open.remove(current);
					closed.add(current);
					open.add(s);
					System.out.println("új LE");
					current = closest(current, table, open);
					path.add(current);
			} else if (isHole(e, table) && isItNotEdge(e, table) && !closed.contains(e)){
					open.remove(current);
					closed.add(current);
					open.add(e);
					System.out.println("új JOBB");
					current = closest(current, table, open);
					path.add(current);
				}else{
				return path;
			}
			} return path;
		}


//		int[][] grid = new int[table.getWidth()][table.getHeight()]; //grid of cells
//		int startRow = table.getRoom().getX();
//		int startCol = table.getRoom().getY();
//
//		int endRow = table.getKitchen().getX();
//		int endCol = table.getKitchen().getY();
//		boolean pathFound = false;
//		//private AStarCell current; //current cell
//
//		open.add(grid[startRow][startCol]); //add the starting cell to the open list
//		current = open.get(0); //set the current cell to the starting cell
//
//		while(!pathFound && open.size()>0){
//				//loop through the open array list, find the cell with the lowest cost
//			for(int i = 0; i < open.size(); i++){
//				if(open.get(i).getFinalCost() < current.getFinalCost()){
//					current = open.get(i);
//					}
//			}
//				//remove the found cell from the open list
//			open.remove(current);
//				//add the cell to the closed list
//			closed.add(current);
//
//				//check if a path has been found
//			if(current.getRow() == endRow && current.getCol() == endCol){
//				pathFound = true;
//				constructPath();
//				}
//				//consider each vertical and horizontal neighbor of the current cell
//				consider(grid[current.getRow()-1][current.getCol()]);
//				consider(grid[current.getRow()+1][current.getCol()]);
//				consider(grid[current.getRow()][current.getCol()-1]);
//				consider(grid[current.getRow()][current.getCol()+1]);
//			}
//

	@Override
	public List<Instruction> solve(Grid grid, int time) {
		List<Instruction> instructionList = new ArrayList<>();
		return instructionList;
	}

	public boolean isHole(Coordinate field, Grid grid) {
		if (!grid.getHoles().contains(field)) {
			return true;
		}
		return false;
	}

	public boolean isItNotEdge(Coordinate field, Grid grid) {
		if (field.getX() >= 0 && field.getX() <= grid.getWidth()-1 && field.getY() >= 0 && field.getY() <= grid.getHeight()-1) {
			return true;
		}
		return false;
	}

	public Coordinate closest(Coordinate actual, Grid table, ArrayList<Coordinate> open) {
		Coordinate temp = actual;

		for (int i = 0; i < open.size(); i++) {
			if (Math.sqrt((table.getKitchen().getY() - open.get(i).getY()) * (table.getKitchen().getY() - open.get(i).getY())
							+ (table.getKitchen().getX() - open.get(i).getX()) * (table.getKitchen().getX() - open.get(i).getX())) <=
							Math.sqrt((table.getKitchen().getY() - temp.getY()) * (table.getKitchen().getY() - temp.getY())
											+ (table.getKitchen().getX() - temp.getX()) * (table.getKitchen().getX() - temp.getX()))) {
				temp = open.get(i);
			}

		}
		return temp;
	}




//
//	public boolean isItKitchen(Coordinate field, Grid grid){
//		if (field.equals(grid.getKitchen())){
//			return true;
//		} return false;
//	}


	public static void main(String[] args) {
		new YourSolution();
	}
}

	//-------------------------------------------------------------------



//	private void consider(AStarCell passedCell){
//		//if the neighbor cell is not passable or is already on the closed list, skip it
//		if(!passedCell.getIsPassable() || closed.contains(passedCell)){
//			return;
//		}


		//calculate the path cost of reaching the neighbor
		//if the cost is less than the cost known for this location then remove it from
		//the open or closed lists (since you've found a better route)
		//if the location isn't in either the open or closed list then record the costs for the
		//location and add it to the open list
		//record the parent for this cell

//	}
//
//	private void constructPath(){
//		//once a path has been found, trace it backwards adding each step to the path ArrayList
//	}



