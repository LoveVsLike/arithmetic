package com.dream.design.singleton;

/**
 * 双重检查
 *
 * @author admin
 */
public class SingletonDouCheck {
	private volatile static SingletonDouCheck instance;

	private SingletonDouCheck() {
		System.out.println("Singleton has loaded");
	}

	public static SingletonDouCheck getInstance() {
		if (instance == null) {
			synchronized (SingletonDouCheck.class) {
				if (instance == null) {
					instance = new SingletonDouCheck();
				}
			}
		}

		return instance;
	}
}
