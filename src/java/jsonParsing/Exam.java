package jsonParsing;

import java.util.Arrays;

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
	BaseQuestion[] questions;
	int totalQuestions = 0;
	
	
	public Exam(){}
	
	
	public Exam(String name){
		setName(name);
	}
	
	
	public Exam(String name, BaseQuestion[] questions){
		this(name);
		setQuestions(questions);
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * @return the questions
	 */
	public BaseQuestion[] getQuestions() {
		return questions;
	}

	
	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(BaseQuestion[] questions) {
		this.questions = questions;
	}

	
	/**
	 * @return the totalQuestions
	 */
	public int getTotalQuestions() {
		return totalQuestions;
	}

	
	/**
	 * @param totalQuestions the totalQuestions to set
	 */
	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Exam [name=" + name + ", questions="
				+ Arrays.toString(questions) + ", totalQuestions="
				+ totalQuestions + "]"; //TODO: Temp
	}
	
	
	
}
