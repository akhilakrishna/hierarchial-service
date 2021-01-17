package com.hierarchical.dto;

import java.util.List;

public class Node {

	private String parentId;
	private String nodeId;
	private String nodeName;
	private List<Node> childs;
	
	public Node() {}
	public Node(String parentId, String nodeId, String nodeName, List<Node> childs) {
		super();
		this.parentId = parentId;
		this.nodeId = nodeId;
		this.nodeName = nodeName;
		this.childs = childs;
	}
	public Node(String parentId, String nodeId, String nodeName) {
		super();
		this.parentId = parentId;
		this.nodeId = nodeId;
		this.nodeName = nodeName;
	}
	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * @return the nodeId
	 */
	public String getNodeId() {
		return nodeId;
	}
	/**
	 * @param nodeId the nodeId to set
	 */
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	/**
	 * @return the nodeName
	 */
	public String getNodeName() {
		return nodeName;
	}
	/**
	 * @param nodeName the nodeName to set
	 */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/**
	 * @return the childs
	 */
	public List<Node> getChilds() {
		return childs;
	}
	/**
	 * @param childs the childs to set
	 */
	public void setChilds(List<Node> childs) {
		this.childs = childs;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [parentId=" + parentId + ", nodeId=" + nodeId + ", nodeName=" + nodeName + ", childs=" + childs
				+ "]";
	}
	
}
