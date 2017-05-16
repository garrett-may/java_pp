package javapp.util;

public class LinkedList<T> extends java.util.LinkedList<T> implements List<T>, Queue<T>, Collection<T> {

	private static final long serialVersionUID = 479910602055777450L;

	@SuppressWarnings("unchecked")
	public LinkedList<T> copy() {
		LinkedList<T> copy = new LinkedList<T>();
		for(T t : this) {
			copy.add(t);
		}
		return copy;
	}
	
}
