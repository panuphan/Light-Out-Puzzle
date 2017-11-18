import java.util.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.*;


public class MyGraph {
   
    private HashMap<Double, Grid>    AllGrids;      // real objects
    private ArrayList<Double>          GridNumber;  // graph nodes
    private Graph<Double, DefaultEdge>                       G;
    private SimpleGraph<Double, DefaultEdge>                 SG;
    private DijkstraShortestPath<Double, DefaultEdge>        DSP;
      
        
    public MyGraph(Grid target) {
        
         AllGrids = new HashMap<>();
        GridNumber = new  ArrayList<>();
        
 
        SG = new SimpleGraph<>(DefaultEdge.class);
	G  = (Graph<Double, DefaultEdge>)SG;
	//Graphs.addAllVertices(G, GridNumber);
        initGraph(target);
        
    }
    
    
    
    private void initGraph( Grid target) {
        
        //add Grid All Zero in ArrayList
        int[][] arr = new int[target.getGrid().length][target.getGrid().length];
        Grid Head = new Grid(arr);
        GridNumber.add( Double.parseDouble(Head.getName()) );
        AllGrids.put(Double.parseDouble(Head.getName()), Head);
        
        //loop for change Head node  
        for (int head = 1; head <= GridNumber.size() ; head++) {
            
            //loop for change switch' position
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    
                    // Create Grid tail, tail is Head enter switch
                    Grid tail = new Grid(Head.M(i, j));
                    
                    //check tail must not exist ArrayList , 
                    //add tail in ArrayList and add edge. 
                    if (!(GridNumber.contains(Double.parseDouble(tail.getName())))) {
                        GridNumber.add(Double.parseDouble(tail.getName()) );
                        AllGrids.put(Double.parseDouble(tail.getName()) , tail);
                        
                        //GridNumber have Update allways,
                        //so Update AllVertices 
                        Graphs.addAllVertices(G, GridNumber);
                        
                        //Link Head node - tail node
                        G.addEdge(Double.parseDouble(Head.getName()), Double.parseDouble(tail.getName()) );

                    }
                    
                    //if Grid in Arraylist equals Grid target ,Break loop j.
                    if (GridNumber.contains(Double.parseDouble(target.getName())) ) {
                        break;
                    }

                }
                //if Grid in Arraylist equals Grid target ,Break loop i.
                if (GridNumber.contains(Double.parseDouble(target.getName()))) {
                    break;
                }
            }//end loop for change switch' position
            
            //if Grid in Arraylist equals Grid target ,Break loop head.
            if (GridNumber.contains(Double.parseDouble(target.getName())) ) {
                System.out.println("TARGET");
                break;
            } 
            
            // new head is next grid in ArrayList
            Head = AllGrids.get( GridNumber.get(head) );    

        }

    }

    //////////////////////////////////////////////////////////////////////////// 
    // Methods to print
        
    public Grid searchGrid(Double node) {
        
        return AllGrids.get(node);
    }

    public void printGraph() {
        Set<DefaultEdge> allEdges = G.edgeSet();
        printDefaultEdges(allEdges);
    }

    public void printDefaultEdges(Collection<DefaultEdge> E) {
        
        Grid source = null;
        
        for (DefaultEdge e : E) {
            
        source = searchGrid(G.getEdgeSource(e));
        Grid target = searchGrid(G.getEdgeTarget(e));
        
        System.out.println(" Click row i col j " );
        target.print();
        }
        System.out.println(" Click row i col j " );
        source.print();
    }
    
    ////////////////////////////////////////////////////////////////////////////   
    public void testShortestPath(Grid target) {

        double key1 = Double.parseDouble(target.getName());

        int[][] arr = new int[target.getGrid().length][target.getGrid().length];
        Grid O = new Grid(arr);
        double key2 = Double.parseDouble(O.getName());

        // source and target must exist, otherwise error
        if (G.containsVertex(key1) && G.containsVertex(key2)) {
            DSP = new DijkstraShortestPath<>(SG, key1, key2);
            List<DefaultEdge> path = DSP.getPathEdgeList();
            if (path != null) {
                System.out.printf("\nShortest path (length = %.0f) \n",
                        DSP.getPathLength());
                printDefaultEdges(path);
            } else {
                System.out.printf("\nNo path from %s to %s \n", key1, key2);
            }
        }
    }
    
    //////////////////////////////////////////////////////////////////////////// 
 public  void printArray(int[][] A){
        for(int i  = 0 ; i < A.length ; i++){
            for(int j = 0 ; j <A.length ; j++){
                System.out.print( A[i][j] + " " );
            }
            System.out.println("");
        }
        
        
        System.out.println(""); 
    }

    
}


