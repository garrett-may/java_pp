package javapp.util;

public interface List<T> extends java.util.List<T>, Collection<T>, javapp.lang.Iterable<T> {
		
	@Override
	public default java.util.Iterator<T> iterator() {
		return nextIterator();
	}
	
	@Override
	public default javapp.util.Iterator<T> nextIterator() {
		return new ListNextIterator<T>(this);
	}
	
	@Override
	public default javapp.util.Iterator<T> prevIterator() {
		return new ListPrevIterator<T>(this);
	}
	
	public class ListNextIterator<T> implements javapp.util.Iterator<T> {

		private List<T> list;
		
		private int nextIndex;
		
		public ListNextIterator(List<T> list) {
			this.list = list;
			this.nextIndex = 0;
		}

		@Override
		public boolean hasNext() {
			return nextIndex < list.size();
		}

		@Override
		public T next() {
			T elem = list.get(nextIndex);
			nextIndex += 1;
			return elem;
		}
	}	
	
	public class ListPrevIterator<T> implements javapp.util.Iterator<T> {

		private List<T> list;
		
		private int prevIndex;
		
		public ListPrevIterator(List<T> list) {
			this.list = list;
			this.prevIndex = list.size() - 1;
		}

		@Override
		public boolean hasNext() {
			return prevIndex >= 0;
		}

		@Override
		public T next() {
			T elem = list.get(prevIndex);
			prevIndex -= 1;
			return elem;
		}
	}	
}
