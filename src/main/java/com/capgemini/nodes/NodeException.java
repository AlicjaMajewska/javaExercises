package com.capgemini.nodes;

/*
 public class MyException extends Exception {}

 public class Foo {
 public bar() throws MyException {
 throw new MyException("try again please");
 }
 }*/
public class NodeException extends Exception {

	protected String message = new String();

	public NodeException(String message) {
		this.message = message;
	}

	public String getMessage()
	{
		return message;
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2650446796317724262L;

}
