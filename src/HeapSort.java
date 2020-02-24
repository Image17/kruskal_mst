
public class HeapSort {

	/**
	 * Heap Sort array of Edge objects and call heapify
	 * on edges
	 * 
	 * @param edges
	 */
	public static void sort(Edge edges[]) {
		int n = edges.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(edges, n, i);
		}

		for (int i = n - 1; i >= 0; i--) {
			Edge temp = edges[0];
			edges[0] = edges[i];
			edges[i] = temp;

			heapify(edges, i, 0);
		}
	}

	/**
	 * Recursively heapify subtree of edges with root i to a heap of size n
	 * 
	 * @param edges
	 * @param n
	 * @param i
	 */
	private static void heapify(Edge edges[], int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && edges[l].compareTo(edges[largest]) > 0) {
			largest = l;
		}
		
		if (r < n && edges[r].compareTo(edges[largest]) > 0) {
			largest = r;
		}

		if (largest != i) {
			Edge swap = edges[i];
			edges[i] = edges[largest];
			edges[largest] = swap;

			heapify(edges, n, largest);
		}
	}
}
