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
	
}
