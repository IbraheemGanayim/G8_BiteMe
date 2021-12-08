package logic;

import java.io.Serializable;

public class Order implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public String Resturant;
public String OrderNumber;
public String OrderTime;
public String PhoneNumber;
public String TypeofOrder;
public String OrderAdress;
public Order(String resturant, String orderNumber, String orderTime, String phoneNumber, String typeofOrder,
		String orderAdress) {
	super();
	Resturant = resturant;
	OrderNumber = orderNumber;
	OrderTime = orderTime;
	PhoneNumber = phoneNumber;
	TypeofOrder = typeofOrder;
	OrderAdress = orderAdress;
}
public String getResturant() {
	return Resturant;
}
public void setResturant(String resturant) {
	Resturant = resturant;
}
public String getOrderNumber() {
	return OrderNumber;
}
public void setOrderNumber(String orderNumber) {
	OrderNumber = orderNumber;
}
public String getOrderTime() {
	return OrderTime;
}
public void setOrderTime(String orderTime) {
	OrderTime = orderTime;
}
public String getPhoneNumber() {
	return PhoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	PhoneNumber = phoneNumber;
}
public String getTypeofOrder() {
	return TypeofOrder;
}
public void setTypeofOrder(String typeofOrder) {
	TypeofOrder = typeofOrder;
}
public String getOrderAdress() {
	return OrderAdress;
}
public void setOrderAdress(String orderAdress) {
	OrderAdress = orderAdress;
}



}