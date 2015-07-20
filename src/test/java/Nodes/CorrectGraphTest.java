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
import com.capgemini.nodes.NodeListPair;
import com.capgemini.nodes.NodeToManySubseqentException;

public class CorrectGraphTest {
	private Graph graph;
	private Node node1 = new Node("num1", "I'm number1", "");
	private Node node2 = new Node("num2", "I'm number2", "num1");
	private Node node3 = new Node("num3", "I'm number3", "num2");
	private Node node4 = new Node("num4", "I'm number4", "num3");
	private Node node5 = new Node("num5", "I'm number5", "num3");
	private Node node6 = new Node("num6", "I'm number6", "");
	private Node node7 = new Node("num7", "I'm number7", "num6");
	private Node node8 = new Node("num8", "I'm number8", "num7");

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void before() {
		List<Node> nodeList = new ArrayList<Node>(Arrays.asList(node1, node2,
				node3, node4, node5, node6, node7, node8));
		graph = new Graph(nodeList);
	}
	
	@Test
	public void shouldRecognizeLastNodesNode4_5_8(){
		Assert.assertTrue(graph.isLastNodeOnList(node4) && graph.isLastNodeOnList(node5) && ( graph.isLastNodeOnList(node8)));
	}
	@Test
	public void shouldNotThrowCycleException() throws NodeCycleException{
		graph.detectCycle();
	}
	@Test
	public void shouldNotThrowToManySubsequentExcption() throws NodeToManySubseqentException {
		graph.correctNumberOfSubsequents();
	}
	@Test
	public void shouldRecognizeNode1IsNotLastNodes(){
		Assert.assertFalse(graph.isLastNodeOnList(node1));
	}
	@Test
	public void shouldCreateListOfAdjacecyLists() {
		List<List<NodeListPair>> correctList = new ArrayList<List<NodeListPair>>();
		List<NodeListPair> correctSubList1 = new ArrayList<NodeListPair>(Arrays.asList(
				new NodeListPair(node1, new ArrayList<Node>(Arrays.asList(node2))), 
				new NodeListPair(node2, new ArrayList<Node>(Arrays.asList(node3))),
				new NodeListPair(node3, new ArrayList<Node>(Arrays.asList(node4, node5))),
				new NodeListPair(node4, new ArrayList<Node>()),
				new NodeListPair(node5, new ArrayList<Node>())));
		List<NodeListPair> correctSubList2 = new ArrayList<NodeListPair>(Arrays.asList(
				new NodeListPair(node6, new ArrayList<Node>(Arrays.asList(node7))), 
				new NodeListPair(node7, new ArrayList<Node>(Arrays.asList(node8))),
				new NodeListPair(node8, new ArrayList<Node>())));
		correctList.add(correctSubList1);
		correctList.add(correctSubList2);
	
		try {
			Field field;
			field = Graph.class.getDeclaredField("adjacencyList");
			field.setAccessible(true);
			List<ArrayList<NodeListPair>> adjacencyList = (List<ArrayList<NodeListPair>>) field.get(graph);
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

	
//	@Test
//	public void shouldDisplayList() {
//
//		System.out.println("***********************************");
//		// graph.displayAdjacencyList();
//		System.out.println("***********************************");
//		Assert.assertTrue(true);
//	}
	//
	// @Test
	// public void shouldBeLastNodeForNum4() {
	//
	// try {
	// Assert.assertTrue(graph.isLastNode(node4));
	// } catch (NoNodeOnListException e) {
	// e.what();
	// }
	// }
	//
	// @Test
	// public void shouldBeLastNodeForNum5() {
	//
	// try {
	// Assert.assertTrue(graph.isLastNode(node5));
	// } catch (NoNodeOnListException e) {
	// e.what();
	// }
	// }
	//
	// @Test
	// public void shouldNotBePenultimateForNum4() {
	//
	// try {
	// Assert.assertFalse(graph.isPenultimateNode(node4));
	// } catch (NoNodeOnListException e) {
	// e.what();
	// }
	// }
	//
	// @Test
	// public void shouldNotBePenultimateForNum1() {
	//
	// try {
	// Assert.assertFalse(graph.isPenultimateNode(node1));
	// } catch (NoNodeOnListException e) {
	// e.what();
	// }
	// }
	//
	// @Test
	// public void shouldBePenultimateForNum3() {
	//
	// try {
	// Assert.assertTrue(graph.isPenultimateNode(node3));
	// } catch (NoNodeOnListException e) {
	// e.what();
	// }
	// }
	//
	// @Test
	// public void shouldNotBePenultimateForNum2() {
	// Node node6 = new Node("num6", "I'm number6", "num4");
	// graph.addNode(node6);
	// // graph.displayAdjacencyList();
	// try {
	// Assert.assertFalse(graph.isPenultimateNode(node3));
	// } catch (NoNodeOnListException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void shouldFindLastNode() {
	// Assert.assertTrue(node3.equals(graph.findLast())
	// || node4.equals(graph.findLast()));
	// }
	//
	// @Test
	// public void shouldAddNewNodeToAdjList() {
	// Node node9 = new Node("num9", "I'm number9", "num8");
	// graph.addNode(node9);
	// //graph.displayAdjacencyList();
	// Assert.assertEquals(9, graph.getAdjacencyList().size());
	// }
	//
	// @Test
	// public void shouldAddNewNodeToNodeList() {
	// Node node9 = new Node("num9", "I'm number9", "num8");
	// int size = graph.getNodeList().size();
	// graph.addNode(node9);
	// Assert.assertNotEquals(size, graph.getNodeList().size());
	// }

}
