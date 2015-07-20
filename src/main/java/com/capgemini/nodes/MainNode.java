package com.capgemini.nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainNode {
	public static void main(String args[]){
		Node node1 = new Node("num1", "I'm number1", "");
		Node node2 = new Node("num2", "I'm number2", "num1");
		Node node3 = new Node("num3", "I'm number3", "num2");
		Node node4 = new Node("num4", "I'm number4", "num3");
		Node node5 = new Node("num5", "I'm number5", "num3");
		Node node55 = new Node("num55", "I'm number55", "num3");
		Node node6 = new Node("num6", "I'm number6", "num9");
		Node node7 = new Node("num7", "I'm number7", "num6");
		Node node77 = new Node("num77", "I'm number................................................................................................................................", "num7");
		Node node8 = new Node("num8", "I'm number8", "num7");
		Node node9 = new Node("num9", "I'm number9", "num8");
		List<Node> nodeList = new ArrayList<Node>(Arrays.asList(node1, node2,
				node3, node4, node5, node55, node6, node7, node77, node8, node9));
		NodeValidators nodeValidator = new NodeValidators(nodeList);
		try {
			nodeValidator.validateMethod(nodeList);
		} catch (NodePackExcpetion e) {
			System.out.println(e.getMessage());
		}
		
	} 

}
