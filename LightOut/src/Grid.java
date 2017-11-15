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
	public Grid(double n, double bn)	{ number = n; binary_num = bn; }
	public double getNumber()			    { return number; }
	public double getBinaryNum()			{ return binary_num; }
	public String getMessage()
	{
		//String s = String.format("%-9s (%.2f $)", name, bigmac);
                String s = Double.toString(binary_num);        
		return s;
	}
	public void print(int r)
	{
                        double row = (double)r; 
                        
                        System.out.println("Number " + number );
                        String s = Double.toString(binary_num);  
		                  for(int i = 0 ; i < row ; i++){
                      for(int j = 0 ; j < row ; j++){
                          System.out.print(s.charAt(0)+" ");
                      }
                      System.out.println("");
                  }
	}
}
