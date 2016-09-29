package models;

import model.HardcodedModel;

public class Product extends HardcodedModel {
	public static HardcodedModel[] data;
	static {
		// Java won't accept array literals unless they're in the initialiser. Seriously, Java?
		Product[] _data = {
				new Product(1, "White Coffee Cup", 6.5, "images/whitecup.jpg"),
				new Product(2, "Black Coffee Cup", 7.5, "images/blackcup.jpg")
		};
		data = _data;
	}
	
	public int pno;
	public String pName;
	public double priceInEuro;
	public String imageURL;
	public Description description = null;
	
	private Product(int index, String pName, double priceInEuro, String imageURL) {
		super();
		pno = index;
		this.pName = pName;
		this.priceInEuro = priceInEuro;
		this.imageURL = imageURL;
	}
	
	public Product(int index) throws Exception {
		super(index);
	}
	
	public String toString() {
		return pno + " " + pName;
	}

	@Override
	public void load(int index) throws Exception {
		pno = index;
		Product p = (Product) data[index-1];
		this.pName = p.pName;
		this.priceInEuro = p.priceInEuro;
		this.imageURL = p.imageURL;
	}
	
	// Getters because JSP can't get public properties from objects. Seriously, Java?
	public int getPno() {
		return pno;
	}
	
	public String getPname() {
		// If the method was named "getPName" (with a capitalised n), and the JSP code tried
		// to access "product.pName", this would complain that the field wasn't found.
		// This, however, works. Seriously, Java?
		return pName;
	}
	
	public double getPriceInEuro() {
		return priceInEuro;
	}
	
	public String getImageURL() {
		return imageURL;
	}
	
	public Description getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imageURL == null) ? 0 : imageURL.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + pno;
		long temp;
		temp = Double.doubleToLongBits(priceInEuro);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof Product)) return false;
		Product p = (Product) o;
		return pno == p.pno;
	}
	
}
