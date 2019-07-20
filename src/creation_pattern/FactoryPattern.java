package creation_pattern;

/**
 * 工厂方法模式：定义一个创建对象的接口，让子类决定实例化那个类。
 * 
 * @author soldierlee
 * @email bsoldier1024@gmail.com

 * 2019年7月20日 上午2:45:46
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
		System.out.println("猫吃老鼠...");
	}
}

class Dog extends Animal {
	@Override
	public void eat() {
		System.out.println("狗吃肉...");
	}
}