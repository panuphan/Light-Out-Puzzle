
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

    private String name;
    private int[][] G;

    public Grid(int[][] g) {
        G = g;
        Setname();
    }

    public String getName() {
        return name;
    }

    public int[][] getGrid(){
        return G;
    }
    
    
    public void print(){

        for(int i  = 0 ; i < G.length ; i++){
            for(int j = 0 ; j <G.length ; j++){
                System.out.print( G[i][j] + " " );
            }
            System.out.println("");
        }
        System.out.println("");
        
    } 

    public int[][] M(int i, int j) {

        int[][] C = CopyArray(G);
        
        try{
        C[i][j]     += 1;
        if(C[i][j] % 2 == 0 )  C[i][j] = 0;
        }catch(Exception e){};
        
        try{
        C[i + 1][j] += 1;
        if(C[i+1][j] % 2 == 0 ) C[i+1][j] = 0;
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
    
    public int[][] CopyArray(int[][] copy){
        int[][] place = new int[copy.length][copy.length];
        for(int i = 0 ; i < place.length ; i++){
            for(int j = 0 ; j < place.length ; j++){
                place[i][j] = copy[i][j];
            }
        }
        return place;
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
    
    
    public void printSwitch(Grid gridNext) {

        boolean found = false;
        for (int i = 0; !found && i < G.length ; i++) {
            for (int j = 0; !found && j < G.length  ; j++) {
                
                Grid g = new Grid(this.M(i, j));                   
                    
                if ( gridNext.getName().equalsIgnoreCase(g.getName()) ) {
                    System.out.println("Click : col " + j + " row " + i +" result :");
                    found = true;
                }
            }
        }

    }
    
    
    
    
    
}
