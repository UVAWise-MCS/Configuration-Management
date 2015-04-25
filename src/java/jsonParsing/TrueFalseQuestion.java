package jsonParsing;

public class TrueFalseQuestion extends MultipleChoiceQuestion
{

	public TrueFalseQuestion()				//Default constructor
	{
		super();
		type = 1;
		setupTrueFalse();
	}
	
	public TrueFalseQuestion (String question, String cat ) 	//Overloaded constructor
	{
		super(question, cat);
		type = 1;
		setupTrueFalse();
	}
	
	private void setupTrueFalse() {
		heading = "True/False Question : " +this.getCategory();
		addAnswer("True");
		addAnswer("False");
	}
	
}
