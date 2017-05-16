package javapp.util;

public interface Collection<K> extends java.util.Collection<K>, javapp.lang.Object {
	
	public static interface Filter<K> {
		public boolean operation(K key);
	}
	
	public default <C extends Collection<K>> C filter(Filter<K> filter) {
		C collection = emptyCollection();
		for(K key : this) {
			if(filter.operation(key)) collection.add(key);
		}
		return collection;
	}
	
	public static interface Mapping<K, V> {
		public V operation(K key);
	}
	
	public default <C extends Collection<V>, V> C map(Mapping<K, V> mapping) {
		C collection = emptyCollection();
		for(K key : this) {
			collection.add(mapping.operation(key));
		}
		return collection;
	}
	
	public static interface Fold<K> {
		public K operation(K key1, K key2);
	}
	
	public default <C extends Collection<K>> K foldr(Fold<K> fold) {
		C collection = emptyCollection();
		for(K key : this) collection.add(key);
		if(size() == 0) return null;
		K key = collection.stream().findFirst().get();
		if(size() == 1) return key;
		collection.remove(key);
		return fold.operation(key, collection.foldr(fold));
	}
	
	public default <C extends Collection<K>> K foldl(Fold<K> fold) {
		C collection = emptyCollection();
		for(K key : this) collection.add(key);
		if(size() == 0) return null;
		K key = collection.stream().findFirst().get();
		if(size() == 1) return key;
		collection.remove(key);
		return fold.operation(collection.foldl(fold), key);
	}	
	
	public default K head() {
		return foldr((x, y) -> x);
	}
	
	public default K last() {
		return foldl((x, y) -> x);
	}
	
	public default <C extends Collection<K>> C tail() {
		C collection = emptyCollection();
		if(size() == 0) return collection;
		for(K k : this) {
			if(k != head()) collection.add(k);
		}
		return collection;
	}
	
	public default <C extends Collection<K>> C init() {
		C collection = emptyCollection();
		if(size() == 0) return collection;
		for(K k : this) {
			if(k != last()) collection.add(k);
		}
		return collection;
	}
	
	public default <C extends Collection<K>> C takeWhile(Filter<K> take) {
		C collection = emptyCollection();
		for(K k : this) {
			if(take.operation(k)) {
				collection.add(k);
			}
			else {
				return collection;
			}
			
		}
		return collection;
	}
	
	public default <C extends Collection<K>> C skipWhile(Filter<K> skip) {
		C collection = emptyCollection();
		for(K k : this) {
			if(skip.operation(k)) {
				continue;
			} else {
				collection.add(k);
			}			
		}
		return collection;
	}
	
	public default <C extends Collection<K>> C take(int number) {
		C collection = emptyCollection();
		for(K k : this) {
			if(number-- > 0) {
				collection.add(k);
			} else {
				return collection;
			}
			
		}
		return collection;
	}
	
	public default <C extends Collection<K>> C skip(int number) {
		C collection = emptyCollection();
		for(K k : this) {
			if(number-- > 0) {
				continue;
			} else {
				collection.add(k);
			}			
		}
		return collection;
	}
		
	@SuppressWarnings("unchecked")
	public default <C extends Collection<T>, T> C emptyCollection() {
		try {
			return (C) getClass().newInstance();
		} catch (InstantiationException | IllegalAccessException exception) {
			exception.printStackTrace();
			return null;
		}
	}
}
