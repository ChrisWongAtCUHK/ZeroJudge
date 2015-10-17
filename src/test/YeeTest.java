package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import yee.Yee;

@RunWith(value=Parameterized.class)
public class YeeTest {

	/**
	 * @return the 2d-array of expected values and parameters
	 */
	@Parameterized.Parameters
    public static Collection<Object[]> getParameters() {
        return Arrays.asList(
            new Object[][] {
                {"yeyeee", 1},
                {"yeyyeyeeeeee", 8}
            });
    }
    
    
    private String input;
    private int n;
    
    /**
     * @param input input answer
     * @param n parameter for get() method 
     */
    public YeeTest(String input, int n) {
        this.input = input;
        this.n = n;
    }
    
    @Test
    public void testGet() {

    	Yee yee = new Yee(input);
    	yee.calSwapCount();
    	int result = yee.getSwapCount();
    	
    	// assert the question & answer
        assertEquals(n, result);
    }
}
