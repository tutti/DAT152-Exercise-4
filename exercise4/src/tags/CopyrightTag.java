package tags;

import java.io.IOException;
import java.time.Year;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import helpers.RomanNumerals;

public class CopyrightTag extends SimpleTagSupport {
	private int since;
	
	@Override
	public void doTag() throws IOException, JspException {
		JspWriter out = getJspContext().getOut();
		out.print("© ");
		out.print(RomanNumerals.convert(since));
		out.print("-");
		out.print(RomanNumerals.convert(Year.now().getValue()));
		out.print(" ");
		getJspBody().invoke(null);
	}
	
	public void setSince(String since) {
		try {
			this.since = Integer.parseInt(since);
		} catch (Exception e) {
			this.since = 1;
		}
	}
}
