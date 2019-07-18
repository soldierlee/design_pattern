package creation_pattern;
/**
 * 
 * @author soldierlee
 * @2019-7-18 下午3:33:48
 * 单例模式，它的定义就是确保某一个类只有一个实例，并且提供一个全局访问点。
 * 特点：1、只有一个实例。 2、自我实例化。 3、提供全局访问点。
 * 
 */
public class SingletonPattern {

	public static void main(String[] args) {
		//饿汉式
		Singleton1 s1 =  Singleton1.getInstance();
		Singleton1 s2 =  Singleton1.getInstance();
		System.out.println(s1 == s2);  //true

		//懒汉式
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		System.out.println(s3 == s3);  //true
		
	}
}




/*
 * 饿汉式
 * 在程序启动或单件模式类被加载的时候，单件模式实例就已经被创建。
 */
class Singleton1 {
	//1.私有构造方法, 其他不能访问该构造方法
	private Singleton1(){}
	
	//2.自己创建本类对象, 成员变量私有不能通过类名.方法调用
	private static Singleton1 s1 = new Singleton1();
	
	//3.对外公开访问方法
	public static Singleton1 getInstance() {
		return s1;
	}
}

/*
 * 懒汉式(单例的延迟加载模式), 线程不安全
 * 当程序第一次访问单件模式实例时才进行创建。
 */
class Singleton {
	
	//私有构造方法，防止实例化
	private Singleton() {}
	
	private static Singleton s;
	
	public static Singleton getInstance() {
		if (s == null) {
			s = new Singleton();
		}
		return s;
	}
}

/*
 * 懒汉式  加同步锁
 */
class Singleton3 {
	
	private Singleton3() {}
	
	private static Singleton3 s;
		
	//同步函数
	public static synchronized Singleton3 getInstance() {
		if (s == null) {
			s = new Singleton3();
		}
		return s;
	}
	//同步代码快   加锁
	public static Singleton3 getInStanceBlock(){
	 if(s==null)
	     synchronized (Singleton3.class) {
	         if(s==null)
	             s = new Singleton3();
	     }
	 return s;
	 
	}
}