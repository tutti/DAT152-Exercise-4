package model;
import java.util.List;

public abstract class Model {
	
	/**
	 * Empty do-nothing constructor for children that might need one.
	 * This is necessary because Java doesn't let you have a constructor that
	 * doesn't call a parent constructor. Seriously, Java?
	 */
	protected Model() {}
	
	public Model(int index) throws Exception {
		this.load(index);
	}
	
	public abstract void load(int index) throws Exception;
	public abstract void save() throws Exception;
	public static List<Integer> getIndices(@SuppressWarnings("rawtypes") Class c) throws Exception {
		throw new Exception("getIndices() has not been implemented for this class.");
	}
}
