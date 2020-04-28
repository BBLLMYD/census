package record.learn.design.single;

public class Single {

	private static Single single;
	private Single(){}
	
	public static Single getIns(){
		if(single != null){
			synchronized(Single.class){//这段代码正常只走一次, 避免多次同步判断. 只对需要同步的代码块同步
				if(single != null){
					single = new Single();
				}
			}
		}
		return single;
	}
	
	public static void main(String[] args) {
		SingleObj singleIns1 = Single2.SINGLE_INST.getSingleIns();
		SingleObj singleIns2 = Single2.SINGLE_INST.getSingleIns();
		System.err.println(singleIns1==singleIns2);
	}

	
}

enum Single2{
	SINGLE_INST;
	private SingleObj singleObj;
	private Single2(){
		singleObj = new SingleObj();
	}
	public SingleObj getSingleIns(){
		return singleObj;
	}
}
class SingleObj{}