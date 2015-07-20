package com.capgemini.nodes;



/**
 * Created by ldrygala on 2015-02-09.
 * <p/>
 * Write validate for
 * <ul>
 *     <li>node id should have 4 characters</li>
 *     <li>node description can have maximal 128 characters</li>
 *     <li>no cycle</li>
 *     <li>only penultimate can have two subsequent</li>
 * </ul>
 */
public class NodeBadIDException extends NodeException {

	public NodeBadIDException(String message) {
		super("Node " + message + " has incorrect ID.");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4362383282765558150L;
		
}
