/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.jgrapht.Graph;
import org.jgrapht.alg.ConnectivityInspector;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import java.util.*;


public class MyGraph {
   
        private HashMap<String, Grid>    AllGrids;      // real objects
	private ArrayList<String>          GridNumber;		 // graph nodes
	private Graph<String, DefaultEdge>                       Graph;
	private SimpleGraph<String, DefaultEdge>                 SG;
	private ConnectivityInspector<String, DefaultEdge>       conn;
    protected DijkstraShortestPath<Double, DefaultEdge>         DSP;
    // private int col=3,row=3;
    //private HashMap<String, Grid>    AllGridsP;      // real objects
    //private int[][] source;
    //private HashMap<Integer,int[][]> allAditonMatrix=new HashMap<>();
    //private ArrayList<Integer> allKey=new ArrayList<>();
        
    public MyGraph(Grid A) {

         AllGrids = new HashMap<>();
         GridNumber = new  ArrayList<>();
         int[][] arr = new int[A.getGrid().length][A.getGrid().length];
         Grid O = new Grid(arr); 
 
        
        for (int i = 0; i < A.getGrid().length; i++) {
            for (int j = 0; j < A.getGrid().length; j++) {
  
                AllGrids.put(O.getName() ,new Grid(O.M(i, j)) );
                GridNumber.add( O.getName() );
                
            }
        }
        
        System.out.println("-------");
        A.print();
        initGraph(A,GridNumber);
 

    }
    
    
    private void initGraph(Grid source, ArrayList<String> GridNumber){
        
        ArrayList<String> ak= new ArrayList<>(GridNumber);

        for (int i = 0; i < GridNumber.size(); i++) {
            String key = GridNumber.get(i);
            Grid adt= AllGrids.get(key);
            Grid target = adition(source,adt);
            
            if(target.isComplete()){
                System.out.println("Found");
                target.print();
            }
            
            
            ak.remove( new String(key) );
            initGraph(target,ak);

        } 
    }
    
/*
    private void initGraph(int[][] source, ArrayList<Integer> allKey) {
        ArrayList<Integer> ak=new ArrayList<>();
        for (int i = 0; i < allKey.size(); i++) {
            ak.add(allKey.get(i));
        }
        for (int i = 0; i < allKey.size(); i++) {
            int key =allKey.get(i);
            int[][] adt=allAditonMatrix.get(key);
            int[][] target = adition(source,adt);

            check(target);
            ak.remove(new Integer(key));
            initGraph(target,ak);

        }
    }*/

    /*private void check(int[][] target) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(target[i][j]==1) return;
            }
        }
        System.out.println("found");
    }*/

    ////////////////////////////////////////////////////////
    
        private Grid adition(Grid source, Grid adt) {
        Grid target = null;
        for (int i = 0; i < source.getGrid().length; i++) {
            for (int j = 0; j < source.getGrid().length; j++) {
                target = new Grid( source.M(i, j));
            }
        }
        return target;
    }
    
    ////////////////////////////////////////////////////////
    /*
    private int[][] adition(int[][] source, int[][] adt) {
        int[][] target = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                target[i][j]=(source[i][j]+adt[i][j])%2;
            }
        }
        return target;
    }*/
/*
    private int[][] initAdition(int r, int c) {
        int[][] a=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                a[i][j]=0;
            }
        }
        a[r][c]=1;
        if(r-1>=0)a[r-1][c]=1;
        if(r+1<row)a[r+1][c]=1;
        if(c-1>=0)a[r][c-1]=1;
        if(c+1<col)a[r][c+1]=1;
        return a;
    }*/

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

	System.out.println(" Graph print");
        System.out.println(" source");
        source.print();
        
        System.out.println("target");
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

    
}


