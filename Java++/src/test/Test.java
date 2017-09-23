package test;

import javapp.util.ArrayList;
import javapp.util.Collections;
import javapp.util.List;

public class Test {

	public static class Body {
		public int a = 3000;
		public byte[] b = {0, 2, 4, 6, 8};
		
		@Override
		public String toString() {
			String str = "a: " + a;
			str += "\nb:";
			for(byte c : b){
				str += "\n - " + c;
			}
			return str;
		}
	}
	
	public static class Person implements javapp.lang.Object {
		private final String name;
		private int age;
		private String[] strings;
		private int[] apples;
		private Body body;
		
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
			this.strings = new String[3];
			for(int i = 0; i < 3; i++) {
				strings[i] = name;
			}
			this.apples = new int[3];
			for(int i = 0; i < 3; i++) {
				apples[i] = age * 2;
			}
			this.body = new Body();
		}
		
		@Override
		public String toString() {
			String str = "Name: " + name + "\nAge: " + age;
			str += "\nStrings: ";
			for(String n : strings) {
				str += "\n - " + n;
			}
			str += "\nApples: ";
			for(int apple : apples) {
				str += "\n - " + apple;
			}
			str += "\n" + body.toString();
			return str;
		}
		
	}
	
	public static final void main(String...strings) {
		Person personA = new Person("Garrett", 21);
		Person personB = new Person("Charles", 49);
		System.out.println(personA);
		System.out.println(personB);
		personB = personA.copy();
		System.out.println(personA);
		System.out.println(personB);
		personB.age = 4000;
		personB.apples[2] = 800;
		personB.body.a = 111;
		personB.body.b[2] = -18;
		System.out.println(personA);
		System.out.println(personB);
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		for(int i : list) {
			System.out.println(i);
		}
		System.out.println("");
		for(int i : Collections.reversed(list)) {
			System.out.println(i);
		}
		System.out.println("");
		for(int i : Collections.reversed(Collections.reversed(list))) {
			System.out.println(i);
		}
		System.out.println("");
		for(int i : list) {
			System.out.println(i);
		}*/
	}
	
}
