package record.learn.design.visiter;

public class Main {


	public static void main(String[] args) {
		
		PartStructure ps = new PartStructure();
		
		VisiterA va = new VisiterA();
		VisiterB vb = new VisiterB();
		VisitorManager vm = new VisitorManager();
		
		ps.accept(va);
		ps.accept(vb);
		ps.accept(vm);
	}
	
}
