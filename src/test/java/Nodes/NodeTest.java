package Nodes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.capgemini.nodes.Node;

public class NodeTest {
	private Node node1;
	private Node node2;
	private Node node3;

	@Before
	public void setUp() {
		node1 = new Node("num1", "is first node", "");
		node2 = new Node("num22", "second node", "num1");
		node3 = new Node(
				"num3",
				"i am number three and i am very very very very proud of this, it is amazing to be me, how long should i be talking to fill this 128 length description limit?????",
				"num22");
	}

	@Test
	public void shouldFindPredecassor() {
		Assert.assertEquals(node1.getId(), node2.getPredecessorId());
	}

	@Test
	public void shouldBeEquals() {
		Node node22 = new Node("num22", "second node", "num1");
		Assert.assertEquals(node22, node2);
	}
	@Test
	public void shouldNotBeEqualsALthoughAlmostEquals() {
		Node node22 = new Node("num22", "second node2", "num1");
		Assert.assertNotEquals(node22, node2);
	}

	@Test
	public void shouldNotBeEquals() {
		Assert.assertNotEquals(node3, node2);
	}

	@Test
	public void shouldDetectBadIdForNode2() {
		Assert.assertFalse(node2.validateId());
	}

	@Test
	public void shouldNotDetectBadIdForNode1() {
		Assert.assertTrue(node1.validateId());
	}

	@Test
	public void shouldDetectBadDescriptionForNode3() {
		Assert.assertFalse(node3.validateDescription());
	}

	@Test
	public void shouldNotDetectBadDescriptionForNode1() {
		Assert.assertTrue(node1.validateDescription());
	}

}
