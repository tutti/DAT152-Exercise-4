package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class ModelCollection<T extends Model> implements Iterable<T> {
	protected List<T> objects;
	protected Class<T> modelClass;
	
	public ModelCollection(Class<T> modelClass) throws Exception {
		objects = new ArrayList<T>();
		this.modelClass = modelClass;
		@SuppressWarnings("unchecked")
		List<Integer> indices = (List<Integer>) modelClass.getMethod("getIndices", modelClass.getClass()).invoke(null, modelClass);
		for (int i : indices) {
			objects.add(modelClass.getConstructor(Integer.TYPE).newInstance(i));
		}
	}
	
	public ModelCollection(ModelCollection<T> coll, Function<T, Boolean> inclusionTest) {
		objects = new ArrayList<T>();
		modelClass = coll.modelClass;
		for (T t : coll.objects) {
			if (inclusionTest.apply(t)) {
				objects.add(t);
			}
		}
	}
	
	public ModelCollection<T> where(Function<T, Boolean> inclusionTest) {
		return new ModelCollection<T>(this, inclusionTest);
	}
	
	public List<T> getObjects() {
		return objects;
	}
	
	public int size() {
		return objects.size();
	}
	
	public T get(int idx) {
		return objects.get(idx);
	}

	@Override
	public Iterator<T> iterator() {
		return objects.iterator();
	}
}
