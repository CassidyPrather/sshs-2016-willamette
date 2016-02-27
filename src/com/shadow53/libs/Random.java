package com.shadow53.libs;

public class Random {
	public static int Int(int top){
		return (int)(Math.random() * top)+1;
	}
	
	public static int RollDie(){
		return Int(6);
	}
}
