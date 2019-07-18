package TestingAndJUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MirrorSectionLengthTest {
	
	
	@Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                 { new int [] {7,7,7,7,4,7}, 4 }, 
                 { new int [] {1, 2, 3, 8, 9, 3, 2, 1}, 3 }, 
                 { new int [] {7, 1, 4, 9, 7, 4, 1}, 2 }, 
                 { new int [] {1, 4, 5, 3, 5, 4, 1}, 7 }, 
                 { new int [] {1, 2, 1, 4}, 3 },  
           });
    }
	
    ArrOperation obj1 = new ArrOperation();
    
    public int[] fInput;
    public int fExpected;
    
    public MirrorSectionLengthTest(int input[], int expected) {
        this.fInput = input;
        this.fExpected = expected;
    }
    
    @Test
    public void test() {
        assertEquals(fExpected, obj1.mirrorSectionLength(fInput));
    }
}


