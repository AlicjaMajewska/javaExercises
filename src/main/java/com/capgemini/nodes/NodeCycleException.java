package com.capgemini.nodes;

public class NodeCycleException extends NodeException {
	// List<String> cycleNodeList = new ArrayList<String>();
	private boolean cycleDedected = false;

	public NodeCycleException(String message) {
		super("Graph has a cycle with nodes:");
	}

	public void addNodeToCycleList(String nodeId) {
		super.message += (" " + nodeId);
		cycleDedected = true;
	}

	public boolean getCycleDetected() {
		return cycleDedected;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3921523513749252148L;

}
