
public class Edge implements Comparable<Edge> {
	
	int src, dest, weight;
	
	/**
	 * Compare function to sort edges by their weight
	 */
	public int compareTo(Edge otherEdge) {
		return this.weight - otherEdge.weight;
	}
}
