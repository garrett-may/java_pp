package javapp.util;

import java.lang.reflect.Array;

public final class Collections {
	
	private Collections() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static <T> ArrayList<T> asArrayList(T...ts) {
		ArrayList<T> list = new ArrayList<T>();
		for(T t : ts) list.add(t);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> LinkedList<T> asLinkedList(T...ts) {
		LinkedList<T> list = new LinkedList<T>();
		for(T t : ts) list.add(t);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Queue<T> asQueue(T...ts) {
		return asLinkedList(ts);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Stack<T> asStack(T...ts) {
		Stack<T> stack = new Stack<T>();
		for(T t : ts) stack.push(t);
		return stack;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> HashSet<T> asHashSet(T...ts) {
		HashSet<T> set = new HashSet<T>();
		for(T t : ts) set.add(t);
		return set;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] asArray(Collection<T> collection) {
		T[] array = (T[]) Array.newInstance(collection.iterator().next().getClass(), collection.size());
		int index = 0;
		for(T T : collection) {
			array[index++] = T;
		}
		return array;
	}
	
	public static <T> javapp.lang.Iterable<T> reversed(javapp.lang.Iterable<T> iterable) {
		return new javapp.lang.Iterable<T>() {

			@Override
			public Iterator<T> nextIterator() {
				return iterable.prevIterator();
			}

			@Override
			public Iterator<T> prevIterator() {
				return iterable.nextIterator();
			}
			
		};
	}
}
