package com.capgemini.nodes;

public class NodeBadDescriptionException extends NodeException{

	public NodeBadDescriptionException(String message) {
		super("Node " + message + " has incorrect description.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2144026366494357731L;

	
}
