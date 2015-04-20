/**
 * 
 */

package jsonParsing;

import org.json.*;

/**
 * ExamParser is a class that uses the org.json library to parse JSON files
 * into data structures that represent the parts of an exam (questions, answers, etc)
 * 
 * @author Bryan Smith
 * @date 4/16/15
 */
public class ExamParser {
	
	JSONObject examObject = null;
	JSONObject examAttributesObject = null;

	public ExamParser() {}
	
	
	public ExamParser(String examStr, String examAttStr) {
		examObject = loadJSON(examStr);
		examAttributesObject = loadJSON(examAttStr);
	}

	
	public JSONObject loadJSON(String str) {
		try {
			return new JSONObject(str);
		} catch (JSONException e) {
			System.out.print("Error loading JSON data. - "+e.getMessage());
		}
		return null;
	}
	
	
	public Exam parse(JSONObject obj) {
		return null; //TODO Implement
		
	}

	private BaseQuestion parseQuestions(JSONObject obj) {
		return null; //TODO Implement	
	}
	
	private Answer parseAnswers(JSONObject obj) {
		return null; //TODO Implement
	}
}
