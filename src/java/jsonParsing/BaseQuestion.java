package jsonParsing;

import java.util.ArrayList;

public abstract class BaseQuestion 
{
	protected String text;
	protected int type;
	protected String category; 
	protected ArrayList<Answer> answers = new ArrayList<Answer>();
	
	protected BaseQuestion()
	{
		
	}
	
	protected BaseQuestion (String txt, int typ, String cat)
	{
		text = txt;
		type = typ;
		category = cat;
	}
	
	protected BaseQuestion(String txt, int typ, ArrayList<Answer> ans, String cat)
	{
		text = txt; 
		type = typ;
		category = cat;
		answers = ans;			
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
	
	public void addAnswer(Answer ans)
	{
		answers.add(ans);
	}
	
	public void addAnswer(String text, int val)
	{
		Answer ans = new Answer();
		ans.setText(text);
		ans.setValue(val);
		answers.add(ans);
	}
		
	public abstract String toString();
	
}
