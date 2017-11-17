
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


    private String name;
    private int[][] G;

    public Grid(int[][] g) {
            
        G = Arrays.copyOf(g, g.length); 
        Setname();
            
    }
    
	public String getName() {
        return name;
    }

    
    public int[][] getGrid(){
        return G;
    }
    
    
    public void print(){
            System.out.println("name : "+name);
        for(int i  = 0 ; i < G.length ; i++){
            for(int j = 0 ; j <G.length ; j++){
                System.out.print( G[i][j] + " " );
            }
            System.out.println("");
        }
        System.out.println("");
    } 

    public int[][] M(int i, int j) {
        
        int[][] C = new int[G.length][G.length];
        for(int i1 = 0 ; i1< C.length ; i1++){
            for(int j1 = 0 ; j1 < C.length ; j1++){
                C[i1][j1] = G[i1][j1];
            }
        }
        
        
        C[i][j]     += 1;
        if(C[i][j] % 2 == 0 ) C[i][j] = 0;
        
        try{
        C[i + 1][j] += 1;
        if(C[i+1][j] % 2 == 0 )C[i+1][j] = 0;
        }catch(Exception e){};
        
        try{
        C[i - 1][j] += 1;
        if(C[i-1][j] % 2 == 0 ) C[i-1][j] = 0;
        }catch(Exception e){};
        
        try{
        C[i][j + 1] += 1;
        if(C[i][j+1] % 2 == 0 ) C[i][j+1] = 0;
        }catch(Exception e){};
        
        try{
        C[i][j - 1] += 1;
        if(C[i][j-1] % 2 == 0 ) C[i][j-1] = 0;
        }catch(Exception e){};
        
        return C;
    }
    
    public boolean isComplete(){
        int[][] O = new int[G.length][G.length];
        return Arrays.equals(G, O);

    }
    
    public void Setname(){
        String n = "" ;
        for(int i = 0 ; i< G.length ; i++){
            for(int j =0 ; j < G.length ; j++){

                n += Integer.toString(G[i][j]);
            }
        }
        name = n;
    }
    
    
    
    
    
    
}
