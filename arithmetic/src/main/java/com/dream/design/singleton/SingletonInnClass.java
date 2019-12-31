package com.dream.design.singleton;

/**
 * 类部类模式
 * @author admin
 *
 */
public class SingletonInnClass {
	
	private static class SingletonHolder{
		private static SingletonInnClass instance=new SingletonInnClass();
	}
	
    private SingletonInnClass(){
    	System.out.println("Singleton has loaded");
    }
	
    public static SingletonInnClass getInstance(){
		return SingletonHolder.instance;
	}
}
