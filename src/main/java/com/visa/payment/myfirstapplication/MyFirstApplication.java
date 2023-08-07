package com.visa.payment.myfirstapplication;

import com.visa.payment.myfirstapplication.dsa.medium.ThreeNumberSum_1;

//@SpringBootApplication
public class MyFirstApplication {

	public static void main(String[] args) {
		//SpringApplication.run(MyFirstApplication.class, args);

		int[] input = new int[] {-1,0,1,2,-1,-4};
		ThreeNumberSum_1.threeSum(input);
	}

}
