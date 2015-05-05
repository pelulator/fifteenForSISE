package Algorithm;

import java.util.ArrayList;
import java.util.List;

import model.Node;

public class LinearConflictDFS implements HeuristicStrategy {

	@Override
	public List<Node> findSchemeByHeuristic(List<Node> nodes) {

		List<Node> returnedNodes = new ArrayList<Node>();
		int linearConflictPoints[] = {0,0,0,0};
		
		for(int i=0; i<nodes.size(); i++){
			Node workingNode = nodes.get(i);
			int[][] board = workingNode.getNode().getBoard();
			for (int j=0; j<4; j++){
				for (int k=0; k<3; k++){
					if(board[j][k]>board[j][k+1])
						linearConflictPoints[i]+=1;
				}
			}
			for (int j=0; j<3; j++){
				for (int k=0; k<4; k++){
					if(board[j][k]>board[j+1][k])
						linearConflictPoints[i]+=1;
				}
			}
		}
		int maxP=0;
		int max=linearConflictPoints[0];
		for(int j=0; j<nodes.size(); j++){
		for(int i=0; i<nodes.size()-1; i++){
			if(linearConflictPoints[i+1]>=max){
				maxP=i+1;
				max=linearConflictPoints[i+1];
			}
		}
		returnedNodes.add(nodes.get(maxP));
		linearConflictPoints[maxP]=-1;
		max=linearConflictPoints[0];
		maxP=0;
		}
		return returnedNodes;
	}
}