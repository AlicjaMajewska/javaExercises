package com.capgemini.nodes;

import java.util.ArrayList;

public class NodeListPair implements Comparable<NodeListPair> {
	private Node node;
	private ArrayList<Node> nodeList;

	public NodeListPair(Node node, ArrayList<Node> nodeList) {
		this.node = node;
		this.nodeList = nodeList;
	}

	@Override
	public String toString() {
		return "NodeListPair [node=" + node + ", nodeList=" + nodeList + "]";
	}

	public Node getNode() {
		return node;
	}
	public int size(){
		return nodeList.size();
	}
	ArrayList<Node> getNodeList(){
		return nodeList;
	}
	
	public int compareTo(NodeListPair nodeListPair){
		return this.node.getId().compareTo(nodeListPair.node.getId());
	}
	public void addNodeToNodeList(Node node){
		nodeList.add(node);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((node == null) ? 0 : node.hashCode());
		result = prime * result
				+ ((nodeList == null) ? 0 : nodeList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeListPair other = (NodeListPair) obj;
		if (node == null) {
			if (other.node != null)
				return false;
		} else if (!node.equals(other.node))
			return false;
		if (nodeList == null) {
			if (other.nodeList != null)
				return false;
		} else if (!nodeList.equals(other.nodeList))
			return false;
		return true;
	}
	

	


	
	


}