package javapp.lang;

public interface Iterable<T> extends java.lang.Iterable<T> {

	public default java.util.Iterator<T> iterator() {
		return nextIterator();
	}
	
	public javapp.util.Iterator<T> nextIterator();
	
	public javapp.util.Iterator<T> prevIterator();
	
}
