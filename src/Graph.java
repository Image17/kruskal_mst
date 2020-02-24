
public class Graph {
	
    int v, e;
    Edge edge[];
    
    /**
     * Public constructor to initialize a graph
     * with v vertices and e edges
     * @param v
     * @param e
     */
    public Graph(int v, int e) 
    { 
        this.v = v; 
        this.e = e; 
        edge = new Edge[e]; 
        for (int i=0; i<e; ++i) 
            edge[i] = new Edge(); 
    } 

}
