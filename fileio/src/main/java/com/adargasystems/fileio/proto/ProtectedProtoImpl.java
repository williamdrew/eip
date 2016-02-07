package com.adargasystems.fileio.proto;

public class ProtectedProtoImpl implements IProtectedProto {
	
	protected String privateAccess = "private access string";
	protected String testing = "checking protected accessibility";

	public void foo() {
		System.out.println("In foo");
	}

}
