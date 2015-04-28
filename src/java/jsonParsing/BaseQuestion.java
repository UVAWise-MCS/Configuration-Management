package jsonParsing;

import java.util.ArrayList;

public abstract class BaseQuestion {
	protected String text;
	protected int type;
	protected String category;
	protected String heading;
	protected ArrayList<String> answers = new ArrayList<String>();

	public BaseQuestion() {
	}

	public BaseQuestion(String txt, int typ, ArrayList<String> ans, String cat) {
		this(txt, typ, cat);
		answers = ans;
	}

	public BaseQuestion(String txt, int typ, String cat) {
		text = txt;
		type = typ;
		category = cat;
	}

	public void addAnswer(String text) {
		answers.add(text);
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public String getCategory() {
		return category;
	}

	protected String getHeading() {
		return heading;
	}

	public String getText() {
		return text;
	}

	public int getType() {
		return type;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}

	protected void setCategory(String Category) {
		category = Category;
	}

	protected void setHeading(String heading) {
		this.heading = heading;
	}

	protected void setText(String Text) {
		text = Text;
	}

	protected void setType(int Type) {
		type = Type;
	}

	@Override
	public abstract String toString();

}
