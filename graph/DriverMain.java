package graph;

public class DriverMain {

	public static void main(String[] args) {
//		Graph g = new Graph(5, false);
//		g.addEdge(new Edge(0, 1, 1));
//		g.addEdge(new Edge(0, 2, 1));
//		g.addEdge(new Edge(0, 3, 1));
////		g.addEdge(new Edge(1, 0, 1));
//		g.addEdge(new Edge(1, 2, 1));
//		g.addEdge(new Edge(1, 4, 1));
////		g.addEdge(new Edge(2, 0, 1));
////		g.addEdge(new Edge(2, 1, 1));
//		g.addEdge(new Edge(2, 3, 1));
////		g.addEdge(new Edge(3, 0, 1));
////		g.addEdge(new Edge(3, 2, 1));
//		g.addEdge(new Edge(3, 4, 1));
////		g.addEdge(new Edge(4, 1, 1));
////		g.addEdge(new Edge(4, 3, 1));
//		g.print();
		
		Graph g = new Graph(5, false);
		g.addEdge(new Edge(0, 1));
		g.addEdge(new Edge(0, 2));
		g.addEdge(new Edge(0, 3));
		g.addEdge(new Edge(1, 2));
		g.addEdge(new Edge(1, 4));
		g.addEdge(new Edge(2, 3));
		g.addEdge(new Edge(3, 4));
		g.print();
		
		Graph g1 = new Graph(5, true);
		g1.addEdge(new Edge(0, 1, 16));
		g1.addEdge(new Edge(0, 3, 2));
		g1.addEdge(new Edge(0, 4, 3));
		g1.addEdge(new Edge(1, 2, 5));
		g1.addEdge(new Edge(2, 1, 3));
		g1.addEdge(new Edge(3, 1, 12));
		g1.addEdge(new Edge(3, 4, 7));
		g1.addEdge(new Edge(4, 1, 10));
		g1.addEdge(new Edge(4, 2, 4));
		g1.addEdge(new Edge(4, 3, 5));
		g1.print();
	 
	}
	
}
