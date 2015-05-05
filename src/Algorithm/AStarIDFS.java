package Algorithm;

import java.util.Stack;

import model.Direction;
import model.Node;

public class AStarIDFS {

	private Direction[] searchScheme;
    private Stack<Node> lifo;
    private Node workingNode;
    private Node initialNode;
	private int iterator=0;
	private HeuristicStrategy algorithm;
	public int przetworzone;
	public int odwiedzone;
    public AStarIDFS(Direction[] searchScheme, HeuristicStrategy heuristicStrategy) {
		super();
		this.searchScheme = searchScheme;
		this.lifo = new Stack<Node>();
		algorithm = heuristicStrategy;
		przetworzone=0;
		odwiedzone=0;
	}
    
    public void addInitialNode(Node node){
    	initialNode=node;
    }
    
    public int FindSolutionByIDFS(int maxDepth){
    	for(int i=1; i<maxDepth+1; i++){
    		initialNode.clearBranches();
    		lifo.add(initialNode);
    		if( FindSoultionWithoutRecursion(i)==0)
    			return 0;
    	}
    	return -1;
    }
    
	public int FindSoultionWithoutRecursion(int depth){
		boolean condition = false;
		while(condition==false){
			int wot = FindSoultionByDFSnonRecursive(depth);
			System.out.println("wot = " + wot);
			if (wot==0)
				return 0;
			else if(wot==3){
				return 3;
			}
		}
		return 3;
	}
	
	public int FindSoultionByDFSnonRecursive(int depth){
    	iterator++;
    	System.out.println("Wywoluje sie po raz " + iterator);

    	workingNode=lifo.pop();
    	odwiedzone++;
    	System.out.println("OTO JA, WEZEL");
    	workingNode.getNode().printBoard();
    	System.out.println("Jestem na glebokosci " + workingNode.getDeep());
    	System.out.println();
    	if(workingNode.amILastNode()==true)
    	{
    		System.out.println("Jest KONIEC, paczaj jak wygl¹dam:");
    		workingNode.getNode().printBoard();
    		return 0;
    	}
    	else if(workingNode.getDeep()==depth)
    	{
    		System.out.println("Jestem na odpowiedniej glebokosci, nie ma tutaj rozwiazania, wracam");
    		if(lifo.empty())
    		{
    			System.out.println("Nie ma wiecej wezlow do sprawdzenia");
    			return 3;
    		}
    		return 1;
    	}
    	else
    	{
    		System.out.println("OTO MOJE GALEZIE PO WYBRANIU NAJLEPSZYCH NAJPIERW");
    		workingNode.CreateBranchesByScheme(searchScheme);
    		for(Node node : algorithm.findSchemeByHeuristic(workingNode.getBranches())){
    			node.getNode().printBoard();
    			System.out.println();
    			przetworzone++;
    			lifo.add(node);
    		}
    		return 2;
    	}
    }
	
}
