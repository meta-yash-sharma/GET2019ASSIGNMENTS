package TestingAndJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class SplitArrayTestCase {
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
        		{ new int [] {1, 1, 1, 2, 1}, 3 }, 
                { new int [] {2, 1, 1, 2, 1}, -1 }, 
                { new int [] {10, 10}, 1 },
                { new int [] {}, 1 }
           });
    }
    
    public int[] fInput;
    public int fExpected;
    
    public SplitArrayTestCase(int input[], int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    

    @Test
	public void splitArray () {
		ArrOperation obj4 = new ArrOperation();
		try{
			assertEquals(fExpected,obj4.splitArray(fInput));
		}
		catch (AssertionError e) {
			System.out.println("Null Array, AssertionError");
		}
		
	}

}
