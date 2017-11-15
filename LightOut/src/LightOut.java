import java.io.*;
import java.util.*;

public class LightOut {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int grid;
        System.out.print("Enter number of rows = ");
        Scanner scan  = new Scanner(System.in);
        grid = Integer.parseInt(scan.nextLine());
        System.out.println("Enter number of rows = "+ grid + 
                            " x "+ grid +" = " + grid*grid );
        System.out.println("Enter initial states [0,1] Example : ");
        System.out.print(" 0 0 0 \n 1 0 0 \n 0 0 1\n");
        
        System.out.println("Enter initial states : " );
        String[] row = new String[grid];
        for(int i =0 ; i < grid ; i++)
        row[i] = scan.nextLine();
    }
    
}
