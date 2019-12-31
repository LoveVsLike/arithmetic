package com.dream.design.singleton;

/**
 * 饿汉模式(线程安全)
 * @author admin
 *
 */
public class SingletonHungry {
	private static SingletonHungry instance = new SingletonHungry();
	
	private SingletonHungry() {}
	
	public static SingletonHungry getInstance() {
		return instance;
	}

}
