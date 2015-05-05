package Algorithm;

import java.util.ArrayList;
import java.util.List;

import model.Node;

public class Manhattan implements HeuristicStrategy{

	@Override
	public List<Node> findSchemeByHeuristic(List<Node> nodes) {
		int ytile;
		int xtile;
		List<Node> returnedNodes = new ArrayList<Node>();
		int manhattanPoints[] = {0,0,0,0};
		for(int i=0; i<nodes.size(); i++){
			Node workingNode = nodes.get(i);
			int[][] board = workingNode.getNode().getBoard();
			for (int j=0; j<4; j++){
				for (int k=0; k<4; k++){
					if(board[j][k]==4 || board[j][k]==8 || board[j][k]==12 || board[j][k]==16){
						xtile=3;
						ytile=(board[j][k]/4)-1;
					}
					else
					{
					xtile=board[j][k]-((board[j][k]/4)*4)-1;
					ytile=board[j][k]/4;
					}
					//x=k
					manhattanPoints[i]+=Math.abs(xtile-k)+Math.abs(ytile-j);
				}
			}
		}
		int maxP=0;
		int max=manhattanPoints[0];
		for(int j=0; j<nodes.size(); j++){
		for(int i=0; i<nodes.size()-1; i++){
			if(manhattanPoints[i+1]>=max){
				maxP=i+1;
				max=manhattanPoints[i+1];
			}
		}
		returnedNodes.add(0,nodes.get(maxP));
		manhattanPoints[maxP]=-1;
		max=manhattanPoints[0];
		maxP=0;
		}
		return returnedNodes;
	}

}
