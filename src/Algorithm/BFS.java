package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

import model.Direction;
import model.Node;

public class BFS {

	private Direction[] searchScheme;
    private Queue<Node> fifo;
    private Node workingNode;
	private int iterator =0;
    public BFS(Direction[] searchScheme) {
		super();
		this.searchScheme = searchScheme;
		this.fifo = new LinkedList<Node>();
	}

	public void addInitialNode(Node node){
    	fifo.add(node);
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
