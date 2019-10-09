package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;
@Component
@Entity

@Table(name="watches")


public class Watch {
	@Id
	@GenericGenerator(name="wa_seq",strategy="increment")
	@GeneratedValue(generator="wa_seq")
	private int id;
	@Column(length=20)
	private String brand;
	@Column(length=20)
	private String Catogry;
	private int price;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCatogry() {
		return Catogry;
	}
	public void setCatogry(String catogry) {
		Catogry = catogry;
	}
}
