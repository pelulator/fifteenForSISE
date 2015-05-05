package Algorithm;

import java.util.List;

import model.Node;

public interface HeuristicStrategy {

	List<Node> findSchemeByHeuristic(List<Node> nodes);
	
}
