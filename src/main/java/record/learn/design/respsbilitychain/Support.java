package record.learn.design.respsbilitychain;

public abstract class Support {

	private String name;
	private Support next;
	public Support(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Support getNext() {
		return next;
	}
	public Support setNext(Support next) {
		this.next = next;
		return this;
	}
	public final void support(Trouble trouble){
		if(resolve(trouble)){
			done(trouble);
		}else if(next!=null){
			next.support(trouble);
		}else{
			fail(trouble);
		}
	}
	
	protected abstract boolean resolve(Trouble trouble);	//交给子类去处理
	
	protected void done(Trouble trouble){
		System.out.println(trouble + "done by "+this);
	}
	protected void fail(Trouble trouble){
		System.out.println(trouble + "fail by "+this);
	}
	
	@Override
	public String toString() {
		return " [ " + name + " ] ";
	}
}
