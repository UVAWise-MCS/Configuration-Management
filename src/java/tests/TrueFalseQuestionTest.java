/**
 * 
 */
package tests;

import static org.junit.Assert.fail;
import jsonParsing.TrueFalseQuestion;

import org.junit.Test;


public class TrueFalseQuestionTest {

	private String passing = "True/False Question : Weather"+System.getProperty("line.separator")+
								"Is it Raining?"+System.getProperty("line.separator")+
								"A) True"+System.getProperty("line.separator")+
								"B) False"+System.getProperty("line.separator"); 

	@Test
	public void test() {
		
		TrueFalseQuestion q = new TrueFalseQuestion("Is it Raining?", "Weather");

		System.out.println("Output:\n");
		System.out.println(q.toString());
		System.out.println("\nExpected Output:\n");
		System.out.println(passing);
		
		if (!passing.equalsIgnoreCase(q.toString())) {
			fail("Output not expected.");
		}
	}

}
