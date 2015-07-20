package Nodes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capgemini.nodes.Graph;
import com.capgemini.nodes.Node;
import com.capgemini.nodes.NodeCycleException;
import com.capgemini.nodes.NodeException;
import com.capgemini.nodes.NodeListPair;
import com.capgemini.nodes.NodeToManySubseqentException;

public class UncorrectGraphTest {
	private Graph graph;
	private Node node1 = new Node("num1", "I'm number1", "");
	private Node node2 = new Node("num2", "I'm number2", "num1");
	private Node node3 = new Node("num3", "I'm number3", "num2");
	private Node node4 = new Node("num4", "I'm number4", "num3");
	private Node node5 = new Node("num5", "I'm number5", "num3");
	private Node node55 = new Node("num55", "I'm number55", "num3");
	private Node node6 = new Node("num6", "I'm number6", "num9");
	private Node node7 = new Node("num7", "I'm number7", "num6");
	private Node node77 = new Node("num77", "I'm number77", "num7");
	private Node node8 = new Node("num8", "I'm number8", "num7");
	private Node node9 = new Node("num9", "I'm number9", "num8");

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void before() {
		List<Node> nodeList = new ArrayList<Node>(Arrays.asList(node1, node2,
				node3, node4, node5, node55, node6, node7, node77, node8, node9));
		graph = new Graph(nodeList);
	}
	@Test
	public void shouldThrowCycleException() throws NodeCycleException{
		thrown.expect(NodeCycleException.class);
		thrown.expectMessage("Graph has a cycle with nodes: num6 num7 num77 num8 num9");
		graph.detectCycle();
	}
	@Test
	public void shouldRecognizeLastNodesNode4_5_8(){
		Assert.assertTrue(graph.isLastNodeOnList(node4) && graph.isLastNodeOnList(node5));
	}
	@Test
	public void shouldThrowToManySubsequentExcption() throws NodeToManySubseqentException {
		thrown.expect(NodeToManySubseqentException.class);
		thrown.expectMessage("num7");
		graph.correctNumberOfSubsequents();
		
	}
	
	@Test
	public void shouldRecognizeNode1IsNotLastNodes(){
		Assert.assertFalse(graph.isLastNodeOnList(node1));
	}
	@Test
	public void shouldClaimAdjacencyListContainsNode1(){
		Assert.assertTrue(graph.adjacencyListContainsNode(node1) != null);
	}
	@Test
	public void shouldNotClaimAdjacencyListContainsNode10(){
		Node node10 = new Node("num10", "I'm number10", "num9");
		Assert.assertFalse(graph.adjacencyListContainsNode(node10) != null);
	}
	@Test
	public void shouldCreateListOfAdjacecyLists() {
		List<List<NodeListPair>> correctList = new ArrayList<List<NodeListPair>>();
		List<NodeListPair> correctSubList1 = new ArrayList<NodeListPair>(Arrays.asList(
				new NodeListPair(node1, new ArrayList<Node>(Arrays.asList(node2))), 
				new NodeListPair(node2, new ArrayList<Node>(Arrays.asList(node3))),
				new NodeListPair(node3, new ArrayList<Node>(Arrays.asList(node4, node5, node55))),
				new NodeListPair(node4, new ArrayList<Node>()),
				new NodeListPair(node5, new ArrayList<Node>()),
				new NodeListPair(node55, new ArrayList<Node>())));
		List<NodeListPair> correctSubList2 = new ArrayList<NodeListPair>(Arrays.asList(
				new NodeListPair(node6, new ArrayList<Node>(Arrays.asList(node7))), 
				new NodeListPair(node7, new ArrayList<Node>(Arrays.asList(node77,node8))),
				new NodeListPair(node77, new ArrayList<Node>()),
				new NodeListPair(node8, new ArrayList<Node>(Arrays.asList(node9))),
				new NodeListPair(node9, new ArrayList<Node>(Arrays.asList(node6)))));
		correctList.add(correctSubList1);
		correctList.add(correctSubList2);
	
		try {
			Field field;
			field = Graph.class.getDeclaredField("adjacencyList");
			field.setAccessible(true);
			List<ArrayList<NodeListPair>> adjacencyList = ((List<ArrayList<NodeListPair>>) field.get(graph));
			Collections.sort(adjacencyList, new Comparator<ArrayList<NodeListPair>>(){
				 public int compare(ArrayList<NodeListPair> a1, ArrayList<NodeListPair> a2) {
				        return  a1.get(0).compareTo(a2.get(0)) ; // assumes you want biggest to smallest
				 }
			});
			for(int i = 0;  i < correctList.size(); ++i){
				for(int j = 0;  j < correctList.get(i).size(); ++j){
					Assert.assertEquals(correctList.get(i).get(j),adjacencyList.get(i).get(j));
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

	}
	
}