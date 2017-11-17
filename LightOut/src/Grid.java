
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
	}
	private double number;
	public String getMessage()

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
        
        int[][] M ;
        M = G;
        
        M[i][j]     += 1;
        if(M[i][j] % 2 == 0 ) M[i][j] = 0;
        
        try{
        M[i + 1][j] += 1;
        if(M[i+1][j] % 2 == 0 ) M[i+1][j] = 0;
        }catch(Exception e){};
        
        try{
        M[i - 1][j] += 1;
        if(M[i-1][j] % 2 == 0 ) M[i-1][j] = 0;
        }catch(Exception e){};
        
        try{
        M[i][j + 1] += 1;
        if(M[i][j+1] % 2 == 0 ) M[i][j+1] = 0;
        }catch(Exception e){};
        
        try{
        M[i][j - 1] += 1;
        if(M[i][j-1] % 2 == 0 ) M[i][j-1] = 0;
        }catch(Exception e){};
        
        return M;
    }
    
    public boolean isComplete(){
        int[][] O = new int[G.length][G.length];
        //Arrays.fill(O, 0);
        return Arrays.equals(G, O);

    }
    
    public void Setname(){
        String n = null ;
        for(int i = 0 ; i< G.length ; i++){
            for(int j =0 ; j < G.length ; j++){
                if(n==null)n= Integer.toString(G[i][j]);
                n += Integer.toString(G[i][j]);
            }
        }
        name = n;
    }
    
    
    
    
    
    
}
