package com.hierarchical;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.hierarchical.dto.Node;

public class HierarchicalApplication {

	private static String INDENTATION = "  ";
	private static String PERSON_SEPARATOR = "\\|";
	private static String ATTRIBUTE_SEPARATOR = ",";
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.println("Enter input String:");
	    String input = scanner.nextLine();  

		try {
			String[] persons = input.split(PERSON_SEPARATOR);
			List<Node> nodes = new ArrayList<Node>();
			Node root = null;
			for (String person : persons) {
				String[] nodeElement = person.split(ATTRIBUTE_SEPARATOR);
				if(nodeElement.length>2) {
					Node node = new Node(nodeElement[0], nodeElement[1], nodeElement[2]);
					if ("null".equals(nodeElement[0])) {
						root = node;
					}
					nodes.add(node);
				}
			}
			if(root==null) {
				System.out.println("No Root Node Found, Please provide valid Input");
				System.exit(1);
			}
			System.out.println(root.getNodeName());
			root = printChilds(nodes, root);
		}catch(Exception e) {
			System.err.println("Please provide valid Input");
		}
		finally {
			scanner.close();
		}
		
	}

	private static Node printChilds(List<Node> nodes, Node node) {
		List<Node> childs = nodes.stream().filter(x -> x.getParentId().equals(node.getNodeId()))
				.collect(Collectors.toList());
		if (isInteger(node.getParentId())) {
			int distance=distanceFromRoot(node.getParentId(), nodes, 0)+1;
			String spacebar = repeat(INDENTATION,distance);
			System.out.println(spacebar + node.getNodeName());
		}
		if (childs != null && childs.size() > 0) {
			node.setChilds(childs);
			for (Node child : childs) {
				printChilds(nodes, child);
			}
		}
		return node;
	}

	private static String repeat(String input, int numberOfRepeatativeOccurance) {
		return Stream.generate(() -> input).limit(numberOfRepeatativeOccurance).collect(Collectors.joining(""));
	}
	
	private static boolean isInteger(String input) {
	    try { 
	        Integer.parseInt(input); 
	    } catch(Exception e) { 
	        return false; 
	    } 
	    return true;
	}
	
	private static int distanceFromRoot(String parentId, List<Node> nodes, int distance) {
		List<Node> nodeList =nodes.stream().filter(x -> x.getNodeId().equals(parentId)).collect(Collectors.toList());
		Node node=nodeList.get(0);
		if(!"null".equals(node.getParentId())) {
			++distance;
			distance=distanceFromRoot(node.getParentId(), nodes, distance);
		}
		return distance;
	}
}
