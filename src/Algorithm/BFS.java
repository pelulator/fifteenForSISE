package Algorithm;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

import model.Direction;
import model.Node;

public class BFS {

	private Direction[] searchScheme;
    private Queue<Node> fifo;
    private Node workingNode;
	private int iterator =0;
	public int przetworzone;
	public int odwiedzone;
    public BFS(Direction[] searchScheme) {
		super();
		this.searchScheme = searchScheme;
		this.fifo = new LinkedList<Node>();
		przetworzone=0;
		odwiedzone=0;
	}

	public void addInitialNode(Node node){
    	fifo.add(node);
    }
    
	
	public void FindSoultionWithoutRecursion(){
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
    	try{
    	workingNode=fifo.remove();
    	odwiedzone++;
    	}
    	catch(EmptyStackException e){
    		return 3;
    	}
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
//    	else if(workingNode.getDeep()==4)
//    	{
//    		System.out.println("Jestem na odpowiedniej glebokosci, nie ma tutaj rozwiazania ide dalej");
//    		return 1;
//    	}
    	else
    	{
    		System.out.println("OTO MOJE GALEZIE");
    		workingNode.CreateBranchesByScheme(searchScheme);
    		for(Node node : workingNode.getBranches()){
    			node.getNode().printBoard();
    			System.out.println();
    			przetworzone++;
    			fifo.add(node);
    		}
    		return 2;
    	}
    }
	
    public int FindSoultionByBFS(){
    	iterator++;
    	System.out.println("Wywoluje sie po raz " + iterator);
    	workingNode=fifo.remove();
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
    	else if(workingNode.getDeep()==20)
    	{
        	System.out.println("Jestem na odpowiedniej glebokosci, nie ma tutaj rozwiazania ide dalej");
        	FindSoultionByBFS();
    	}
    	else
    	{
    		System.out.println("OTO MOJE GALEZIE");
    		workingNode.CreateBranchesByScheme(searchScheme);
    		for(Node node : workingNode.getBranches()){
    			node.getNode().printBoard();
    			System.out.println();
    			fifo.add(node);
    		}
    		FindSoultionByBFS();
    	}
    	return 0;
    }
	
}
