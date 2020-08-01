import java.util.*;

// Implementing the remote interface 
public class QueryMinSpanTree implements MinSpanTree {  

	// creating the list of graphs
	private Map<String, Integer > graph_id = new HashMap<String,Integer>();

	// Creating the list of edges of graph
	private Map< String, ArrayList<Integer[]> > graphs  = new HashMap< String, ArrayList<Integer[]> >();
	private Map< String,Integer[]> par = new HashMap< String,Integer[]>();
	@Override
	public void add_graph(String s, Integer n)
	{
		// Adding the graph to the list of graphs
		graph_id.put(s,n);
		ArrayList<Integer[]> edges = new ArrayList<Integer[]>();
		graphs.put(s,edges);
		par.put(s,new Integer[n+1]);


	}

	@Override
	public void add_edge(String s, Integer source, Integer destination, Integer weight) 
    {  
    	Integer[] edge = new Integer[3];
    	edge[0] = source;
    	edge[1] = destination;
    	edge[2] = weight;

    	ArrayList<Integer[]> edges = graphs.get(s);

    	edges.add(edges.size(), edge);
    	graphs.put(s, edges);

    } 

    public void merge(String s,Integer n1, Integer n2) {
    	int root1 = root(s,n1);
    	int root2 = root(s,n2);
    	if(root1 != root2) {
    		if(root1 < root2) {
    			par.get(s)[root2] = root1;
    		}
    		else {
    			par.get(s)[root1] = root2;

    		}
    	}
    }

    public int root(String s, Integer node) {
    	while(node != par.get(s)[node]) {
    		node = par.get(s)[node];
    	}
    	return node;
    }


	@Override
    public int get_mst(String s){
    	int nodes=graph_id.get(s);
    	for(int i=1; i<=nodes; i++) {
    		par.get(s)[i]=i;
    	}

    	ArrayList<Integer[]> edges = graphs.get(s);

    	Collections.sort(edges, new Comparator<Integer[]>(){
    		@Override
    		public int compare(Integer[] a, Integer[] b){
    			return a[2].compareTo(b[2]);
    		}
    	});

    	int mst_weight = 0;
    	int edge_count = 0;

    	for(int i = 0; i<edges.size(); i++){
    		
    		int node1 = edges.get(i)[0];
    		int node2 = edges.get(i)[1];
    		int weight = edges.get(i)[2];

    		if(root(s,node1) != root(s,node2)){
    			edge_count++;
    			mst_weight += weight;
    			merge(s, node1, node2);
    		}

    	}

    	if(edge_count == graph_id.get(s) - 1){
    		return mst_weight;
    	}
    	return -1;

    	//Sort edges by weight

    	//Detect cycles ?

    }

	// Implementing the interface method 
}