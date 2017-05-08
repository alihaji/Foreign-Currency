package foreigncurrency;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author Ali HM
 */
public class ForeignCurrency {
    
    static Scanner sc = new Scanner(System.in);
    static double rGBP, rEUR, rJPY, rCAD, rRUB;
            
    public static void main(String[] args) {
        System.out.println(
                "Welcome to the Foreign Currency.");
        getRates();
        dovaluation();
        System.out.println(
                "Thanks for using the Foreign Currency Calculater.");
                    
    }//End of main///////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////
//////////////******************END OF MAIN************////////////////    
/////////////////////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////////////////////
    
    public static void getRates(){
        System.out.println(
                "Enter currency rates per US $");        
        rEUR = getOneRate("EUR");
        rGBP = getOneRate("GBP");        
        rJPY = getOneRate("JPY"); 
        rCAD = getOneRate("CAD");
        rRUB = getOneRate("RUB");
    }
    public static double getOneRate(String currency)  {
        double rate = 0;
        
        do {
            try {
                System.out.print(currency + ": ");
                rate = sc.nextDouble();
                if (rate <=0){
                    System.out.println(
                            "Rate must be > zero.");               
                }// end of if
                       
            }catch (Exception e) {
                System.out.println(
                        "Illegal rate: must be positive value.");
                sc.nextLine();
                rate = 0;          
            }//end of catch
                    
        } while( rate <= 0 );
        return rate; 
        
        
    }  //end of getOneRate//////////////////////////////////////////////////
//////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////    
    
    
    
    public static void dovaluation(){
        int choice, qty;
        double cval, totval = 0;
        NumberFormat curr = NumberFormat.getCurrencyInstance();        
        
        int[] units = new int[5];// 5 slots: # 0,1,2,3,4
        for(int i = 0; i<5; i++) { // initialize ech slot to zero
            units[i] = 0;        
        }
        double[] ctot = { 0.0, 0.0, 0.0, 0.0, 0.0};
        String[] cnames = { "EUR", "GPB", "JPY", "CAD", "RUB" };
        
        choice = getChoice();
        while (choice !=0) {
            cval = 0;
            switch(choice){
                 case 1:
                     qty = getQty("How many Euros? ");
                     cval = qty * rEUR;
                     System.out.println(qty + " Euros has a value of: " +
                                            curr.format(cval) );
                     units[0] += qty; // add qty purchased to array
                     ctot[0] += cval;
                     break;
                 case 2:
                     qty = getQty("How many Pounds Sterling?");
                     cval = qty * rGBP;
                     System.out.println(qty + "pounds has a value of:" +
                                            curr.format(cval));
                     units[choice-1] += qty;
                     ctot[choice-1] += qty;
                     break;
                 case 3:
                     qty = getQty("How many Yen? ");
                     cval = qty * rJPY;
                     System.out.println(qty + " Yen has a value of: " +
                                            curr.format(cval));
                     units[2] += qty;
                     ctot[2] += cval;                             
                     break;
                 case 4:
                     qty = getQty("How many Canadian dollars?");
                     cval = qty * rCAD;
                     System.out.println(qty + " Canadian dollars has a value of: " +
                                            curr.format(cval) );
                     units[3] += qty;
                     ctot[3] += cval;
                     break;
                 case 5:
                     qty = getQty("How many Rubles?");                             
                     cval = qty * rRUB;
                     System.out.println(qty +" Ruble hase a value of: " +
                             curr.format(cval));  
                     units[4] += qty;
                     ctot[4] += cval;
                     break;                     
                 case 9:
                     getRates(); // وقتی می خواد کل یک بلاک رو صدا کنه//
                     break;                     
                 default:   
                     System.out.println("Unknown currency type");                     
                     break;
                     
             }//end of switch////////////////////////////////////////////
             totval += cval;
             choice = getChoice();            
        
        }// end of while//////////////////////////////////////////////// 
        
        for(int i = 0; i<5; i++){
            System.out.println(cnames[i] + ": " + 
                    units[i] + " units costing " +
                    curr.format(ctot[i])) ;
        
        }

        System.out.println("Total currency value purchased =  "
                + curr.format(totval));
    
    }// end of do valuation/////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////
    
    
    public static int getChoice(){
        int c = -1;
        do {
            try {
                System.out.print(
                        "Select currency: "
                      + "(1=EUR, 2=GPB, 3=JPY, 4=CAD, 5=RUB, 9=New rates, 0=Quit): ");
                c = sc.nextInt();
                if (( c<0 || c>5) && c != 9) {
                    System.out.println(
                            "Invalid selection: 0 or 1-5 or 9 only");
                    c = -1;                                    
                }            
            } catch(Exception e){
                System.out.println(
                        "Invallid input: not an integer");
                sc.nextLine();
                c = -1;
            }                    
        } while ( c < 0);
        return c;       
        
    }// end of get choice///////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    
    public static int getQty(String ctype) {
        int q = -1;
        do {
            try{
                System.out.print(ctype);
                q = sc.nextInt();
                if ( q < 0) {
                System.out.println("quantity must be non-negative.");
                }                                
            } catch(Exception e){
                System.out.println(" Illegal quantity: must be non-negative intiger");
                sc.nextLine();
                q = -1;            
            }                    
        }while (q<0);
        return q;
          
    }// end of getQty////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////////////////    
/////////////////////////////////////////////////////////////////////////    
        
    
}//End of class/////////////////////////////////////////////////////////////
