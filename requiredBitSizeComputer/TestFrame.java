package requiredBitSizeComputer;


import java.util.Scanner;


/**
 * TestFrame for Required Bit Size Computer
 * 
 * @author   Michael Schaefers ;  P1@Hamburg-UAS.eu 
 * @version  2017/10/06
 */
public class TestFrame {
    
    public static void main( final String... unused ){
        try(
            final Scanner workAroundForSeriousUserInterface = new Scanner( System.in );
        ){
            System.out.printf( "Gebe die Zahl ein, fuer welche die benoetigte Bitanzahl berechnet werden soll\n" );
            System.out.printf( "und tippe danach Return um die Eingabe abzuschliessen.\n" );
            System.out.printf( "=> " );
            //
            final long number = workAroundForSeriousUserInterface.nextLong();
            final RequiredBitSizeComputer requiredBitSizeComputer = new RequiredBitSizeComputer();
            final int bitSize = requiredBitSizeComputer.computeBitSize( number );
            //
            System.out.printf( "Fuer die Zahl %d werden %d Bit(s) benoetigt\n",  number, bitSize );
            
            System.out.printf( "\n\n" );
            System.out.printf( "THIS IS THE END" );
            
        }catch( final Throwable ex ){
            if( ! (( ex instanceof AssertionError ) || ( ex instanceof IllegalArgumentException ))){
                System.out.flush();
                System.err.printf( "###\n" );
                System.err.printf( "### Uuuupppss, was ist denn da passiert ????\n" );
                System.err.printf( "###\n" );
                System.err.printf( "\n" );
            }//if
            throw( ex );
        }//try
    }//method()
    
}//class
