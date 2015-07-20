package Nodes;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capgemini.nodes.*;

public class NodeValidatorsTest {
	private Node node1 = new Node("num1", "I'm number1", "");
	private Node node2 = new Node("num2", "I'm number2", "num1");
	private Node node3 = new Node("num3", "I'm number3", "num2");
	private Node node4 = new Node("num4", "I'm number4", "num3");
	private Node node5 = new Node("num5", "I'm number5", "num3");
	

	ArrayList<Node> nodeList;
	private NodeValidators nodeValid;

	@Before
	public void setUp() throws Exception {
		nodeList = new ArrayList<Node>(Arrays.asList(node1, node2, node3,
				node4, node5));
		nodeValid = new NodeValidators(nodeList);
		// graph = new Graph(nodeList);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldNotThrowIsBadIDIfNothingAdded() throws NodePackExcpetion {
		nodeValid.validateMethod(nodeList);
	}

	@Test
	public void shouldThrowToManySubsequencesForNode3() throws NodePackExcpetion {
		
		Node node = new Node("num6", "I'm number6", "num3");
		Node node_2 = new Node("num7", "I'm number7", "num3");
		nodeList.add(node);
		nodeList.add(node_2);
		nodeValid = new NodeValidators(nodeList);
		thrown.expect(NodePackExcpetion.class);
		thrown.expectMessage("num3  has to many subsequent nodes");
		nodeValid.validateMethod(nodeList);
		
	}
	@Test
	public void shouldThrowIsBadIDForNum() throws NodePackExcpetion {

		Node node = new Node("num", "I'm number1", "num2");
		nodeList.add(node);
		thrown.expect(NodePackExcpetion.class);
		thrown.expectMessage("num");
		nodeValid.validateMethod(nodeList);

	}

	@Test
	public void shouldThrowIsBadIDescription() throws NodePackExcpetion {

		Node node = new Node(
				"num6",
				"I'm number...........................................................................................................................",
				"num2");
		nodeList.add(node);
		thrown.expect(NodePackExcpetion.class);
		thrown.expectMessage("........................................................................................");
		nodeValid.validateMethod(nodeList);

	}

	/*
	 * @Test public void shouldNotThrowIsBadID() {
	 * NodeValidators.isBadId(nodeList);
	 * NodeValidators.isBadPredecassorId(nodeList);
	 * NodeValidators.isBadDescription(nodeList); }
	 * 
	 * @Test public void shouldNotThrowIsBadID() {
	 * NodeValidators.isBadId(nodeList);
	 * NodeValidators.isBadPredecassorId(nodeList);
	 * NodeValidators.isBadDescription(nodeList); }
	 * 
	 * @Test public void shouldNotThrowIsBadID() {
	 * NodeValidators.isBadId(nodeList);
	 * NodeValidators.isBadPredecassorId(nodeList);
	 * NodeValidators.isBadDescription(nodeList); }
	 * 
	 * @Test public void shouldNotThrowIsBadID() {
	 * NodeValidators.isBadId(nodeList);
	 * NodeValidators.isBadPredecassorId(nodeList);
	 * NodeValidators.isBadDescription(nodeList); }
	 */

}
