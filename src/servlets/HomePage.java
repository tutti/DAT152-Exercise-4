package servlets;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import helpers.Locales;
import helpers.Session;

/**
 * Servlet implementation class HomePage
 */
@WebServlet("/home")
public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 3396124488396765330L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public HomePage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Session session = new Session(request);
		
		// If the user changed locale, record the change
		String lang = request.getParameter("lang");
		if (lang != null) {
			String[] split = lang.split("_");
			session.setLocale(new Locale(split[0], split[1]));
		}
		
		// Get the locale from the user
		Locale l = session.getLocale();
		request.setAttribute("locales", Locales.locales);
		Locale.setDefault(l); // Just so Java defaults to the actual default,
						// rather than the system language. Seriously, Java?
		
		// Load the resource bundle and make it available to the view
		Config.set( session.getSession(), Config.FMT_LOCALE, l );
		
		request.getRequestDispatcher("WEB-INF/HomePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
