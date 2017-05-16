package javapp.util;

public class LinkedHashMap<K, V> extends java.util.LinkedHashMap<K, V> {

	private static final long serialVersionUID = -1029766231683336827L;

	public LinkedHashMap() {
		
	}
	
	public LinkedHashMap(Collection<K> collection, Collection.Mapping<K, V> mapping) {
		for(K key : collection) put(key, mapping.operation(key));
	}
	
	public LinkedHashMap<K, V> copy() {
		LinkedHashMap<K, V> copy = new LinkedHashMap<K, V>();
		for(java.util.Map.Entry<K, V> kv : this.entrySet()) {
			copy.put(kv.getKey(), kv.getValue());
		}
		return copy;
	}
	
}
