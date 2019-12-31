package com.dream.design.singleton;

/**
 * 单例
 * @author admin
 *
 */
public class SingletonThreadLocal {
	private static ThreadLocal<SingletonThreadLocal> instance = new ThreadLocal<SingletonThreadLocal>() {
		@Override
		protected SingletonThreadLocal initialValue() {
			return new SingletonThreadLocal();
		}
	};
	
	private SingletonThreadLocal() {
		
	}
	
	private static SingletonThreadLocal getInstance() {
		return instance.get();
	}

}
