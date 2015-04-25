package tests;

import static org.junit.Assert.*;
import jsonParsing.MatchingQuestion;

import org.junit.Test;


public class MatchingQuestionTest {
	
	private String passing = "Matching Question :Geography"+System.getProperty("line.separator")+
							"1) Paris	A) England"+System.getProperty("line.separator")+
							"2) Milan	B) France"+System.getProperty("line.separator")+
							"3) London	C) Germany"+System.getProperty("line.separator")+
							"4) Berlin	D) Italy"+System.getProperty("line.separator");

	@Test
	public void test() {
		MatchingQuestion q = new MatchingQuestion("Match each capital with its country", "Geography");	
		q.addMatchingItem("Paris");
		q.addMatchingItem("Milan");		
		q.addMatchingItem("London");		
		q.addMatchingItem("Berlin");
		q.addAnswer("England", 1);	//defines the answers.
		q.addAnswer("France", 2);
		q.addAnswer("Germany", 3);
		q.addAnswer("Italy", 4);
		System.out.println("Output:\n");
		System.out.println(q.toString());
		System.out.println("\nExpected Output:\n");
		System.out.println(passing);
		
		if (!passing.equalsIgnoreCase(q.toString())) {
			fail("Output not expected.");
		}
	}

}
