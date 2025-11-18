package graph;

import java.util.ArrayList;
import java.util.List;

/*using AdjacencyList
- Store neighbors as: new Edge(to, weight)
- For Unweighed graphs, weight = 1
- For undirected graphs, add two edges
- For directed graphs, add one edge
*/
public class Graph {

	private int nodes;
	private boolean directed;
	private List<List<Edge>> adjacencyEdgeList;  //Adjacency Edge List 

	public Graph(int nodes, boolean directed) {
		this.nodes = nodes; //number of nodes
		this.directed = directed;
		adjacencyEdgeList = new ArrayList<>();
		
		for(int i = 0; i< nodes; i++) {
			adjacencyEdgeList.add(new ArrayList<>() );
		}
	}
	
	public void addEdge(Edge e) {
		adjacencyEdgeList.get(e.src).add(e); //from src -> des
		if(!directed)
			adjacencyEdgeList.get(e.des).add(new Edge(e.des, e.src, e.weight));
	}

	public void print() {
		for(int i = 0; i < nodes; i++) {
			System.out.print("Node" + i + "->[");
			int size = adjacencyEdgeList.get(i).size();
			int count = 0;
			for(Edge e : adjacencyEdgeList.get(i)) {
				count++;
				System.out.print(e.toString() 
				+(size != count ? ",": "") );
			}
			System.out.println("]");
		}
		System.out.println();
	}
}

class Edge{
	int src;    //u
	int des;    //v
	int weight; //w

	public Edge(int src, int des, int weight) {
		this.src = src;
		this.des = des;
		this.weight = weight; //weighted graph
	}

	public Edge(int src, int des) {
		this.src = src;
		this.des = des;
		this.weight = 1; //Unweighed graph
	}
	
	@Override
	public String toString() {
		return this.des +  ((this.weight != 1)?"(w="+ this.weight + ")" : "");
	}
	
	
}
