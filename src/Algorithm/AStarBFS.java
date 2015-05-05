package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

import model.Direction;
import model.Node;

public class AStarBFS {
	private Direction[] searchScheme;
    private Queue<Node> fifo;
    private Node workingNode;
	private int iterator =0;
	private HeuristicStrategy algorithm;
	public int przetworzone;
	public int odwiedzone;
	
    public AStarBFS(Direction[] searchScheme, HeuristicStrategy heuristicStrategy) {
		super();
		algorithm = heuristicStrategy;
		this.searchScheme = searchScheme;
		this.fifo = new LinkedList<Node>();
		przetworzone=0;
		odwiedzone=0;
	}

	public void addInitialNode(Node node){
    	fifo.add(node);
    }
    
	
	public void FindSoultionWithoutRecursionByBFS(){
		boolean condition = false;
		
		while(condition==false){
			int wot = FindSoultionByBFSnonRecursive();
			System.out.println("wot = " + wot);
			if (wot==0)
				condition=true;
		}
	}
	
    public int FindSoultionByBFSnonRecursive(){
    	iterator++;
    	System.out.println("Wywoluje sie po raz " + iterator);
    	
    	workingNode=fifo.remove();
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
//    	else if(workingNode.getDeep()==200)
//    	{
//    		System.out.println("Jestem na odpowiedniej glebokosci, nie ma tutaj rozwiazania ide dalej");
//    		return 1;
//    	}
    	else
    	{
    		System.out.println("OTO MOJE GALEZIE PO WYBRANIU NAJLEPSZYCH NAJPIERW");
    		workingNode.CreateBranchesByScheme(searchScheme);
    		for(Node node : algorithm.findSchemeByHeuristic(workingNode.getBranches())){
    			node.getNode().printBoard();
    			System.out.println();
    			przetworzone++;
    			fifo.add(node);
    		}
    		return 2;
    	}
    }
    
    
    
}
