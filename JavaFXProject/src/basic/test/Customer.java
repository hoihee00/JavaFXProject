package basic.test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
	private SimpleIntegerProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty phone;
	private SimpleStringProperty email;
	
	public Customer(int id, String name, String phone, String email) {
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.phone = new SimpleStringProperty(phone);
		this.email = new SimpleStringProperty(email);
	}
	
	public int getId() {
		return this.id.get();
	}
	
	public void setId(int id) {
		this.id.set(id);
	}
	
	public String getName() {
		return this.name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getPhone() {
		return this.phone.get();
	}
	
	public void setPhone(String phone) {
		this.phone.set(phone);
	}
	
	public String getEmail() {
		return this.email.get();
	}
	
	public void setEmail(String email) {
		this.email.set(email);
	}
	
}
