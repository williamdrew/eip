/**
 * 
 */
package com.adargasystems.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author William
 *
 */
public class PassByReference {

	
	public static class Dog{
		private List<Dog> puppies = new ArrayList<Dog>();
		
		private String name;
		public void setName(final String newValue){
			name = newValue;
		}
		public String getName(){
			return name;
		}
		
		public List<Dog> getPuppies(){
			return puppies;
		}

		public void show() {
			StringBuilder sb = new StringBuilder();
			sb.append(name);
			for(Dog p : puppies){
				sb.append("\nPuppy = " + p.getName());
			}
			System.out.println(sb.toString());
		}

	}
	
	public static void foo(Dog dog){
		
		System.out.println("Start foo()");
		
		System.out.println("Name = " + dog.getName());
		
		dog = new Dog();
		
		dog.setName("Spot");
		
		System.out.println("Name = " + dog.getName());		
		
		System.out.println("End foo()");
	}
	
	public static void bar(Dog dog){
//		dog = new Dog();
	//	dog.setName("Reference");
		Dog kdog = new Dog();
		kdog.setName("Killer");
		dog.getPuppies().add(kdog);
	}
	
	public static void main(String[] args){
		
		Dog dog = new Dog();
		
		dog.setName("Fido");
		
		System.out.println("Name = " + dog.getName());
		
		foo(dog);
		
		
		System.out.println("Name = " + dog.getName());
		
		Dog nd = new Dog();
		nd.setName("Pup");
		dog.getPuppies().add(nd);

		bar(dog);
		
		dog.show();
		
	}
}
