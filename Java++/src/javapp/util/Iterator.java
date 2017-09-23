package javapp.util;

public interface Iterator<T> extends java.util.Iterator<T> {

	public boolean hasNext();
	
	public T next();
}
