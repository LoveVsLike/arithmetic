package com.dream.design.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 基于CAS实现的单例模式
 * 
 * @author admin
 *
 */
public class SingletonAtomicReference {
	private static final AtomicReference<SingletonAtomicReference> INSTANCE = new AtomicReference<SingletonAtomicReference>();

	private SingletonAtomicReference() {

	}

	/**
	 *   * 用CAS确保线程安全   
	 */
	public static final SingletonAtomicReference getInstance() {
		for (;;) {
			SingletonAtomicReference current = INSTANCE.get();
			if (current != null) {
				return current;
			}
			
			current = new SingletonAtomicReference();
			if (INSTANCE.compareAndSet(null, current)) {
				return current;
			}
		}
	}
}
