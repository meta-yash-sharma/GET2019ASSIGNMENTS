package TestingAndJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MirrorSectionLengthNegativeTest {	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
                 { new int [] {}, 2 }  
           });
    }
	
    ArrOperation obj1 = new ArrOperation();
    
    public int[] fInput;
    public int fExpected;
    
    public MirrorSectionLengthNegativeTest(int input[], int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    
    @Test
    public void test() {
    	try {
    		assertEquals(fExpected, obj1.mirrorSectionLength(fInput));
    	}
    	catch (AssertionError e) {
    		System.out.println("Null Array Found, Hence Assertion Error , Error in mirrorSectionLength");
    	}
        
    }
}
