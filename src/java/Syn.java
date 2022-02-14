/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Syn {
    public static void printer1()
    {
        long t= System.currentTimeMillis();
        long end = t+2000;
        int i=0;
        while(System.currentTimeMillis() < end) {
            System.out.println("PRINTER1="+i);
            i++;
            
            //Thread.sleep( xxx );
        }
        /*for(int i=0;i<5;i++)
        {
            System.out.println("PRINTER1="+i);
        }*/
    }
    
    public static void printer2()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("PRINTER2="+i);
            printer1();
            
        }
    }
    public static void main(String args[])
    {
        //printer1();
        printer2();
    }
    
}
