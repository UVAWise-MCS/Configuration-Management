package jsonParsing;

import java.util.ArrayList;

/**
 * Exam is a class to provide a data structure that represents an exam as a whole.
 * The exam contains all the questions for the exam and other details.
 * 
 * JSON is parsed and loaded into this class.
 * 
 * @author Bryan Smith
 * @date 4/21/15
 */
//TODO Update ClassDiagrams and SDD to show this new class.

public class Exam {
	//TODO Create a higher level class that contains all the questions and answers.
	
	String name = "Exam";
	ArrayList<BaseQuestion> questions = new ArrayList<BaseQuestion>();	
	
	public Exam(){}
	
	
	public Exam(String name){
		setName(name);
	}
	
	
	public Exam(String name, ArrayList<BaseQuestion> questions){
		this(name);
		setQuestions(questions);
	}

	
	public void addQuestion(BaseQuestion q){
		getQuestions().add(q);
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @return the questions
	 */
	public ArrayList<BaseQuestion> getQuestions() {
		return questions;
	}

	
	/**
	 * @return the totalQuestions
	 */
	public int getTotalQuestions() {
		return getQuestions().size();
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param questions2 the questions to set
	 */
	public void setQuestions(ArrayList<BaseQuestion> questions) {
		this.questions = questions;
	}


	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    for(BaseQuestion q: questions){
	    	result.append(q + NEW_LINE);
	    }
		
		return result.toString();
	}
	
	
	
	
}
