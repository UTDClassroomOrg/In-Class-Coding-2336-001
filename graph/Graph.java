package graph;

import java.util.*;


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
	
	public void bfs(int start) {
		boolean[] visited = new boolean[nodes];
		int[] parent = new int[nodes];
		Arrays.fill(parent, -1);
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " "); //process u
			
			for(Edge e : adjacencyEdgeList.get(u)) { //check all neighbours
				int v = e.des;
				
				if(!visited[v]) {
					parent[v] = u;
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		
		System.out.println("\nParents: " + Arrays.toString(parent));
		
	}
	
	public void dfs(int start) {
		boolean[] visited = new boolean[nodes];
		int[] parent = new int[nodes];
		Arrays.fill(parent, -1);
		
		dfs(start, visited, parent);
		System.out.println("\nParents: " + Arrays.toString(parent));
	}
	
	
	

	private void dfs(int v, boolean[] visited, int[] parent) {
		visited[v] = true;
		System.out.print(v + " ");// process v (pre-order DFS)
		
		for(Edge e : adjacencyEdgeList.get(v)) {
			int u = e.des;
			if(!visited[u]) {
				parent[u] = v;
				dfs(u, visited, parent);
			}
		}
		//System.out.print(v + " ");// process v (post-order DFS)

	}
	
	
	public void dijkstra(int start) {
	    int[] dist = new int[nodes];
	    int[] parent = new int[nodes];
	    boolean[] visited = new boolean[nodes];

	    Arrays.fill(dist, Integer.MAX_VALUE);
	    Arrays.fill(parent, -1);

	    dist[start] = 0;

	    // Repeat nodes times
	    for (int i = 0; i < nodes; i++) {

	        // 1. Pick the unvisited node with the smallest dist[]
	        int u = -1;
	        int minDist = Integer.MAX_VALUE;

	        for (int v = 0; v < nodes; v++) {
	            if (!visited[v] && dist[v] < minDist) {
	                minDist = dist[v];
	                u = v;
	            }
	        }

	        if (u == -1) break; // no reachable nodes left

	        visited[u] = true;

	        // 2. Relax edges from u
	        for (Edge e : adjacencyEdgeList.get(u)) {
	            int w = e.des;
	            int weight = e.weight;

	            if (!visited[w] && dist[u] + weight < dist[w]) {
	                dist[w] = dist[u] + weight;
	                parent[w] = u;
	            }
	        }
	    }

	    System.out.println("Distances from " + start + ": " + Arrays.toString(dist));
	    System.out.println("Parents (shortest path tree): " + Arrays.toString(parent));
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
