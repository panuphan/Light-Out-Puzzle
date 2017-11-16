
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Grid {

    private double number;
    private double binary_num;
    private int[][] G;

    public Grid(int[][] g) {
            
        G.equals(g);
            
    }
    
	public double getNumber() {
        return number;
    }

    public double getBinaryNum() {
        return binary_num;
    }
    
    public int[][] getGrid(){
        return G;
    }
    
    

    public void print(int r) {
        double row = (double) r;

        System.out.println("Number " + number);
        String s = Double.toString(binary_num);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(s.charAt(0) + " ");
            }
            System.out.println("");
        }
    }
    
    public void print(){
        for(int i  = 0 ; i < G.length ; i++){
            for(int j = 0 ; j <G[i].length ; j++){
                System.out.print( G[i][j] + " " );
            }
            System.out.println("");
        }
    } 

    public int[][] M(int i, int j) {
        int[][] M = new int[G.length][G.length];
        M.equals(G);
        M[i][j]     += 1;
        try{
        M[i + 1][j] += 1;
        }catch(Exception e){};
        
        try{
        M[i - 1][j] += 1;
        }catch(Exception e){};
        
        try{
        M[i][j + 1] += 1;
        }catch(Exception e){};
        
        try{
        M[i][j - 1] += 1;
        }catch(Exception e){};
        
        return M;
    }
    
    public boolean isComplete(){
        int[][] O = new int[G.length][G.length];
        Arrays.fill(O, 0);
        return Arrays.equals(G, O);

    }
    
    
}
