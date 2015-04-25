/**
 * 
 */
package tests;

import static org.junit.Assert.*;
import jsonParsing.Answer;
import org.junit.Test;


public class AnswerTest {

	private String passing = "Answer A";

	@Test
	public void test() {
		int value = 2;
		Answer q = new Answer("Answer A", value);
		
		System.out.println("Output:\n");
		System.out.println(q.toString());
		System.out.println("\nExpected Output:\n");
		System.out.println(passing);
		
		if (!passing.equalsIgnoreCase(q.toString())) {
			fail("Output not expected.");
		}
		
		if (q.getValue() != value) {
			fail("Value not set as expected.");
		}
		
	}

}
