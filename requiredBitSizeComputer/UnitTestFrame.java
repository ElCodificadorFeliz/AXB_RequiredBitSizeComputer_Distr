package requiredBitSizeComputer;


import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


/**
 * TestFrame ...
 * 
 * @author   Michael Schaefers ;  P1@Hamburg-UAS.eu 
 * @version  2021/04/01
 */
public class UnitTestFrame {
    
    final static private int commonLimit = 4_000;                               // timeout resp. max. number of ms for test
    
    
    
    
    
    @Test
    @Timeout(value=commonLimit,unit=TimeUnit.MILLISECONDS)
    public void test0(){
        for( int i=1; i<63; i++ ) {
            final RequiredBitSizeComputer rbsc = new RequiredBitSizeComputer();
            final int bitSize = rbsc.computeBitSize( 0 );
            assertEquals( 1, bitSize );
        }//for
    }//method()    
    
    @Test
    @Timeout(value=commonLimit,unit=TimeUnit.MILLISECONDS)
    public void test2pNm1(){
        for( int i=1; i<64; i++ ) {
            final RequiredBitSizeComputer rbsc = new RequiredBitSizeComputer();
            final int bitSize = rbsc.computeBitSize( (1L<<i)-1 );
            assertEquals( i, bitSize );
        }//for
    }//method()    
    //
    @Test
    @Timeout(value=commonLimit,unit=TimeUnit.MILLISECONDS)
    public void test2pN(){
        for( int i=0; i<63; i++ ) {
            final RequiredBitSizeComputer rbsc = new RequiredBitSizeComputer();
            final int bitSize = rbsc.computeBitSize( 1L<<i );
            assertEquals( i+1, bitSize );
        }//for
    }//method()    
    
    @Test
    @Timeout(value=commonLimit,unit=TimeUnit.MILLISECONDS)
    public void testXXX(){
        doTestRaisingException( -1 );
        doTestRaisingException( -13 );
        doTestRaisingException( Integer.MIN_VALUE );
    }//method()
    //
    private void doTestRaisingException( final int testValue ){
        final RequiredBitSizeComputer rbsc = new RequiredBitSizeComputer();
        int bitSize = (int)( (1L<<31)*Math.random() );  // just a random number to keep the compiler happy - it's YOUR job to compute a serious number
        boolean success = false;
        try{ 
            bitSize = rbsc.computeBitSize( testValue );
        }catch( final Throwable ex ){
            success = (ex instanceof AssertionError)  ||  (ex instanceof IllegalArgumentException);
            if( ! success )  throw( ex );
        }//try
        if( ! success )  fail( String.format( "unexpected behavior for \"%d\" -> \"%d\"",  testValue, bitSize ));
    }//method()
    
}//class
