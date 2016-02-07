package com.adargasystems.strategy;

/**
 *
 */
public class StrategyPatternDemo {

	/**
	 * 
	 */
	public StrategyPatternDemo() {

		ProcessRequestStrategy procLoginReqStrategy = new NormalLoginRequestStrategy();

		RequestHandler rh = new RequestHandler(procLoginReqStrategy);

		rh.handle();

		ProcessRequestStrategy revisedLoginReqStrategy = new RevisedLoginRequestStrategy();

		rh = new RequestHandler(revisedLoginReqStrategy);

		rh.handle();
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		new StrategyPatternDemo();
	}
}
