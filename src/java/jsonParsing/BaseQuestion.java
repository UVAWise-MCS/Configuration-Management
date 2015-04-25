package jsonParsing;

import java.util.ArrayList;

public abstract class BaseQuestion 
{
	protected String text;
	protected int type;
	protected String category; 
	protected ArrayList<Answer> answers = new ArrayList<Answer>();
	
	public BaseQuestion()
	{
		
	}
	
	public BaseQuestion (String txt, int typ, String cat)
	{
		text = txt;
		type = typ;
		category = cat;
	}
	
	public BaseQuestion(String txt, int typ, ArrayList<Answer> ans, String cat)
	{
		text = txt; 
		type = typ;
		category = cat;
		answers = ans;			
	}
		
	public String getText() 
	{
		return text;
	}
	
	protected void setText(String Text)
	{
		text = Text;
	}
	
	public int getType()
	{
		return type;
	}
	
	protected  void setType(int Type)
	{
		type = Type;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	protected void setCategory(String Category)
	{
		category = Category;
	}
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
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
