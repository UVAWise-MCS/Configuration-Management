package jsonParsing;

public class TrueFalseQuestion extends BaseQuestion
{

	public TrueFalseQuestion()				//Default constructor
	{
		super();
		type = 1;
	}
	
	public TrueFalseQuestion (String question, String cat ) 	//Overloaded constructor
	{
		super(question, 1, cat);
	}
	
	
	//ToString method to display a True / False question as follows : 
	//True/False Question : category
	//Question?
	//A) True
	//B) False
	//***************************************************************
	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    result.append("True/False Question : "+ this.getCategory() + NEW_LINE);
	    result.append(this.getText() + " ?" + NEW_LINE);
	    result.append("A) True " +  NEW_LINE);
	    result.append("B) False " + NEW_LINE);
	    return result.toString();
	  }
	
	
	
	
}
