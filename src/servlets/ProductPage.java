package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

import helpers.Locales;
import helpers.Session;
import model.ModelCollection;
import models.Description;
import models.Product;

/**
 * Servlet implementation class ProductPage
 */
@WebServlet("/products")
public class ProductPage extends HttpServlet {
	private static final long serialVersionUID = -2909259842576625375L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
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
			//ResourceBundle rb = ResourceBundle.getBundle("bundles.CoffeeShop", l);
			//request.setAttribute("L", rb);
			Config.set( session.getSession(), Config.FMT_LOCALE, l );
			
			// Load the product list
			ModelCollection<Product> products = new ModelCollection<Product>(Product.class);
			request.setAttribute("products", products);
			
			// A list of language codes to look for descriptions for
			List<String> codes = new ArrayList<String>();
			if (!l.getCountry().equals("")) {
				if (!l.getVariant().equals("")) {
					codes.add(l.getLanguage()+"_"+l.getCountry()+"_"+l.getVariant());
				}
				codes.add(l.getLanguage()+"_"+l.getCountry());
			}
			if (!l.getVariant().equals("")) {
				codes.add(l.getLanguage()+"_"+l.getVariant());
			}
			codes.add(l.getLanguage());
			codes.add("en_US");
			
			for (Product p : products) {
				ModelCollection<Description> allDescriptions = new ModelCollection<Description>(Description.class).where((d) -> (d.pno == p.pno));
				for (String code : codes) {
					ModelCollection<Description> tryDescriptions = allDescriptions.where((d) -> d.langCode.equals(code));
					if (tryDescriptions.size() > 0) {
						p.description = tryDescriptions.get(0);
						break;
					}
				}
				if (p.description == null) {
					p.description = Description.NONE;
				}
			}
			
			request.getRequestDispatcher("WEB-INF/ProductPage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		try {
			Session session = new Session(request);
			
			int pno = Integer.parseInt(request.getParameter("pno"));
			
			session.getCart().addItem(new Product(pno));
			
			response.sendRedirect("products");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
