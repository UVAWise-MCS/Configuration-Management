package jsonParsing;

class Answer 
{
	private String text;  					//String Variable to contain the Question
	private int value;						//Integer variable to contain the value of a question
		
	public Answer()							//Default constructor			
	{
		text = "";
		value = 0;
	}
	
	public Answer(String txt, int val)		//constructor with two arguments.
	{
		text = txt;
		value = val;
	}

	public String getText()					//Utility function
	{
		return text;
	}
	
	public void setText(String txt)			//Utility function
	{
		text = txt;
	}
	
	public int getValue()					//Utility function
	{
		return value;
	}
	
	public void setValue(int Value)			//Utility function
	{
		value = Value;
	}



}
