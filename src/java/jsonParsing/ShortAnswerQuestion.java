package jsonParsing;

public class ShortAnswerQuestion extends BaseQuestion {

	public ShortAnswerQuestion() // Default constructor
	{
		super();
		type = 3;
		heading = "Short Answer : ";
	}

	public ShortAnswerQuestion(String question, String cat) // Overloaded
															// constructor
	{
		super(question, 3, cat);
		heading = "Short Answer : " + this.getCategory();
	}

	// ToString method to display a short question as follows :
	// Short Question : category
	// Question?
	// *********************************************
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String NEW_LINE = System.getProperty("line.separator");
		result.append(heading + NEW_LINE);
		result.append(this.getText() + NEW_LINE);
		return result.toString();
	}

}
