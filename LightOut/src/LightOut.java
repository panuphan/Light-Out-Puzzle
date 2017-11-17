import java.io.*;
import java.util.*;

public class LightOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int grid;
     
    try{
        
        System.out.print("Enter number of rows = ");
        Scanner scan  = new Scanner(System.in);
        grid = Integer.parseInt(scan.nextLine());
        System.out.println("Enter number of rows = "+ grid + 
                            " x "+ grid +" = " + grid*grid );
        System.out.println("Enter initial states [0,1] Example : ");
        System.out.print(" 0 0 0 \n 1 0 0 \n 0 0 1\n");
        
        System.out.println("Enter initial states : " );
        String[] row = new String[grid];
        int[][] arr = new int[grid][grid];
        
        for(int i =0 ; i < grid ; i++){
            row[i] = scan.nextLine();
            String[] buf = row[i].split("\\s+");
        
            for(int j = 0 ;j < grid ; j++ )
            arr[i][j] = Integer.parseInt(buf[j]);
            
        }
        
       
        
        Grid Grid = new Grid(arr);
        MyGraph Mygraph = new MyGraph(Grid);
        //Mygraph.printGraph();
        Grid.print();
       }catch(Exception e){};
       
       
       
    }
    
    
    
    ///////////////////////////////////
    public static void printArray(int[][] A){
        for(int i  = 0 ; i < A.length ; i++){
            for(int j = 0 ; j <A.length ; j++){
                System.out.print( A[i][j] + " " );
            }
            System.out.println("");
        }
    }
}
