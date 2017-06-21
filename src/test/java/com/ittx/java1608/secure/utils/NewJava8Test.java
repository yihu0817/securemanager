package com.ittx.java1608.secure.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NewJava8Test {

	@Test
	public void test() {
		//Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );
		List<String> lists = new ArrayList<String>();
		lists.add("a");
		lists.add("b");
		lists.add("c");
		
//		for(String s : lists){
//			System.out.println(s);
//		}
		
		lists.forEach(e ->System.out.println(e));
	}

}
