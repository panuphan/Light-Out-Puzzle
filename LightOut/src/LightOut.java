
import java.util.*;
import java.io.*;

public class LightOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int grid;
        Scanner scan;
        
        do{
        System.out.print("Enter number of rows (2-4)= ");
        scan  = new Scanner(System.in);
        grid = Integer.parseInt(scan.nextLine());
        }while(grid< 2 || grid > 5 );
        
        System.out.println("You're Grid  = "+ grid + 
                           " x "+ grid +" = " + grid*grid );
        System.out.println("Enter initial states [0,1] Example : ");
        System.out.print("0 0 0 \n1 0 0 \n0 0 1\n");
        
        
        System.out.println("Enter initial states : " );
        boolean error = true;
        String[] row = new String[grid];
        int[][] arr = new int[grid][grid];
        do {

            try {

                for (int i = 0; i < grid; i++) {

                    row[i] = scan.nextLine();
                    String[] buf = row[i].split(" ");

                    for (int j = 0; j < grid; j++) {
                        arr[i][j] = Integer.parseInt(buf[j]);
                        /*
                        Random r = new Random(); 
                        arr[i][j] = r.nextInt(2);
                        */
                    }
            

                }
                error = false;

            } catch (Exception e) {
                System.err.println("error Grid Enter again !");
            };

        } while (error);
        
        Grid Grid = new Grid(arr);
        //Grid.print();
        MyGraph Mygraph = new MyGraph(Grid);
        System.out.println("----------------" );
        Mygraph.ShortestPath(Grid);
        
    }

}
