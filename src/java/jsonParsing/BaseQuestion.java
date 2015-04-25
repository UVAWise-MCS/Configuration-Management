package jsonParsing;

import java.util.ArrayList;

public abstract class BaseQuestion 
{
	protected String text;
	protected int type;
	protected String category;
	protected String heading;
	protected ArrayList<Answer> answers = new ArrayList<Answer>();
	
	public BaseQuestion(){}
	
	public BaseQuestion(String txt, int typ, ArrayList<Answer> ans, String cat)
	{
		this(txt, typ, cat);
		answers = ans;			
	}
	
	public BaseQuestion (String txt, int typ, String cat)
	{
		text = txt;
		type = typ;
		category = cat;
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
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public String getHeading() {
		return heading;
	}
	
	public String getText() 
	{
		return text;
	}
	
	public int getType()
	{
		return type;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}

	protected void setCategory(String Category)
	{
		category = Category;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	protected void setText(String Text)
	{
		text = Text;
	}
	
	protected  void setType(int Type)
	{
		type = Type;
	}
		
	@Override
	public abstract String toString();
	
}
