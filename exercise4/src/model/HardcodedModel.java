package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This is necessary because the FileModel class, although perfectly usable in plain programs,
 * can't be used in a web project because code called from a servlet can't read local files
 * without an absolute path. Seriously, Java?
 * @author Pål V. Gjerde
 *
 */
public abstract class HardcodedModel extends Model {
	protected static HardcodedModel[] data = {};
	
	protected HardcodedModel() {}
	
	public HardcodedModel(int index) throws Exception {
		super(index);
	}
	
	public final void save() throws Exception {
		throw new Exception("Can't save a hardcoded model.");
	}
	
	public final static List<Integer> getIndices(@SuppressWarnings("rawtypes") Class c) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		List<Integer> indices = new ArrayList<Integer>();
		for (int i = 0; i < ((HardcodedModel[])c.getField("data").get(null)).length; ++i) {
			
			indices.add(i+1);
		}
		return indices;
	}

}
