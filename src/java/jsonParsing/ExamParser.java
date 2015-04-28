package jsonParsing;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sun.rmi.runtime.Log;

/**
 * ExamParser is a class that uses the org.json library to parse JSON files
 * into data structures that represent the parts of an exam (questions, answers, etc)
 * 
 * @author Bryan Smith
 * @date 4/16/15
 */
public class ExamParser {
	
	private static String ERROR_PARSE_QUESTION = "Error parsing question JSON data. Check that it follows the required structure for this "
										+ "application. See the sample JSON file for an example. - ";	
	
	Exam genereatedExam = new Exam();
	JSONObject examObject = null;
	JSONObject examAttributesObject = null;
	HashMap<String, Integer> usedQuestions = new HashMap<>();
	
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
	
	
	public Exam parse() {
		try {
			parseAttributes();
	        JSONArray qs = examObject.getJSONArray("questions");
	        BaseQuestion tempQuestion;
	        for(int i = 0; i<qs.length(); i++){
	        	tempQuestion =  parseQuestion((JSONObject) qs.get(i));
	        	if (tempQuestion != null) {
	        		genereatedExam.addQuestion(tempQuestion);
	        	}
	        }
	        return genereatedExam;
		} catch (JSONException e) {
			System.out.print("Error parsing Exam JSON data. Check that it follows the required structure for this application. See the sample JSON file for an example. - "+e.getMessage()+"\n");
		}
		return null; //TODO Implement
		
	}
	
	public BaseQuestion parseQuestion(JSONObject obj) {
		try {
			int type = obj.getInt("type");
			String text = obj.getString("text");
			String cat = obj.getString("category");
			BaseQuestion q = null;
			JSONArray ans;
			
			switch(type){
			case 1:
				if (checkNumberOfUses("truefalse",cat)) {
					q = new TrueFalseQuestion(text,cat);
				}
				break;
			case 2:
				if (checkNumberOfUses("matching",cat)) {
					q = new MatchingQuestion(text,cat);
					ans = obj.getJSONArray("answers");
					q.setAnswers(convertJSONArrayToList(ans));
					JSONArray matchItems = obj.getJSONArray("matchingItems");
					((MatchingQuestion) q).setMatchingItems(convertJSONArrayToList(matchItems));
				}
				break;
			case 3:
				if (checkNumberOfUses("shortanswer",cat)) {
					q = new ShortAnswerQuestion(text,cat);
				}
				break;
			default:
				if (checkNumberOfUses("multiplechoice",cat)) {
					q = new MultipleChoiceQuestion(text,cat);
					 ans = obj.getJSONArray("answers");
					q.setAnswers(convertJSONArrayToList(ans));
				}
				break;
			}
			return q;
		} catch(JSONException e) {
			System.out.print(ERROR_PARSE_QUESTION+e.getMessage());
		}
		return null;
		
	}
	
	private boolean checkNumberOfUses(String name, String cat){
		try {
			if (usedQuestions.isEmpty()) return true;
			if (!usedQuestions.containsKey(name.toLowerCase())) { 
				return false;
			}
			int numb = (int) usedQuestions.get(name.toLowerCase());
			int catNumb = 1;
			if (usedQuestions.containsKey(cat.toLowerCase())){
				catNumb = (int) usedQuestions.get(cat.toLowerCase());
			}
			if (numb >= 1 && catNumb >= 1){
				usedQuestions.replace(name.toLowerCase(), numb, numb-1);
				if (usedQuestions.containsKey(cat.toLowerCase())){
					usedQuestions.replace(cat.toLowerCase(), catNumb, catNumb-1);
				}
				return true;
			} else {
				return false;
			}
		} catch (JSONException e) {
			System.out.print(ERROR_PARSE_QUESTION+e.getMessage());
			
		}
		return false;
	}
	
	
	private void parseAttributes(){
		try {
			if (examAttributesObject != null) {
				JSONArray atts = examAttributesObject.getJSONArray("attributes");
				for(int i=0;i<atts.length();i++){
						usedQuestions.put(((JSONObject) atts.get(i)).getString("name").toLowerCase(), ((JSONObject) atts.get(i)).getInt("numberOfUses"));			
				}
			}
		} catch (JSONException e) {
			System.out.print("Error parsing Exam JSON data. Check that it follows the required structure for this application. See the sample JSON file for an example. - "+e.getMessage());
		}
	}
	
	private <T> ArrayList<T> convertJSONArrayToList(JSONArray arr){
		try {
			ArrayList<T> list = new ArrayList<T>();
			for (int i=0; i<arr.length(); i++) {
			    list.add( (T) arr.get(i) );
			}
			return list;
		} catch (Exception e){
			System.out.println("Error converting JSON Array to a list. - "+e.getMessage());
		}
		return null;
	}


	public void print() {
		System.out.println(genereatedExam);
	}

	@Override
	public String toString() {
		return genereatedExam.toString();
	}
	
	
	
}
