package jsonParsing;

import java.util.ArrayList;

public class MatchingQuestion extends BaseQuestion
{
	//Using the Question class an array of questions is added as a private member variable 
	//of the Matching questions class.
	protected ArrayList<String> matchingItems = new ArrayList<String>();

	
	public MatchingQuestion()				//Default constructor.
	{
		super();
		type = 2;
	}
	
	public MatchingQuestion (String question, String cat) 		//Overloaded constructor
	{
		super(question, 2, cat);
	}
	
	public void addMatchingItem(String item){
		matchingItems.add(item);
	}
	
	
	//ToString method to display a matching question as follows :
	//Matching Question : category
	//1) question 1			A) possible answer
	//2) question 2			B) possible answer
	//3) question 3			C) possible answer
	//4) question 4			D) possible answer
	//***********************************************
	@Override
	public String toString() {
		char ch = 'A';
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    result.append("Matching Question :" + this.getCategory() + NEW_LINE);
	    for (int i = 0; i< matchingItems.size(); i++) {
	    	result.append((i+1)+") " + matchingItems.get(i)+"\t"+ch+") "+answers.get(i)+ NEW_LINE);
	    	ch++;
	    }
	    
	    return result.toString();
	}
}
