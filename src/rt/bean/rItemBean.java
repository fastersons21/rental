package rt.bean;

import java.io.Serializable;

public class rItemBean implements Serializable{
	private int id;
	private String name;
	private int stock;
	private int price;

	public rItemBean(int id,String name,int price, int stock) {
		this.id= id;
		this.name= name;
		this.stock=stock;
		this.price=price;
	}
	public rItemBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
