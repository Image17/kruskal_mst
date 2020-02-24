
public class Kruskal {

	/**
	 * Perform Kruskal Minnimum Spanning Tree algorithm
	 * on given graph
	 * @param g
	 */
	public static void kruskal(Graph g) {
		Edge result[] = new Edge[g.v];
		boolean connected = true;

		for (int i = 0; i < g.v; i++) {
			result[i] = new Edge();
		}
		HeapSort.sort(g.edge);

		DisjointSet disjointSet = new DisjointSet(g.v);

		int r = 0, c = 0;

		while (r < g.v - 1) {
			if ((c + 1) == g.edge.length) {
				// failure case here, graph is not connected
				System.out.println("Graph is not connected");
				connected = false;
				break;
			}
			Edge currEdge = g.edge[c++];

			int x = disjointSet.find2(currEdge.src - 1);
			int y = disjointSet.find2(currEdge.dest - 1);

			// only include if this doesn't make a cycle
			if (x != y) {
				result[r++] = currEdge;
				disjointSet.merge(x, y);
			}
		}
		if (connected) {
			int sum = 0;
			for (int i = 0; i < r; ++i) {
				System.out.println(result[i].src + " -> " + result[i].dest + " : weight " + result[i].weight);
				sum += result[i].weight;
			}
			System.out.println(sum);
		}
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}
}
