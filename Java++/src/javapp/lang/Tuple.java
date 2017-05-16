package javapp.lang;

public class Tuple<First, Second> implements Object {

	public First first;
	public Second second;
	
	public Tuple(First first, Second second) {
		this.first = first;
		this.second = second;
	}	
	
	public String toString() {
		return first.toString() + "\n" + second.toString();
	}
}
