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
		char ch = 'A';
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    result.append("Mulitple Choice Question :" + this.getCategory() + NEW_LINE);
	    result.append(this.getText() + " ?" + NEW_LINE);
	    for(Answer a: Answers){
	    	result.append(ch+") " + a.getText() + NEW_LINE);
	    	ch++;
	    }
	    return result.toString();
	  }
	
	
	
}
