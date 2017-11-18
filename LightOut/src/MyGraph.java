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

        initGraph(target);
        
    }
    
    
 ///////////////////////////////////////////////////////////////////////////////   
    private void initGraph( Grid target) {
        
        //add Grid All Zero in ArrayList
        int[][] arr = new int[target.getGrid().length][target.getGrid().length];
        Grid Head = new Grid(arr);
        GridNumber.add( Head.getName() );
        AllGrids.put(Head.getName(), Head);
        
        
        //loop for change Head node  
        for (int head = 0; head < GridNumber.size() ; head++) {
            // new head is next grid in ArrayList
            Head = AllGrids.get(GridNumber.get(head));

            
            //loop for change switch' position
            for (int i = 0; i < arr.length ; i++) {
                for (int j = 0; j < arr.length ; j++) {

                    // Create Grid tail, tail is Head enter switch
                    Grid tail = new Grid(Head.M(i, j));

                    //check tail must not exist ArrayList, add tail in ArrayList and add edge. 
                    if (!(GridNumber.contains(tail.getName()))) {
                        GridNumber.add(tail.getName());
                        AllGrids.put(tail.getName(), tail);

                        //GridNumber have Update always,so Update AllVertices 
                        Graphs.addAllVertices(G, GridNumber);

                        //Link Head node - tail node
                        G.addEdge(Head.getName(), tail.getName());

                    }
                    
                  if(GridNumber.contains(target.getName()))break;
                }
                
              if(GridNumber.contains(target.getName()))break;
            }//end loop for change switch' position
            
          if(GridNumber.contains(target.getName()))break;
        }//end loop for change head

    }

    //////////////////////////////////////////////////////////////////////////// 
    // Methods to print
        
    public Grid searchGrid(String node) {
        
        return AllGrids.get(node);
    }

    public void printGraphEdges(Collection<DefaultEdge> E) {
        
        Grid source = null;
        
        for (DefaultEdge e : E) {
            
        source = searchGrid(G.getEdgeSource(e));
        Grid target = searchGrid(G.getEdgeTarget(e));
        target.print();
        source.printSwitch(target);
        
        }
        
        if(source !=null){
            source.print();
        }
        
    }
    
    ////////////////////////////////////////////////////////////////////////////   
    public void ShortestPath(Grid target) {

        String key1 = target.getName();

        int[][] arr = new int[target.getGrid().length][target.getGrid().length];
        Grid O = new Grid(arr);
        String key2 = O.getName();

        // source and target must exist, otherwise error
        if (G.containsVertex(key1) && G.containsVertex(key2)) {
            DSP = new DijkstraShortestPath<>(SG, key1, key2);
            List<DefaultEdge> path = DSP.getPathEdgeList();

            System.out.println("Minimum Click = " + (int) DSP.getPathLength());
            printGraphEdges(path);
        } else {
            System.out.println("\nNo Solutions ");
        }
    }

}


