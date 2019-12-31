package com.dream.design.singleton;

/**
 * 懒汉模式
 * 
 * @author admin
 *
 */
public class SingletonLazy {
	private static SingletonLazy instance;

	private SingletonLazy() {

	}

	public static synchronized SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}

}
