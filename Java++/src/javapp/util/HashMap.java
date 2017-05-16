package javapp.util;

public class HashMap<K, V> extends java.util.HashMap<K, V> implements Map<K, V> {

	private static final long serialVersionUID = -6689875951520982681L;	
	
	
	public HashMap() {
		
	}
	
	public HashMap(Collection<K> collection, Collection.Mapping<K, V> mapping) {
		for(K key : collection) put(key, mapping.operation(key));
	}
	
	@SuppressWarnings("unchecked")
	public HashMap<K, V> copy() {
		HashMap<K, V> copy = new HashMap<K, V>();
		for(java.util.Map.Entry<K, V> kv : this.entrySet()) {
			copy.put(kv.getKey(), kv.getValue());
		}
		return copy;
	}
}
