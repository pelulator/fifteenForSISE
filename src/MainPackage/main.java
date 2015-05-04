package MainPackage;

import Algorithm.BFS;
import Algorithm.DFS;
import Algorithm.IDFS;
import model.Direction;
import model.Board;
import model.Node;

public class Main {

	public static void main(String[] args) {
		int[][] board = {{16,2,1,4},{5,6,3,8},{9,10,7,12},{13,14,11,15}};
		Board testBoard = new Board(board);
		
		Node testNode = new Node(testBoard,1);
//		Direction[] scheme = {Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP};
		Direction[] scheme = {Direction.LEFT, Direction.RIGHT, Direction.UP, Direction.DOWN};
//		BFS testBFS = new BFS(scheme);
//		testBFS.addInitialNode(testNode);
//		testBFS.FindSoultionWithoutRecursion();
		
//		DFS testDFS = new DFS(scheme);
//		testDFS.addInitialNode(testNode);
//		testDFS.FindSoultionWithoutRecursion();
		
		IDFS testBFS = new IDFS(scheme);
		testBFS.addInitialNode(testNode);
		testBFS.FindSolutionByIDFS(5);
		
		
		
	}

}
