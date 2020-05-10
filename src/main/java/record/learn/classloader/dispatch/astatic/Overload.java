package record.learn.classloader.dispatch.astatic;

import java.io.Serializable;

/**
 * 匹配优先级
 *
 * @author: mqw   
 * @date:   2018年8月13日 下午4:52:16
 */
public class Overload {

	public static void sayHello(Object obj){
		System.out.println("hello Obj");
	}
	public static void sayHello(int i){
		System.out.println("hello int");
	}
	public static void sayHello(long l){
		System.out.println("hello long");
	}
	public static void sayHello(Character c){
		System.out.println("hello Character");
	}
	/*public static void sayHello(char c){
		System.out.println("hello char");
	}*/
	public static void sayHello(char... arg){
		System.out.println("hello char...");
	}
	public static void sayHello(Serializable s){
		System.out.println("hello Serializable");
	}
	public static void main(String[] args) {
		sayHello('s');
	}
	
	
}
