package jsonParsing;

import java.util.ArrayList;

public class MultipleChoiceQuestion extends BaseQuestion 
{ 
	
	public MultipleChoiceQuestion()					//Default constructor.
	{
		super();
		type = 0;
	}
	
	public MultipleChoiceQuestion(String txt, String cat) 		//Overloaded constructor
	{
		super(txt, 0, cat);
		
	}
	
	public MultipleChoiceQuestion(String txt, ArrayList<Answer> ans, String cat)
	{
		super(txt, 0, ans, cat);					//Overloaded constructor
		
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
	    result.append(this.getText() + NEW_LINE);
	    for(Answer a: answers){
	    	result.append(ch+") " + a + NEW_LINE);
	    	ch++;
	    }
	    return result.toString();
	  }
	
	
	
}
