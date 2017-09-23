package javapp.lang;

public class Optional<T> {

	private final T val;
	
	public final T unwrap(){
		if(val == null){
			throw new RuntimeException();
		}
		return val;
	}
	
	public Optional(T val){
		this.val = val;
	}
	
	public boolean isPresent(){
		return val != null;
	}
	
	public boolean isAbsent(){
		return val == null;
	}
}
