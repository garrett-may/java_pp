package javapp.lang;

public class Result<T, E extends Throwable> {

	public enum Res {
		OK,
		ERR;
	}
	
	public final Res res;
	private final T val;
	private final E err;
	
	public final T val(){
		if(val == null){
			throw new RuntimeException();
		}
		return val;
	}
	
	public final E err(){
		if(err == null){
			throw new RuntimeException();
		}
		return err;
	}
	
	public Result(T val){
		if(val == null){
			throw new RuntimeException();
		}
		this.res = Res.OK;
		this.val = val;
		this.err = null;
	}
	
	public Result(E err){
		if(err == null){
			throw new RuntimeException();
		}
		this.res = Res.ERR;
		this.val = null;
		this.err = err;
	}	
}
