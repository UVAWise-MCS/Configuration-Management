package jsonParsing;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * ExamParser is a class that uses the org.json library to parse JSON files into
 * data structures that represent the parts of an exam (questions, answers, etc)
 * 
 * @author Bryan Smith
 * @date 4/16/15
 */
public class ExamParser {

	private static final String ERROR_PARSE_ATTRIBUTES = "Error parsing Attribute JSON data. Check that it follows the required structure for this application."
			+ " See the sample JSON file for an example. - ";

	private static String ERROR_PARSE_QUESTION = "Error parsing question JSON data. Check that it follows the required structure for this "
			+ "application. See the sample JSON file for an example. - ";
	
	private static String ERROR_PARSE_EXAM = "Error parsing Exam JSON data. Check that it follows the required structure for this application."
			+ " See the sample JSON file for an example. - ";

	Exam genereatedExam = new Exam();
	JSONObject examObject = null;
	JSONObject examAttributesObject = null;
	HashMap<String, Integer> usedQuestions = new HashMap<>();

	
	/**
	 * ExamParser constructor
	 */
	public ExamParser() {}

	/**
	 * ExamParser constructor
	 * @param examStr Exam Question JSON to use.
	 * @param examAttStr Exam Attribute JSON to use.
	 */
	public ExamParser(String examStr, String examAttStr) {
		examObject = loadJSON(examStr);
		examAttributesObject = loadJSON(examAttStr);
	}

	
	/**
	 * Check to see if a question can be used again based on attribute name and category. If so decrement and return true.
	 * @param name The name of the attribute to check
	 * @param cat The category that will also be checked.
	 * @return True if the question with the attribute name and category can be used still.
	 */
	private boolean checkNumberOfUses(String name, String cat) {
		try {
			if (usedQuestions.isEmpty()) { return true; }
			
			if (!usedQuestions.containsKey(name.toLowerCase())) {
				return false;
			}
			
			
			int catNumb = 1;
			if (usedQuestions.containsKey(cat.toLowerCase())) {
				catNumb = usedQuestions.get(cat.toLowerCase());
			}
			
			int numb = usedQuestions.get(name.toLowerCase());
			if (numb >= 1 && catNumb >= 1) {
				usedQuestions.replace(name.toLowerCase(), numb, numb - 1);
				if (usedQuestions.containsKey(cat.toLowerCase())) {
					usedQuestions.replace(cat.toLowerCase(), catNumb,catNumb - 1);
				}
				return true;
			} else {
				return false;
			}
		} catch (JSONException e) {
			System.out.print(ERROR_PARSE_QUESTION + e.getMessage());

		}
		return false;
	}
	
	
	/**
	 * Convert a JSONArray to a dynamic array (list)
	 * @param arr The JSONAray to convert to a list.
	 * @return The list that has been converted from a JSONAray
	 */
	private ArrayList<String> convertJSONArrayToList(JSONArray arr) {
		try {
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < arr.length(); i++) {
				list.add((String) arr.get(i));
			}
			return list;
		} catch (Exception e) {
			System.out.println("Error converting JSON Array to a list. - "+ e.getMessage());
		}
		return null;
	}

	
	/**
	 * Load in JSON into a JSONObject.
	 * @param str The sting the JSON is stored in.
	 * @return The JSONObject that represents the JSON given.
	 */
	public JSONObject loadJSON(String str) {
		try {
			return new JSONObject(str);
		} catch (JSONException e) {
			System.out.print("Error loading JSON data. - " + e.getMessage());
		}
		return null;
	}

	
	/**
	 * Parse everything needed for the exam.
	 * @return The generated exam object.
	 */
	public Exam parse() {
		try {
			parseAttributes(examAttributesObject);
			JSONArray qs = examObject.getJSONArray("questions");
			BaseQuestion tempQuestion;
			for (int i = 0; i < qs.length(); i++) {
				tempQuestion = parseQuestion((JSONObject) qs.get(i));
				if (tempQuestion != null) {
					genereatedExam.addQuestion(tempQuestion);
				}
			}
			return genereatedExam;
		} catch (JSONException|NullPointerException e) {
			System.out.print(ERROR_PARSE_EXAM + e.getMessage() + "\n");
			return null;
		}
	}

	
	/**
	 * Parse the JSON object and store the found attributes in a hash table.
	 * @param obj The JSONObject to parse.
	 */
	private void parseAttributes(JSONObject obj) {
		try {
			if (obj != null) {
				JSONArray atts = obj.getJSONArray("attributes");
				for (int i = 0; i < atts.length(); i++) {
					usedQuestions.put(
							((JSONObject) atts.get(i)).getString("name")
									.toLowerCase(), ((JSONObject) atts.get(i))
									.getInt("numberOfUses"));
				}
			}
		} catch (JSONException e) {
			System.out.print(ERROR_PARSE_ATTRIBUTES + e.getMessage());
		}
	}

	
	/**
	 * Parse a JSONObject into a question object.
	 * @param obj the JSONObject to parse.
	 * @return A BaseQuestion object that was parsed from the JSONObject.
	 */
	public BaseQuestion parseQuestion(JSONObject obj) {
		try {
			int type = obj.getInt("type");
			String text = obj.getString("text");
			String cat = obj.getString("category");
			BaseQuestion q = null;
			JSONArray ans;

			switch (type) {
			case 1:
				if (checkNumberOfUses("truefalse", cat)) {
					q = new TrueFalseQuestion(text, cat);
				}
				break;
			case 2:
				if (checkNumberOfUses("matching", cat)) {
					q = new MatchingQuestion(text, cat);
					ans = obj.getJSONArray("answers");
					q.setAnswers(convertJSONArrayToList(ans));
					JSONArray matchItems = obj.getJSONArray("matchingItems");
					((MatchingQuestion) q).setMatchingItems(convertJSONArrayToList(matchItems));
				}
				break;
			case 3:
				if (checkNumberOfUses("shortanswer", cat)) {
					q = new ShortAnswerQuestion(text, cat);
				}
				break;
			default:
				if (checkNumberOfUses("multiplechoice", cat)) {
					q = new MultipleChoiceQuestion(text, cat);
					ans = obj.getJSONArray("answers");
					q.setAnswers(convertJSONArrayToList(ans));
				}
				break;
			}
			return q;
		} catch (JSONException e) {
			System.out.print(ERROR_PARSE_QUESTION + e.getMessage());
		}
		return null;

	}

	
	/**
	 * Quick way to output a generated exam to the screen.
	 */
	public void print() {
		System.out.println(genereatedExam);
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return genereatedExam.toString();
	}

}
