package jsonParsing;

public class MultipleChoiceQuestion extends BaseQuestion 
{ 
	
	public MultipleChoiceQuestion()					//Default constructor.
	{
		super();
	}
	
	public MultipleChoiceQuestion(String txt, int typ, String cat) 		//Overloaded constructor
	{
		super(txt, typ,cat);
		
	}
	
	public MultipleChoiceQuestion(String txt, int typ,Answer[] ans, String cat) 
	{
		super(txt, typ,ans,cat);					//Overloaded constructor
		
	}
	
	//ToString method to display a multiple choice question using the following format :
	//Question?
	//A) answerA
	//B) answerB
	//C) answerC
	//D) answerD
	//********************************************************
	@Override
	public String toString() {
		
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    result.append("Mulitple Choice Question :" + this.getCategory() + NEW_LINE);
	    result.append(this.getText() + " ?" + NEW_LINE);
	    result.append("A) " + Answers[0].getText() + NEW_LINE);
	    result.append("B) " + Answers[1].getText() + NEW_LINE);
	    result.append("C) " + Answers[2].getText() + NEW_LINE );
	    result.append("D) " + Answers[3].getText() + NEW_LINE);
	    return result.toString();
	  }
	
	
	
}
