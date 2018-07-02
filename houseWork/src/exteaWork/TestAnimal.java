package exteaWork;

import java.util.*;

public class TestAnimal {
	public static GivearandonAnimal gen = new GivearandonAnimal();
	public static void main(String[] args){
		Random ran = new Random();
		Animal[] mammal = new Mammal[ran.nextInt(3) + 1];
		
		for(int i = 0; i < mammal.length;i++){
			mammal[i] = (Mammal)(gen.next());
			((Mammal) mammal[i]).moving(mammal[i], ran.nextInt(3) + 1);
		}
	}
}

interface Moverable{
	int WALK = 1;
	int RUN = 2;
	int JUNP = 3;
	
	void moving(Animal animal, int move);
}

class Animal{
	private String name;
	Animal(String name){
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}	
}

class Mammal extends Animal implements Moverable{
	Mammal(String name){
		super(name);
	}
		
	public void moving(Animal animal, int move){
		switch(move){
			case Moverable.WALK: System.out.println(animal.getName() + "*****Walk");
				break;
			case Moverable.RUN: System.out.println(animal.getName() + "*****RUN");
				break;
			case Moverable.JUNP: System.out.println(animal.getName() + "*****JUMP");
				break;
		}
	}
	
	
}

class Dog extends Mammal{
	public Dog(String name){
		super(name);
	}
	
}

class Cat extends Mammal{
	public Cat(String name){
		super(name);
	}
	
}

class Hourse extends Mammal{
	public Hourse(String name){
		super(name);
	}
}

class GivearandonAnimal{
	Random ran = new Random();
	
	public Mammal next(){
		switch(ran.nextInt(3) + 1){
			default:;
			case 1:return new Dog("Dog");
			case 2:return new Cat("Cat");
			case 3:return new Hourse("Hourse");
		}
	}
}

