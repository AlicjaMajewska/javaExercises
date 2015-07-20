package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.List;

public class NodePackExcpetion extends Exception {
	private List<NodeException> exceptions = new ArrayList<NodeException>();

	public NodePackExcpetion() {
	}

	public void addException(NodeException exception){
		exceptions.add(exception);
	}
	public int size(){
		return exceptions.size();
	}
	public String getMessage() {
		String message = new String("");
		for (NodeException nodeException : exceptions) {
			message += (nodeException.getMessage() +"\n");
		}
		return message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7744341895621105300L;

}
