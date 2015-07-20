package com.capgemini.nodes;

public class NodeToManySubseqentException extends NodeException {

	public NodeToManySubseqentException(String message) {
		super("Node " + message + " has to many subsequent nodes ");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3953719334455091665L;

}
