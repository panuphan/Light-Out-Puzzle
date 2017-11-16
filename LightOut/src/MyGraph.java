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
        protected DijkstraShortestPath<Double, DefaultEdge>         DSP;
        
        
    public MyGraph(Grid G) {
        
        AllGrids = new HashMap<>();
        GridNumber = new ArrayList<>();
        
        // add G
         AllGrids.put(0.0 , G.getGrid() );
         GridNumber.add( 0.0 );
         
        // add M 
        double node = 1;
        for (int i = 0; i < G.getGrid().length; i++) {
            for (int j = 0; j < G.getGrid()[i].length; j++) {

                AllGrids.put(node, G.M(i, j));
                GridNumber.add(node);
                node++;

            }
        }
        
        // add 0 
         int[][] O = new int[G.getGrid().length][G.getGrid().length];
         O.equals(G.getGrid());
         Arrays.fill(O, 0);
         AllGrids.put(node , O );
         GridNumber.add( node );
        
        

        SG = new SimpleGraph<Double, DefaultEdge>(DefaultEdge.class);
        Graph = (Graph<Double, DefaultEdge>) SG;
        Graphs.addAllVertices(Graph, GridNumber);
        
        

    }
    


        
    
}


