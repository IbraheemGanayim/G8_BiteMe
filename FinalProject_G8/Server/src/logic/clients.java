package logic;

public class clients {
private String name,IP,Status;

public clients(String name, String iP, String status) {
	
	this.name = name;
	IP = iP;
	Status = status;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getIP() {
	return IP;
}

public void setIP(String iP) {
	IP = iP;
}

public String getStatus() {
	return Status;
}

public void setStatus(String status) {
	Status = status;
}

@Override
public String toString() {
	return "clients [name=" + name + ", IP=" + IP + ", Status=" + Status + "]";
}

}
