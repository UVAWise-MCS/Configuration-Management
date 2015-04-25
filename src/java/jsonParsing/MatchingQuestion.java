package jsonParsing;

public class MatchingQuestion extends BaseQuestion
{
	//Using the Question class an array of questions is added as a private member variable 
	//of the Matching questions class.
	protected String Questions[];

	
	public MatchingQuestion()				//Default constructor.
	{
		super();
	}
	
	public MatchingQuestion (String question,int typ, String cat) 		//Overloaded constructor
	{
		super(question, typ, cat);
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
	    for (int i = 0; i<= Questions.length; i++) {
	    	result.append((i+1)+") " + Questions[0]+"\t"+ch+") "+Answers[0].getText()+ NEW_LINE);
	    	ch++;
	    }
	    
	    return result.toString();
	}
}
