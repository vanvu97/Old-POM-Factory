package diUtlities;

import org.testng.annotations.Test;

public class MyUnitTest {
	@Test
	public void testGenerator(){
		Generator gen = new Generator();
		
		String result = gen.title();
		String result1 = gen.body();
		
		System.out.println(result);
		System.out.println(result1);
	}
}
