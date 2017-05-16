package javapp.lang;

public final class P<Obj> implements Object {

	public Obj $;
	
	public P(){
		this.$ = null;
	}
	
	public P(Obj obj){
		this.$ = obj;
	}
	
	public String toString() {
		return $.toString();
	}
}
