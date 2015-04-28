/**
 * 
 */
package tests;

import static org.junit.Assert.fail;
import jsonParsing.ExamParser;

import org.junit.Test;

/**
 * 
 * This is a unit test for the jsonParsing.ExamParser class.
 * 
 * @author Bryan Smith
 * @date 4/16/15
 */
public class ExamParserTest {
	
	private String passing = "Mulitple Choice Question :SWEG"+ System.getProperty("line.separator")
			+ "What is SWEG?"+ System.getProperty("line.separator")
			+ "A) Comp Sci"+ System.getProperty("line.separator")
			+ "B) Software Engineering"+ System.getProperty("line.separator")
			+ "C) Derp"+ System.getProperty("line.separator")
			+ "D) Herp"+ System.getProperty("line.separator")+ System.getProperty("line.separator")
			+ "True/False Question : Weather"+ System.getProperty("line.separator")
			+ "Is it Raining?"+ System.getProperty("line.separator")
			+ "A) True"+ System.getProperty("line.separator")
			+ "B) False" + System.getProperty("line.separator")+ System.getProperty("line.separator");
			
	@Test
	public void test() {
		String json = "{'name':'Exam','questions':[{'text':'What is SWEG?','category':'SWEG','answers':['Comp Sci','Software Engineering','Derp','Herp'],'type':0},{'text':'What is SWEG?','category':'SWEG','answers':['Comp Sci','Software Engineering','Derp','Herp'],'type':0},{'text':'Match each capital with its country','category':'Geography','matchingItems':['Paris','Milan','London','Berlin'],'answers':['England','France','Germany','Italy'],'type':2},{'text':'Is it Raining?','category':'Weather','answers':['True','False'],'type':1},{'text':'Are you awake?','category':'General','answers':[],'type':3}]}";
		String attJson = "{'attributes':[{'name':'MultipleChoice','numberOfUses':2},{'name':'SWEG','numberOfUses':1},{'name':'Geography','numberOfUses':2},{'name':'Weather','numberOfUses':1},{'name':'General','numberOfUses':2},{'name':'truefalse','numberOfUses':1}]}";

		try {

			ExamParser parser = new ExamParser(json, attJson);
			String results = parser.parse().toString();
			
			
			System.out.println("Output:\n");
			parser.print();
			System.out.println("\nExpected Output:\n");
			System.out.println(passing);

			if (!passing.equalsIgnoreCase(results.toString())) {
				fail("Output not expected.");
			}

		} catch (Exception e) {
			System.out.println(e);
			fail(e.getMessage());
		}
	}

}
