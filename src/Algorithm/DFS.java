package Algorithm;

import java.util.EmptyStackException;
import java.util.Stack;

import model.Direction;
import model.Node;

public class DFS {
	
	private Direction[] searchScheme;
    private Stack<Node> lifo;
    private Node workingNode;
	private int iterator=0;
	
    public DFS(Direction[] searchScheme) {
		super();
		this.searchScheme = searchScheme;
		this.lifo = new Stack<Node>();
	}

	public void addInitialNode(Node node){
    	lifo.add(node);
    }
    
	public void FindSoultionWithoutRecursion(){
		boolean condition = false;
		while(condition==false){
			int wot = FindSoultionByDFSnonRecursive();
			System.out.println("wot = " + wot);
			if (wot==0)
				condition=true;
		}
	}
	
    public int FindSoultionByDFSnonRecursive(){
    	iterator++;
    	System.out.println("Wywoluje sie po raz " + iterator);
    	try{
    	workingNode=lifo.pop();
    	}
    	catch(EmptyStackException e)
    	{
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
    	else if(workingNode.getDeep()==5)
    	{
    		System.out.println("Jestem na odpowiedniej glebokosci, nie ma tutaj rozwiazania, wracam");
    		return 1;
    	}
    	else
    	{
    		System.out.println("OTO MOJE GALEZIE");
    		workingNode.CreateBranchesByScheme(searchScheme);
    		for(Node node : workingNode.getBranches()){
    			node.getNode().printBoard();
    			System.out.println();
    			lifo.add(node);
    		}
    		return 2;
    	}
    }
	
    public int FindSoultionByDFS(){
    	iterator++;
    	System.out.println("Wywoluje sie po raz " + iterator);
    	workingNode=lifo.pop();
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
    	else if(workingNode.getDeep()==3)
    	{
    		System.out.println("Jestem na odpowiedniej glebokosci, nie ma tutaj rozwiazania, wracam");
    		FindSoultionByDFS();
    	}
    	else
    	{
    		System.out.println("OTO MOJE GALEZIE");
    		workingNode.CreateBranchesByScheme(searchScheme);
    		for(Node node : workingNode.getBranches()){
    			node.getNode().printBoard();
    			System.out.println();
    			lifo.add(node);
    		}
    		FindSoultionByDFS();
    	}
    	return 0;
    }
    
}
