package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private List<Node> nodeList = new ArrayList<Node>();
	private List<List<NodeListPair>> adjacencyList = new ArrayList<List<NodeListPair>>();
	private Map<String, Node> nameNodeMap;

	public Graph(List<Node> nodeList) {
		this.nodeList = nodeList;
		nameNodeMap = new LinkedHashMap<String, Node>(nodeList.size());
		fillMap();
		makeAjacencyList();
		for (List<NodeListPair> nodeListPairList : adjacencyList) {
			Collections.sort(nodeListPairList);
		}
	}

	private void fillMap() {
		for (Node node : nodeList) {
			nameNodeMap.put(node.getId(), node);
		}
	}

	public void detectCycle() throws NodeCycleException {
		NodeCycleException cycleException = new NodeCycleException("");
		for (List<NodeListPair> list : adjacencyList) {
			boolean noFirstNode = true;
			for (NodeListPair nodeListPair : list) {
				if ("".equals(nodeListPair.getNode().getPredecessorId())) {
					noFirstNode = false;
				}
			}
			if (noFirstNode) {
				for (NodeListPair nodeListPair : list) {
					cycleException.addNodeToCycleList(nodeListPair.getNode()
							.getId());
				}
			}
		}
		if (cycleException.getCycleDetected()) {
			throw cycleException;
		}
	}

	public void correctNumberOfSubsequents()
			throws NodeToManySubseqentException {
		String message = new String("");
		for (List<NodeListPair> list : adjacencyList) {
			for (NodeListPair nodeListPair : list) {
				if (nodeListPair.size() > 2) {
					message += (nodeListPair.getNode().getId() + " ");
					continue;
				}
				if (nodeListPair.size() == 2) {
					for (Node node : nodeListPair.getNodeList()) {
						for (NodeListPair nodeListPair2 : list) {
							if (node == nodeListPair2.getNode()
									&& nodeListPair2.size() != 0) {
								message += (nodeListPair.getNode().getId() + " ");
							}
						}
					}
				}
			}
		}
		if (!"".equals(message)) {
			throw new NodeToManySubseqentException(message);
		}

	}

	public void makeAjacencyList() {
		while (!nameNodeMap.isEmpty()) {
			List<NodeListPair> adjacencySubList = new ArrayList<NodeListPair>();
			adjacencyList.add(adjacencySubList);

			Node lastNode = findLastOnMap();
			if (lastNode == null) {
				String lastNodeString = nameNodeMap.entrySet().iterator()
						.next().getKey();
				lastNode = nameNodeMap.remove(lastNodeString);
			}
			adjacencySubList.add(createNodeListPair(lastNode));
			nameNodeMap.remove(lastNode.getId());
			if (createNodeListPairForLast(lastNode) != null) {
				adjacencySubList.add(createNodeListPairForLast(lastNode));
			}
			Node node = lastNode;
			while (node != null && !"".equals(node.getPredecessorId())) {
				// finding parallel nodes
				Node parallelNode = findNextNodeOnMapString(node
						.getPredecessorId());
				while (parallelNode != null) {
					nameNodeMap.remove(parallelNode.getId());
					createNodeListPair(parallelNode);
					if (createNodeListPairForLast(parallelNode) != null) {
						adjacencySubList
								.add(createNodeListPairForLast(parallelNode));
					}
					parallelNode = findNextNodeOnMapString(node
							.getPredecessorId());
				}
				node = nameNodeMap.remove(node.getPredecessorId());
				if (node != null && node.getPredecessorId() != "") {
					adjacencySubList.add(createNodeListPair(node));
				}
			}
		}
	}

	private NodeListPair createNodeListPair(Node node) {
		Node previousNode = nameNodeMap.get(node.getPredecessorId());

		if (previousNode == null) {
			previousNode = findNodeOnList(node.getPredecessorId());
		}
		if (adjacencyListContainsNode(previousNode) == null) {
			ArrayList<Node> nextNodeList = new ArrayList<Node>(
					Arrays.asList(node));
			return new NodeListPair(previousNode, nextNodeList);
		}
		adjacencyListContainsNode(previousNode).addNodeToNodeList(node);
		return null;
	}

	public NodeListPair adjacencyListContainsNode(Node node) {
		for (List<NodeListPair> list : adjacencyList) {
			for (NodeListPair nodeListPair : list) {
				if (nodeListPair.getNode().equals(node)) {
					return nodeListPair;
				}
			}
		}
		return null;
	}

	public Node findLastOnMap() {
		Node lastNode;

		for (Map.Entry<String, Node> entry1 : nameNodeMap.entrySet()) {
			lastNode = entry1.getValue();
			boolean haveNoNext = true;
			for (Map.Entry<String, Node> entry2 : nameNodeMap.entrySet()) {
				if (entry2.getValue().getPredecessorId()
						.equals(lastNode.getId())) {
					haveNoNext = false;
				}
			}
			if (haveNoNext) {
				return lastNode;
			}
		}
		return null;

	}

	private NodeListPair createNodeListPairForLast(Node node) {
		if (isLastNodeOnList(node)) {
			return new NodeListPair(node, new ArrayList<Node>());
		}
		return null;
	}

	public boolean isLastNodeOnList(Node lastNode) {
		for (Node node : nodeList) {
			if (node.getPredecessorId() == lastNode.getId()) {
				return false;
			}
		}
		return true;
	}

	public Node findNextNodeOnMapString(String prevNodeName) {
		for (Map.Entry<String, Node> entry : nameNodeMap.entrySet()) {
			if (entry.getValue().getPredecessorId() == prevNodeName) {
				return entry.getValue();
			}
		}
		return null;
	}

	private Node findNodeOnList(String nodeName) {
		for (Node node : nodeList) {
			if (nodeName.equals(node.getId())) {
				return node;
			}
		}
		return null;
	}

}
