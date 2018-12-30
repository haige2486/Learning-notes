/**
 * 此类为单向链表，用于自建栈功能
 * @author lustg
 *
 * @param <T>
 */
public class ChainForm<T> {
	static class Node<U> {
		private U item;//当前元素
		private Node<U> next;//储存前一链表结构
		Node(){
			this.item = null;
			this.next = null;
		}
		Node(U item, Node<U> next) {
			this.item = item;
			this.next = next;
		}
		boolean end() {
			if(this.item == null && this.next == null)  return true;
			return false;
		}
		@Override
		public String toString() {
			return item + "<-" + next;
		}
	}
	
	Node<T> top = new Node<T>();
	public T pop() {
		T result = top.item;
		if(!top.end())
			top = top.next;
		return result;
	}
	public void push(T item) {
		top = new Node<>(item, top);
	}
	public Node<T> get() {
		return top;
	}
	public static void main(String[] args) {
		ChainForm<String> c = new ChainForm<>();
		for(String s : "hello word test".split(" "))
			c.push(s);
		System.out.println(c.get());
		while(c.pop() != null) {
			System.out.println(c.get());
		}
	}
}
/**
 * 此类为双向链表，用于自建栈功能
 * @author lustg
 *
 * @param <T>
 */
class ChainForm2<T> {
	static class Node<U> {
		private U item;//当前元素
		private Node<U> before;//储存前一链表结构
		private Node<U> after;//储存后续链表结构，由后值赋值
		Node(){
			this.item = null;
			this.before = null;
		}
		Node(U item, Node<U> before) {
			this.item = item;
			this.before = before;
		}
		boolean top() {
			if(this.item == null && this.before == null)  return true;
			return false;
		}
		boolean end() {
			if(this.after == null) return true;
			return false;
		}
		@Override
		public String toString() {
			return before + "->"+ item;
		}
	}
	
	Node<T> top = new Node<T>();
	public void push(T item) {
		Node<T> temp = new Node<>(item, top);//创建当前项
		top.after = temp;//前一项赋值
		top = temp;//移动到当前项
	}
	public T shift() {
		T result = top.item;
		if(!top.top()) {
			top = top.before;
		}
		return result;
	}
	public Node<T> get() {
		return top;
	}
	public static void main(String[] args) {
		ChainForm2<String> c = new ChainForm2<>();
		for(String s : "hello word test A B C".split(" ")) {			
			c.push(s);
			System.out.println(c.get());
		}
		while(c.shift() != null) {
			System.out.println(c.get());
		}
	}
}