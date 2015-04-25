package jsonParsing;

public abstract class BaseQuestion 
{
	protected  String text;
	protected int type;
	protected String category; 
	protected Answer[] Answers = new Answer[4];
	
	protected BaseQuestion()
	{
		
	}
	
	protected BaseQuestion (String txt, int typ, String cat)
	{
		text = txt;
		type = typ;
		category = cat;
	}
	
	protected BaseQuestion(String txt, int typ,Answer[] ans, String cat)
	{
		text = txt; 
		type = typ;
		category = cat;
		Answers = ans;			
	}
		
	protected String getText() 
	{
		return text;
	}
	
	protected void setText(String Text)
	{
		text = Text;
	}
	
	protected int getType()
	{
		return type;
	}
	
	protected  void setType(int Type)
	{
		type = Type;
	}
	
	protected String getCategory()
	{
		return category;
	}
	
	protected void setCategory(String Category)
	{
		category = Category;
	}
	
	protected Answer addAnswers(String Text, int Val)
	{
		Answer Ans = new Answer();
		Ans.setText(Text);
		Ans.setValue(Val);
		return Ans;
	}
		
	public String toString() 
	{
		String result = "";
		return result;
	}
	
	public static void main(String args[])
	{
		//Matching question example 
		
		MatchingQuestion p = new MatchingQuestion("Match each capital with its country", 0, "Geography");	
		Answer answer1 = new Answer("England", 1);	//defines the answers.
		Answer answer2 = new Answer("France", 2);
		Answer answer3 = new Answer("Germany", 3);
		Answer answer4 = new Answer("Italy", 4);
		p.Answers[0] = answer1;						//associate the answers above with the array
		p.Answers[1] = answer2;					    //of answers inherited from baseQuestion
		p.Answers[2] = answer3;
		p.Answers[3] = answer4;		
		Question q1 = new Question("Paris");		//Using the Question class, the second portion
		Question q2 = new Question("Milan");		//of the matching question are defined to match
		Question q3 = new Question("London");		//the answers aforementioned
		Question q4 = new Question("Berlin");
		
		p.Questions[0] = q1;						//Associate the questions with the array 
		p.Questions[1] = q2;						//variables defined in matching question object
		p.Questions[2] = q3;
		p.Questions[3] = q4;
		System.out.println(p.toString());
		
		//End of matching question example
		//True /False Question example
		
		TrueFalseQuestion Question1 = new TrueFalseQuestion("Is it Raining", 0, "Weather");
		TrueFalseQuestion Question2 = new TrueFalseQuestion("Are you there", 1, "General");
		TrueFalseQuestion Question3 = new TrueFalseQuestion("Is it hot", 2, "Weather");
		System.out.println(Question1.toString());
		System.out.println(Question2.toString());
		System.out.println(Question3.toString());
		
		//End of True/False question example.
		//Short Answer question example
		
		ShortAnswerQuestion Question4 = new ShortAnswerQuestion("Are you awake", 0, "General");
		ShortAnswerQuestion Question5 = new ShortAnswerQuestion("Are you high", 1, "DUI check");
		ShortAnswerQuestion Question6 = new ShortAnswerQuestion("Are you drunk", 2, "Sobriety check");
		System.out.println(Question4.toString());
		System.out.println(Question5.toString());
		System.out.println(Question6.toString());
		
		//End of Short Answer question example
		//Multiple choice question example
		
		MultipleChoiceQuestion Question7 = new MultipleChoiceQuestion("How are you", 0, "General");
		Answer answer5 = new Answer("Well", 5);	
		Answer answer6 = new Answer("Very well", 6);
		Answer answer7 = new Answer("not well", 7);
		Answer answer8 = new Answer("not very well", 8);

		Question7.Answers[0] = answer5;						//associate the answers above with the array
		Question7.Answers[1] = answer6;					    //of answers inherited from baseQuestion
		Question7.Answers[2] = answer7;
		Question7.Answers[3] = answer8;
		
		System.out.println(Question7.toString());
		
	}

	

}
