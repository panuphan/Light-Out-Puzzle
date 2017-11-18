import java.util.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.*;


public class MyGraph {
   
    private HashMap<String, Grid>    AllGrids;      // real objects
    private ArrayList<String>          GridNumber;  // graph nodes
    private Graph<String, DefaultEdge>                       G;
    private SimpleGraph<String, DefaultEdge>                 SG;
    private DijkstraShortestPath<String, DefaultEdge>        DSP;
      
        
    public MyGraph(Grid target) {
        
         AllGrids = new HashMap<>();
        GridNumber = new  ArrayList<>();
        
 
        SG = new SimpleGraph<>(DefaultEdge.class);
	G  = (Graph<String, DefaultEdge>)SG;
	//Graphs.addAllVertices(G, GridNumber);
        initGraph(target);
        
    }
    
    
    
    private void initGraph( Grid target) {
        
        //add Grid All Zero in ArrayList
        int[][] arr = new int[target.getGrid().length][target.getGrid().length];
        Grid Head = new Grid(arr);
        GridNumber.add( Head.getName() );
        AllGrids.put(Head.getName(), Head);
        
        //loop for change Head node  
        for (int head = 0; head < GridNumber.size() ; head++) {
            
            // new head is next grid in ArrayList
            Head = AllGrids.get( GridNumber.get(head) );  
            //System.out.println("head=" +GridNumber.size());
            //loop for change switch' position
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    
                    // Create Grid tail, tail is Head enter switch
                    Grid tail = new Grid(Head.M(i, j));
                    
                    //check tail must not exist ArrayList , 
                    //add tail in ArrayList and add edge. 
                    if (!(GridNumber.contains(tail.getName()))) {
                        GridNumber.add(tail.getName() );
                        AllGrids.put(tail.getName() , tail);
                        
                        //GridNumber have Update allways,
                        //so Update AllVertices 
                        Graphs.addAllVertices(G, GridNumber);
                        
                        //Link Head node - tail node
                        G.addEdge(Head.getName(), tail.getName() );

                    }
                    
                    //if Grid in Arraylist equals Grid target ,Break loop j.
                    if (GridNumber.contains( target.getName() ) ) {
                        break;
                    }

                }
                //if Grid in Arraylist equals Grid target ,Break loop i.
                if (GridNumber.contains(target.getName())) {
                    break;
                }
            }//end loop for change switch' position
            
            //if Grid in Arraylist equals Grid target ,Break loop head.
            if (GridNumber.contains(target.getName()) ) {
                System.out.println("TARGET");
                break;
            } 

        }

    }

    //////////////////////////////////////////////////////////////////////////// 
    // Methods to print
        
    public Grid searchGrid(String node) {
        
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
        
        System.out.println("Click row i col j " );
        target.print();
        }
        if(source !=null){
            System.out.println("Click row i col j " );
            source.print();
        }
        
    }
    
    ////////////////////////////////////////////////////////////////////////////   
    public void testShortestPath(Grid target) {

        String key1 = target.getName();

        int[][] arr = new int[target.getGrid().length][target.getGrid().length];
        Grid O = new Grid(arr);
        String key2 = O.getName();

        // source and target must exist, otherwise error
        if (G.containsVertex(key1) && G.containsVertex(key2)) {
            DSP = new DijkstraShortestPath<>(SG, key1, key2);
            List<DefaultEdge> path = DSP.getPathEdgeList();
            //if (path != null) {
                System.out.printf("\nShortest path (length = %.0f) \n",
                        DSP.getPathLength());
                printDefaultEdges(path);
           // }
        }
        else {
                System.out.println("\nNo path from "+key1+ " to "+key2+" |Enter Grid again !");
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


