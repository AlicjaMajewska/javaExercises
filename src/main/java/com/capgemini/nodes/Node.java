package com.capgemini.nodes;

/**
 * Created by ldrygala on 2015-02-09.
 */
public class Node {
	public static final int SIZE_ID = 4;
	public static final int MAX_DESTRIPTION = 128;
	public static final int MAX_SUBSEQUENT = 2;

	private String id;
	private String description;
	private String predecessorId = "";

	public Node(String id, String description, String predecessorId) {
		this.id = id;
		this.description = description;
		this.predecessorId = predecessorId;
	}
	@Override
	public String toString() {
		return "Node [id=" + id + ", predecessorId=" + predecessorId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((predecessorId == null) ? 0 : predecessorId.hashCode());
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
		Node other = (Node) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (predecessorId == null) {
			if (other.predecessorId != null)
				return false;
		} else if (!predecessorId.equals(other.predecessorId))
			return false;
		return true;
	}
	public boolean validateId() {
		return id.length() == SIZE_ID; 
	}
	public String getId() {
		return id;
	}
	
	
	public String getDescription() {
		return description;
	}
	public boolean validateDescription() {
		return (description.length() < MAX_DESTRIPTION);
	}

	public String getPredecessorId() {
		return predecessorId;
	}


}
