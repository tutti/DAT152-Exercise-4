package tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ShortTextTag extends SimpleTagSupport {
	private int maxchars;
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		StringWriter sw = new StringWriter();
		getJspBody().invoke(sw);
		String body = sw.toString();
		if (body.length() > maxchars) {
			out.print(body.substring(0, maxchars));
			out.print("...");
		} else {
			out.print(body);
		}
	}
	
	public void setMaxchars(String maxchars) {
		try {
			this.maxchars = Integer.parseInt(maxchars);
		} catch (Exception e) {
			this.maxchars = 10;
		}
	}
}
