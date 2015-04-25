/**
 * 
 */
package tests;

import static org.junit.Assert.fail;
import jsonParsing.MultipleChoiceQuestion;

import org.junit.Test;


public class MultipleChoiceQuestionTest {

	private String passing = "Mulitple Choice Question :General"+System.getProperty("line.separator")+
							"How are you?"+System.getProperty("line.separator")+
							"A) Well"+System.getProperty("line.separator")+
							"B) Very well"+System.getProperty("line.separator")+
							"C) Not well"+System.getProperty("line.separator")+
							"D) Not very well"+System.getProperty("line.separator");

	@Test
	public void test() {
		MultipleChoiceQuestion q = new MultipleChoiceQuestion("How are you?", "General");
		q.addAnswer("Well");	
		q.addAnswer("Very well");
		q.addAnswer("Not well");
		q.addAnswer("Not very well");
		System.out.println("Output:\n");
		System.out.println(q.toString());
		System.out.println("\nExpected Output:\n");
		System.out.println(passing);
		
		if (!passing.equalsIgnoreCase(q.toString())) {
		fail("Output not expected.");
		}
	}

}
