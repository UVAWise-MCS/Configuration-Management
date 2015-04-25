package jsonParsing;

public class MatchingQuestion extends BaseQuestion
{
	//Using the Question class an array of questions is added as a private member variable 
	//of the Matching questions class.
	protected Question Questions[] = new Question[4];

	
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
		
		StringBuilder result = new StringBuilder();
	    String NEW_LINE = System.getProperty("line.separator");
	    result.append("Matching Question :" + this.getCategory() + NEW_LINE);
	    result.append("1) " + Questions[0].getQuestion()+"\t"+"A) "+Answers[0].getText()+ NEW_LINE);
	    result.append("2) " + Questions[1].getQuestion()+"\t"+"B) "+Answers[1].getText()+ NEW_LINE);
	    result.append("3) " + Questions[2].getQuestion()+"\t"+"C) "+Answers[2].getText()+ NEW_LINE);
	    result.append("4) " + Questions[3].getQuestion()+"\t"+"D) "+Answers[3].getText()+ NEW_LINE);
	    
	    return result.toString();
	}
}
