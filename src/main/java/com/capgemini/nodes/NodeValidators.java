package com.capgemini.nodes;

import java.util.List;


/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 * <li>node id should have 4 characters</li>
 * <li>node description can have maximal 128 characters</li>
 * <li>no cycle</li>
 * <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeValidators {
	private Graph graph;
	private NodePackExcpetion exceptionPack;

	public NodeValidators(List<Node> list) {
		graph = new Graph(list);
		exceptionPack = new NodePackExcpetion();
	}

	public void validateMethod(List<Node> nodes) throws NodePackExcpetion {
		isBadId(nodes);
		isBadDescription(nodes);
		
		try {
			graph.correctNumberOfSubsequents();
		} catch (NodeToManySubseqentException manySubsequentException) {
			exceptionPack.addException(manySubsequentException);
		}
		try {
			graph.detectCycle();
		} catch (NodeCycleException cycleException) {
			exceptionPack.addException(cycleException);
		}
		if(exceptionPack.size()!= 0){
			throw exceptionPack;
		}

	}

	public void isBadId(List<Node> nodes) {
		for (Node node : nodes) {
			if (!node.validateId()) {
				exceptionPack
						.addException(new NodeBadIDException(node.getId()));
			}
		}
	}

	public void isBadDescription(List<Node> nodes) {
		for (Node node : nodes) {
			if (!node.validateDescription()) {
				exceptionPack.addException(new NodeBadDescriptionException(node
						.getId() + " " + node.getDescription()));
			}
		}
	}
}
