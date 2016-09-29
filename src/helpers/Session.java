package helpers;

import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {
	private HttpServletRequest requestObj;
	private HttpSession sessionObj;
	private Cart cart;
	
	public Session(HttpServletRequest obj) {
		requestObj = obj;
		sessionObj = obj.getSession();
		
		if (sessionObj.getAttribute("cart") == null) {
			sessionObj.setAttribute("cart", new Cart());
		}
		
		cart = (Cart) sessionObj.getAttribute("cart");
	}
	
	public HttpSession getSession() {
		return sessionObj;
	}
	
	public Locale getLocale() {
		// See if a locale is set in session
		Locale locale = (Locale)sessionObj.getAttribute("locale");
		if (locale == null) {
			// If not, get the locale from the HTTP header
			Enumeration<Locale> preferredLocales = requestObj.getLocales();
			if (preferredLocales.hasMoreElements())
				locale = preferredLocales.nextElement();
		}
		
		if (locale == null) {
			// If session didn't contain a locale and the HTTP header didn't contain any
			// valid ones, fall back on server default.
			locale = Locale.getDefault();
		}
		
		return locale;
	}
	
	public void setLocale(Locale locale) {
		sessionObj.setAttribute("locale", locale);
	}
	
	public Cart getCart() {
		return cart;
	}
}
