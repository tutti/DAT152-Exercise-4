package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class FileModel extends Model {
	
	public FileModel(int index) throws Exception {
		super(index);
	}
	
	public final void load(int index) throws FileNotFoundException {
		String filename = getClass().getSimpleName() + "/" + index + ".txt";
		Scanner in = new Scanner(new FileReader(filename));
		while (in.hasNext()) {
			String line = in.nextLine();
			String[] split = line.split("=");
			if (split.length >= 2)
				setField(split[0], split[1]);
		}
		in.close();
	}
	
	public final void save() {
		// TODO
	}
	
	public final static List<Integer> getIndices(@SuppressWarnings("rawtypes") Class c) {
		List<Integer> indices = new ArrayList<Integer>();
		String cn = c.getSimpleName();
		File directory = new File(cn);
		File[] files = directory.listFiles();
		for (File f : files) {
			String fn = f.getName();
			if (f.isFile() && fn.substring(fn.length() - 4, fn.length()).equals(".txt")) {
				try {
					indices.add(Integer.parseInt(fn.substring(0, fn.length() - 4)));
				} catch (Exception ex) {}
			}
		}
		return indices;
	}
	
	private void setField(String fname, String val) {
		Field field;
		
		try {
			field = getClass().getDeclaredField(fname);
		} catch (NoSuchFieldException e) {
			return;
		}
		
		try {
			switch (field.getType().toString()) {
				// Boolean
				case "boolean":
					field.setBoolean(this, Boolean.parseBoolean(val));
					break;
				// Integer types
				case "byte":
					field.setByte(this, Byte.parseByte(val));
					break;
				case "char":
					field.setChar(this, val.charAt(0));
					break;
				case "short":
					field.setShort(this, Short.parseShort(val));
					break;
				case "int":
					field.setInt(this, Integer.parseInt(val));
					break;
				case "long":
					field.setLong(this, Long.parseLong(val));
					break;
				// Floating types
				case "float":
					field.setFloat(this, Float.parseFloat(val));
					break;
				case "double":
					field.setDouble(this, Double.parseDouble(val));
					break;
				// String
				case "class java.lang.String":
					field.set(this, val);
					break;
			}
		} catch (IllegalAccessException e) {
			return;
		}
		
	}
}
