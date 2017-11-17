/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;


public class MyGraph {
    
    	private HashMap<String, Grid>    AllGrids;      // real objects
        //private HashMap<String, Grid>    AllGridsP;      // real objects
	private ArrayList<String>          GridNumber;		 // graph nodes

	private Graph<String, DefaultEdge>                       Graph;
	private SimpleGraph<String, DefaultEdge>                 SG;
	private ConnectivityInspector<String, DefaultEdge>       conn;
        protected DijkstraShortestPath<Double, DefaultEdge>         DSP;
        
        
    public MyGraph(Grid A) {
       
                Grid G ;
                G = A;
                AllGrids = new HashMap<>();
                //AllGridsP = new HashMap<>();
                GridNumber = new ArrayList<>();
                int node = 0;      
                
       for(int I = 0 ; I < G.getGrid().length ; I++){
           for(int J = 0 ; J < G.getGrid().length ; J++){ 
          
        // add G
        if (!AllGrids.containsKey( G.getName() ) ) {
         AllGrids.put( G.getName() , G );
        
         //AllGridsP.put( Double.toString(node) , G );
         GridNumber.add( G.getName() );
         node++;
        }
        
        // add M 
        Grid S;
        
       for (int i = 0; i < G.getGrid().length; i++) {
            for (int j = 0; j < G.getGrid().length; j++) {
                
             S = new Grid(G.M(i, j));  
            if (!AllGrids.containsKey( S.getName() ) ) {
             AllGrids.put( S.getName() , S );
             //AllGridsP.put( Double.toString(node) , G );
            GridNumber.add( S.getName() );
            node++;
            }
            

            }
        }
        	
        
        // Update new G
        int[][] temp;
        temp = G.M(I, J);
        G = new Grid(temp);
       }
       }
        
       
      
        
        
        for (String key : AllGrids.keySet() ) {
            AllGrids.get(key).print();
        }
        
    
       
        

        SG = new SimpleGraph<String, DefaultEdge>(DefaultEdge.class);
        Graph = (Graph<String, DefaultEdge>) SG;
        Graphs.addAllVertices(Graph, GridNumber);
        
        
        G = A;
        Grid E;
        for(int I = 0 ; I < G.getGrid().length ; I++){
           for(int J = 0 ; J < G.getGrid().length ; J++){ 
        
        for(int i = 0 ; i< G.getGrid().length ; i++){
            for(int j = 0 ; j< G.getGrid().length ; j++){
                E = new Grid(G.M(i, j));
                
                if(!SG.containsEdge( G.getName(),E.getName() ) )
                    Graph.addEdge(G.getName(), E.getName());
                
            }
        }
        
                // Update new G
        int[][] temp;
        temp = G.M(I, J);
        G = new Grid(temp);
       }
       }
        
          

    }
    
        // Methods to print
    public Grid searchGrid(String node) {
        
        return AllGrids.get(node);
    }

    public void printGraph() {
        Set<DefaultEdge> allEdges = Graph.edgeSet();
        printDefaultEdges(allEdges);
    }

    public void printDefaultEdges(Collection<DefaultEdge> E) {

        for (DefaultEdge e : E) {

            Grid source = searchGrid(Graph.getEdgeSource(e));
            Grid target = searchGrid(Graph.getEdgeTarget(e));

            
            System.out.println("Source Grid is " + Graph.getEdgeSource(e));
            source.print();
            
            System.out.println("target Grid is " + Graph.getEdgeTarget(e));
            target.print();

        }
    }
    

 public  void printArray(int[][] A){
        for(int i  = 0 ; i < A.length ; i++){
            for(int j = 0 ; j <A.length ; j++){
                System.out.print( A[i][j] + " " );
            }
            System.out.println("");
        }
        
        System.out.println("");
        
    }
 
 /*public  void Re(){
           for (int i = 0; i < G.getGrid().length; i++) {
            for (int j = 0; j < G.getGrid().length; j++) {
                
             S = new Grid(G.M(i, j));  
            if (!AllGrids.containsKey( S.getName() ) ) {
             AllGrids.put( S.getName() , S );
             //AllGridsP.put( Double.toString(node) , G );
            GridNumber.add( S.getName() );
            
            }

            
        	    
        // Update new G
        int[][] temp;
        temp = G.M(I, J);
        G = new Grid(temp);
       }
       }
 }*/
    
}


