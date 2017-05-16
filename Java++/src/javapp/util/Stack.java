package javapp.util;

public class Stack<T> extends java.util.Stack<T> implements List<T>, Collection<T> {

	private static final long serialVersionUID = 3140952778863051297L;

	@SuppressWarnings("unchecked")
	public Stack<T> copy() {
		Stack<T> copy = new Stack<T>();
		for(T t : this) {
			copy.add(t);
		}
		return copy;
	}
}
