package jsonParsing;

import java.util.ArrayList;

/**
 * Exam is a class to provide a data structure that represents an exam as a
 * whole. The exam contains all the questions for the exam and other details.
 * 
 * JSON is parsed and loaded into this class.
 * 
 * @author Bryan Smith
 * @date 4/21/15
 */
public class Exam {

	String name = "Exam";
	ArrayList<BaseQuestion> questions = new ArrayList<BaseQuestion>();

	
	/**
	 * Exam constructor
	 */
	public Exam() {}
	
	/**
	 * Exam constructor
	 * @param name The name of the exam.
	 */
	public Exam(String name) {
		setName(name);
	}

	
	/**
	 * Exam constructor
	 * @param name The name of the exam.
	 * @param questions A list of questions for the exam.
	 */
	public Exam(String name, ArrayList<BaseQuestion> questions) {
		this(name);
		setQuestions(questions);
	}

	
	
	/**
	 * Add a question to the exam.
	 * @param q The question to add to the exam.
	 */
	public void addQuestion(BaseQuestion q) {
		getQuestions().add(q);
	}

	
	/**
	 * Get the name of the Exam.
	 * @return the name of the exam.
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Get a list of the questions in the exam.
	 * @return the list of questions
	 */
	public ArrayList<BaseQuestion> getQuestions() {
		return questions;
	}

	
	/**
	 * Get the total number of questions the exam has.
	 * @return the total number of questions the exam has.
	 */
	public int getTotalQuestions() {
		return getQuestions().size();
	}

	
	/**
	 * Set the name of the Exam.
	 * @param name The name to set for the exam.
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Set a group of questions for the exam.
	 * @param questions The questions to set for the exam.
	 */
	public void setQuestions(ArrayList<BaseQuestion> questions) {
		this.questions = questions;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		for (BaseQuestion q : questions) {
			result.append(q + NEW_LINE);
		}

		return result.toString();
	}

}
