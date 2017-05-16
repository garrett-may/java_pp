package javapp.util;

public class HashSet<T> extends java.util.HashSet<T> implements Set<T>, Collection<T> {

	private static final long serialVersionUID = -3940315582013352269L;

	@SuppressWarnings("unchecked")
	public HashSet<T> copy() {
		HashSet<T> copy = new HashSet<T>();
		for(T t : this) {
			copy.add(t);
		}
		return copy;
	}
}
