package model;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
	private Board Node;
	private int deep;
	public Board getNode() {
		return Node;
	}

	private List<Node> Branches = new ArrayList<Node>();
	
	public int getDeep() {
		return deep;
	}

	public List<Node> getBranches() {
		return Branches;
	}
	
	public boolean amILastNode()
	{
		return Node.amIFinalNode();
	}
	
	public Node(Board node, int deep) {
		super();
		this.deep=deep;
		Node = new Board(node.getBoard());
	}
	
	public void CreateBranchesByScheme(Direction[] scheme){
		for (Direction dir : scheme){
			Board boardToAdd = new Board(this.Node.getBoard());
			try {
				boardToAdd.changeByDirection(dir);
				Branches.add(new Node(boardToAdd,deep+1));
			} catch (WrongDirectionException e) {
				System.out.println("This node isn't exist");
			}
		}
	}
	
	
	
}