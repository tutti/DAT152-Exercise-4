package helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import models.Product;

public class Cart implements Iterable<Map.Entry<Product, Integer>> {
	private Map<Product, Integer> cart;
	private int size;
	
	public class CartIterator implements Iterator<Map.Entry<Product, Integer>> {
		private List<Map.Entry<Product, Integer>> entries;
		private int counter;
		
		public CartIterator(Cart cart) {
			counter = 0;
			
			entries = new ArrayList<Map.Entry<Product, Integer>>();
			for (Map.Entry<Product, Integer> entry : cart.cart.entrySet()) {
				entries.add(entry);
			}
		}

		@Override
		public boolean hasNext() {
			return counter < entries.size();
		}

		@Override
		public Map.Entry<Product, Integer> next() {
			return entries.get(counter++);
		}
	}
	
	public Cart() {
		cart = new HashMap<Product, Integer>();
		size = 0;
	}
	
	public void addItem(Product p, int count) {
		if (cart.containsKey(p)) {
			cart.put(p, cart.get(p)+count);
		} else {
			cart.put(p, count);
		}
		size += count;
	}
	
	public void addItem(Product p) {
		addItem(p, 1);
	}
	
	public void removeItem(Product p, int count) {
		if (cart.containsKey(p) && cart.get(p) >= count) {
			cart.put(p, cart.get(p)-count);
			size -= count;
		} else {
			throw new RuntimeException("Cart doesn't contain that many of that.");
		}
	}
	
	public void removeItem(Product p) {
		removeItem(p, 1);
	}
	
	public int size() {
		return size;
	}
	
	public Map<Product, Integer> getContents() {
		return cart;
	}
	
	public Iterator<Map.Entry<Product, Integer>> iterator() {
		return new CartIterator(this);
	}
	
	public List<Map.Entry<Product, Integer>> getEntryList() {
		List<Map.Entry<Product, Integer>> list = new ArrayList<Map.Entry<Product, Integer>>();

		for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
			list.add(entry);
		}
		
		return list;
	}
}
