package MainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Algorithm.AStarBFS;
import Algorithm.AStarDFS;
import Algorithm.AStarIDFS;
import Algorithm.BFS;
import Algorithm.DFS;
import Algorithm.IDFS;
import Algorithm.LinearConflict;
import Algorithm.LinearConflictDFS;
import Algorithm.Manhattan;
import model.Direction;
import model.Board;
import model.Node;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		int[][] board = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{16,13,14,15}};
//		Board testBoard = new Board(board);
//		
//		Node testNode = new Node(testBoard,1);
//		Direction[] scheme = {Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP};
//		Direction[] scheme = {Direction.LEFT, Direction.RIGHT, Direction.UP, Direction.DOWN};
		//testNode.CreateBranchesByScheme(scheme);	
		//List<Node> testNodes = testNode.getBranches();
//		BFS testBFS = new BFS(scheme);
//		testBFS.addInitialNode(testNode);
//		testBFS.FindSoultionWithoutRecursion();
		
//		DFS testDFS = new DFS(scheme);
//		testDFS.addInitialNode(testNode);
//		testDFS.FindSoultionWithoutRecursion();
//		
//		IDFS testBFS = new IDFS(scheme);
//		testBFS.addInitialNode(testNode);
//		testBFS.FindSolutionByIDFS(5);
		
//		HeuristicStrategy manhattan = new Manhattan();
//		List<Node> superList = manhattan.findSchemeByHeuristic(testNodes);
//		superList.get(0).getNode().printBoard();
//		superList.get(1).getNode().printBoard();
//		
//		AStarBFS testAStar = new AStarBFS(scheme, new Manhattan());
//		testAStar.addInitialNode(testNode);
//		testAStar.FindSoultionWithoutRecursionByBFS();
//		
//		AStarDFS testAStar = new AStarDFS(scheme, new LinearConflictDFS());
//		testAStar.addInitialNode(testNode);
//		testAStar.FindSoultionWithoutRecursionByDFS();
		
//		AStarIDFS testAStar = new AStarIDFS(scheme, new LinearConflictDFS());
//		testAStar.addInitialNode(testNode);
//		testAStar.FindSolutionByIDFS(10);
		
		
		
	    int[][] board = new int[4][4];
		File file = new File("board.txt");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int j=0;
		    while ((line = br.readLine()) != null) {
		       String[] row = line.split(" ");
		       for (int i=0; i<4; i++){
		    	   int tile = Integer.valueOf(row[i]);
		    	   board[j][i]=tile;
		       }
		       j++;
		    }
		}
		Board testBoard = new Board(board);
		testBoard.printBoard();
		Direction[] scheme;
		Node testNode;
		long startTime;
		long endTime;
		long time;
		
		
		switch(args[0]){
		case "-b":
		case "--bfs":
			System.out.println(args[1]);
			scheme=schemeBuilder.build(args[1]);
			testNode = new Node(testBoard,1);
			BFS testBFS = new BFS(scheme);
			testBFS.addInitialNode(testNode);
			startTime = System.nanoTime();
			testBFS.FindSoultionWithoutRecursion();
			endTime = System.nanoTime();
			time = (endTime - startTime);
			System.out.println("Czas wykonania to: " + time + "nanosekund");
			break;
		case "-d":
		case "--dfs":
			scheme=schemeBuilder.buildForDFS(args[1]);
			Node testNode2 = new Node(testBoard,1);
			DFS testBFS2 = new DFS(scheme);
			testBFS2.addInitialNode(testNode2);
			startTime = System.nanoTime();
			testBFS2.FindSoultionWithoutRecursion();
			endTime = System.nanoTime();
			time = (endTime - startTime);
			System.out.println("Czas wykonania to: " + time + "nanosekund");
			break;
		case "-i":
		case "--idfs":
			scheme=schemeBuilder.buildForDFS(args[1]);
			Node testNode3 = new Node(testBoard,1);
			IDFS testBFS3 = new IDFS(scheme);
			testBFS3.addInitialNode(testNode3);
			startTime = System.nanoTime();
			testBFS3.FindSolutionByIDFS(20);
			endTime = System.nanoTime();
			time = (endTime - startTime);
			System.out.println("Czas wykonania to: " + time + "nanosekund");
			break;
		case "-a":
		case "--a":
			scheme=schemeBuilder.build("LPGD");
			switch(args[1]){
				case "-b":
					switch(args[2]){
					case "-m":
						testNode = new Node(testBoard,1);
						AStarBFS testAStar = new AStarBFS(scheme, new Manhattan());
						testAStar.addInitialNode(testNode);
						startTime = System.nanoTime();
						testAStar.FindSoultionWithoutRecursionByBFS();
						endTime = System.nanoTime();
						time = (endTime - startTime);
						System.out.println("Czas wykonania to: " + time + "nanosekund");
						break;
					case "-lc":
						testNode = new Node(testBoard,1);
						AStarBFS testAStar2 = new AStarBFS(scheme, new LinearConflict());
						testAStar2.addInitialNode(testNode);
						startTime = System.nanoTime();
						testAStar2.FindSoultionWithoutRecursionByBFS();
						endTime = System.nanoTime();
						time = (endTime - startTime);
						System.out.println("Czas wykonania to: " + time + "nanosekund");
						break;
					default:
						System.out.println("Poprawne uzycie programu to: ");
						System.out.println(" 	-b/--bfs porz¹dek 	Strategia przeszukiwania wszerz ");
						System.out.println(" 	-d/--dfs porz¹dek 	Strategia przeszukiwania w g³¹b ");
						System.out.println("	-i/--idfs porz¹dek 	Strategia przeszukiwania w g³¹b z iteracyjnym pog³êbianiem ");
						System.out.println(" 	-a/--a id_strategii id_heurystyki 	Strategia najpierw najlepszy");
						System.out.println("	id_strategii: -b, -d, -i id_heurystyki: -m (manhattan) -lc (linear conflict)");
						
						break;
					}
					break;
				case "-d":
					switch(args[2]){
					case "-m":
						testNode = new Node(testBoard,1);
						AStarDFS testAStar2 = new AStarDFS(scheme, new Manhattan());
						testAStar2.addInitialNode(testNode);
						startTime = System.nanoTime();
						testAStar2.FindSoultionWithoutRecursionByDFS();
						endTime = System.nanoTime();
						time = (endTime - startTime);
						System.out.println("Czas wykonania to: " + time + "nanosekund");
						break;
					case "-lc":
						testNode = new Node(testBoard,1);
						AStarDFS testAStar = new AStarDFS(scheme, new LinearConflictDFS());
						testAStar.addInitialNode(testNode);
						startTime = System.nanoTime();
						testAStar.FindSoultionWithoutRecursionByDFS();
						endTime = System.nanoTime();
						time = (endTime - startTime);
						System.out.println("Czas wykonania to: " + time + "nanosekund");
						break;
					default:
						System.out.println("Poprawne uzycie programu to: ");
						System.out.println(" 	-b/--bfs porz¹dek 	Strategia przeszukiwania wszerz ");
						System.out.println(" 	-d/--dfs porz¹dek 	Strategia przeszukiwania w g³¹b ");
						System.out.println("	-i/--idfs porz¹dek 	Strategia przeszukiwania w g³¹b z iteracyjnym pog³êbianiem ");
						System.out.println(" 	-a/--a id_strategii id_heurystyki 	Strategia najpierw najlepszy");
						System.out.println("	id_strategii: -b, -d, -i id_heurystyki: -m (manhattan) -lc (linear conflict)");
						
						break;
					}
					break;
				case "-i":
					switch(args[2]){
					case "-m":
						testNode = new Node(testBoard,1);
						AStarIDFS testAStar2 = new AStarIDFS(scheme, new Manhattan());
						testAStar2.addInitialNode(testNode);
						startTime = System.nanoTime();
						testAStar2.FindSolutionByIDFS(20);
						endTime = System.nanoTime();
						time = (endTime - startTime);
						System.out.println("Czas wykonania to: " + time + "nanosekund");
						break;
					case "-lc":
						testNode = new Node(testBoard,1);
						AStarIDFS testAStar = new AStarIDFS(scheme, new LinearConflictDFS());
						testAStar.addInitialNode(testNode);
						startTime = System.nanoTime();
						testAStar.FindSolutionByIDFS(20);
						endTime = System.nanoTime();
						time = (endTime - startTime);
						System.out.println("Czas wykonania to: " + time + "nanosekund");
						break;
					default:
						System.out.println("Poprawne uzycie programu to: ");
						System.out.println(" 	-b/--bfs porz¹dek 	Strategia przeszukiwania wszerz ");
						System.out.println(" 	-d/--dfs porz¹dek 	Strategia przeszukiwania w g³¹b ");
						System.out.println("	-i/--idfs porz¹dek 	Strategia przeszukiwania w g³¹b z iteracyjnym pog³êbianiem ");
						System.out.println(" 	-a/--a id_strategii id_heurystyki 	Strategia najpierw najlepszy");
						System.out.println("	id_strategii: -b, -d, -i id_heurystyki: -m (manhattan) -lc (linear conflict)");
						
						break;
					}
					break;
				default:
					System.out.println("Poprawne uzycie programu to: ");
					System.out.println(" 	-b/--bfs porz¹dek 	Strategia przeszukiwania wszerz ");
					System.out.println(" 	-d/--dfs porz¹dek 	Strategia przeszukiwania w g³¹b ");
					System.out.println("	-i/--idfs porz¹dek 	Strategia przeszukiwania w g³¹b z iteracyjnym pog³êbianiem ");
					System.out.println(" 	-a/--a id_strategii id_heurystyki 	Strategia najpierw najlepszy");
					System.out.println("	id_strategii: -b, -d, -i id_heurystyki: -m (manhattan) -lc (linear conflict)");
					
					break;
			}
			break;
		default:
			System.out.println("Poprawne uzycie programu to: ");
			System.out.println(" 	-b/--bfs porz¹dek 	Strategia przeszukiwania wszerz ");
			System.out.println(" 	-d/--dfs porz¹dek 	Strategia przeszukiwania w g³¹b ");
			System.out.println("	-i/--idfs porz¹dek 	Strategia przeszukiwania w g³¹b z iteracyjnym pog³êbianiem ");
			System.out.println(" 	-a/--a id_strategii id_heurystyki 	Strategia najpierw najlepszy");
			System.out.println("	id_strategii: -b, -d, -i id_heurystyki: -m (manhattan) -lc (linear conflict)");
			
			break;
			
		}
		
		
	}

}
