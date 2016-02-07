package com.adargasystems.misc;

import java.util.concurrent.ThreadLocalRandom;

public class StaticProto {

	public final static InnerStaticProto isp = new InnerStaticProto();

	public static class InnerStaticProto {
		private final int i;

		private final String name = "Inner Static Proto I";
//		private final String name = null;
		
		private InnerStaticProto() {
			i = ThreadLocalRandom.current().nextInt();
		}
		
		public int getI(){
			return i;
		}

		public String getName() throws MyAmazingException{
			if(null == name){
				throw new MyAmazingException("Name is null", new NullPointerException());
			}
			return name;
		}

		@Override
		public String toString() {
			return "name = " + name + "; i = " + i;
		}
	}

}
