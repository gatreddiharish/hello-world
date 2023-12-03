package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOperations {

	
	
	
	public static void main(String[] args) {
	//	int[] l = {1,3, 4, 5};

List< Integer> l2 = Arrays.asList(1,3,4,5,67, 79);
	List<Integer> l3	= l2.stream().filter(n-> n%5==0).collect(Collectors.toList());
		System.out.println(l3);
		
		IntStream.range(1, 10).forEach(System.out::println);
		
		
		IntStream.range(1, 10).skip(5).forEach(System.out::println);
		
		
		
		
		
	}
	

}
