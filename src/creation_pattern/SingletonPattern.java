package creation_pattern;
/**
 * 
 * @author soldierlee
 * @2019-7-18 ����3:33:48
 * ����ģʽ�����Ķ������ȷ��ĳһ����ֻ��һ��ʵ���������ṩһ��ȫ�ַ��ʵ㡣
 * �ص㣺1��ֻ��һ��ʵ���� 2������ʵ������ 3���ṩȫ�ַ��ʵ㡣
 * 
 */
public class SingletonPattern {

	public static void main(String[] args) {
		//����ʽ
		Singleton1 s1 =  Singleton1.getInstance();
		Singleton1 s2 =  Singleton1.getInstance();
		System.out.println(s1 == s2);  //true

		//����ʽ
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		System.out.println(s3 == s3);  //true
		
	}
}




/*
 * ����ʽ
 * �ڳ��������򵥼�ģʽ�౻���ص�ʱ�򣬵���ģʽʵ�����Ѿ���������
 */
class Singleton1 {
	//1.˽�й��췽��, �������ܷ��ʸù��췽��
	private Singleton1(){}
	
	//2.�Լ������������, ��Ա����˽�в���ͨ������.��������
	private static Singleton1 s1 = new Singleton1();
	
	//3.���⹫�����ʷ���
	public static Singleton1 getInstance() {
		return s1;
	}
}

/*
 * ����ʽ(�������ӳټ���ģʽ), �̲߳���ȫ
 * �������һ�η��ʵ���ģʽʵ��ʱ�Ž��д�����
 */
class Singleton {
	
	//˽�й��췽������ֹʵ����
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
 * ����ʽ  ��ͬ����
 */
class Singleton3 {
	
	private Singleton3() {}
	
	private static Singleton3 s;
		
	//ͬ������
	public static synchronized Singleton3 getInstance() {
		if (s == null) {
			s = new Singleton3();
		}
		return s;
	}
	//ͬ�������   ����
	public static Singleton3 getInStanceBlock(){
	 if(s==null)
	     synchronized (Singleton3.class) {
	         if(s==null)
	             s = new Singleton3();
	     }
	 return s;
	 
	}
}