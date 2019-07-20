package creation_pattern;

/**
 * ��������ģʽ������һ����������Ľӿڣ����������ʵ�����Ǹ��ࡣ
 * 
 * @author soldierlee
 * @email bsoldier1024@gmail.com

 * 2019��7��20�� ����2:45:46
 */
public class FactoryPattern {

	public static void main(String[] args) {
		DogFactory df = new DogFactory();
		Dog d = (Dog) df.createAnimal();
		d.eat();
	}
}

interface Factory {
	public Animal createAnimal();
}


class CatFactory implements Factory {
	public Animal createAnimal() {
		return new Cat();
	}
	
}
class DogFactory implements Factory {
	public Animal createAnimal() {
		return new Dog();
	}
}

abstract class Animal {
	public abstract void eat();
}


class Cat extends Animal {

	@Override
	public void eat() {
		System.out.println("è������...");
	}
}

class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("������...");
	}
}