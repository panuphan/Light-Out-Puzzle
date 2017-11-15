/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.*;


public class MyGraph {
    
    	private HashMap<Double, int[][]>    AllGrids;      // real objects
	private ArrayList<Double>           GridNumber;		 // graph nodes

	private Graph<Double, DefaultEdge>                       Graph;
	private SimpleGraph<Double, DefaultEdge>                 SG;
	private ConnectivityInspector<Double, DefaultEdge>       conn;
	private KruskalMinimumSpanningTree<Double, DefaultEdge>  MST;
        
        
    public MyGraph(Grid G) {

        AllGrids = new HashMap<>();
        GridNumber = new ArrayList<>();

        double node = 0;
        for (int i = 0; i < G.getGrid().length; i++) {
            for (int j = 0; j < G.getGrid()[i].length; j++) {

                AllGrids.put(node, G.M(i, j));
                GridNumber.add(node);
                node++;

            }
        }

        SG = new SimpleGraph<Double, DefaultEdge>(DefaultEdge.class);
        Graph = (Graph<Double, DefaultEdge>) SG;

        Graphs.addAllVertices(Graph, GridNumber);
        for (int i = 0; i < G.getGrid().length; i++) {
            for (int j = 0; j < G.getGrid()[i].length; j++) {
                Graph.addEdge((double)i, (double)j );
            }
        }
    }
    

        
    
}


