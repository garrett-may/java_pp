package javapp.util;

public class ArrayList<T> extends java.util.ArrayList<T> implements List<T>, Collection<T> {

	private static final long serialVersionUID = 7358471882735023697L;
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> copy(){
		ArrayList<T> copy = new ArrayList<T>();
		for(T t : this) {
			copy.add(t);
		}
		return copy;
	}
}
