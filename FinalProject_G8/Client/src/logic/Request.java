package logic;

import java.io.Serializable;

public class Request implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String request ;
private Object obj;
public Request(String request, Object obj) {
	this.request = request;
	this.obj = obj;
}
public String getRequest() {
	return request;
}
public void setRequest(String request) {
	this.request = request;
}
public Object getObj() {
	return obj;
}
public void setObj(Object obj) {
	this.obj = obj;
}

}