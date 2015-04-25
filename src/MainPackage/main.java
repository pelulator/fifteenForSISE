package MainPackage;

import Algorithm.BFS;
import model.Direction;
import model.Board;
import model.Node;
import model.WrongDirectionException;

public class main {

	public static void main(String[] args) {
		int[][] board = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,16,15,14}};
		Board testBoard = new Board(board);
		
		Node testNode = new Node(testBoard,1);
		Direction[] scheme = {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT};
		BFS testBFS = new BFS(scheme);
		testBFS.addInitialNode(testNode);
		testBFS.FindSoultionByBFS();
		
	}

}
