
public class DisjointSet {
	SubSet subSets[];

	/**
	 * Public constructor to initialize v subsets where v is the number
	 * of verteces in a graph
	 * @param v
	 */
	public DisjointSet(int v) {
		this.subSets = new SubSet[v];
		for (int i = 0; i < v; ++i) {
			subSets[i] = new SubSet(i, 0);
		}
	}

	/**
	 * Function to return parent of an element in the tree
	 * @param i
	 * @return
	 */
	public int find2(int i) {
		if (subSets[i].parent != i) {
			subSets[i].parent = find2(subSets[i].parent);
		}

		return subSets[i].parent;
	}

	/**
	 * Function to union two sub sets at the roots of x or y
	 * ordering by rank
	 * @param x
	 * @param y
	 */
	public void merge(int x, int y) {
		int xRoot = find2(x);
		int yRoot = find2(y);

		if (subSets[xRoot].rank < subSets[yRoot].rank) {
			subSets[xRoot].parent = yRoot;
		} else if (subSets[xRoot].rank > subSets[yRoot].rank) {
			subSets[yRoot].parent = xRoot;
		} else {
			subSets[yRoot].parent = xRoot;
			subSets[xRoot].rank++;
		}
	}
}
