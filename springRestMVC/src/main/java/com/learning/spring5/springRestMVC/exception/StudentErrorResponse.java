package com.learning.spring5.springRestMVC.exception;

//default constructor and setter and getters are needed by jackson
public class StudentErrorResponse {

	private String errorDesc;
	private long timeStamp;
	//default constructo is used by jackson
	public StudentErrorResponse() {
	}
	public StudentErrorResponse(String errorDesc, long timeStamp) {
		this.errorDesc = errorDesc;
		this.timeStamp = timeStamp;
	}
	public String getErrorDesc() {
		return errorDesc;
	}
	//since from bean to json need getters only commenting out setters
	//will initialize from constructor for learning purpose
	//public void setErrorDesc(String errorDesc) {
		//this.errorDesc = errorDesc;
	//}
	public long getTimeStamp() {
		return timeStamp;
	}
//	public void setTimeStamp(long timeStamp) {
	//	this.timeStamp = timeStamp;
	//}
}
