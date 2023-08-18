package com.oit.entity;

import java.math.BigInteger;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "reservation")
public class reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	   private int id;
	   private String name;
	   private String email;
	   private String phone;
	   private String date;
	   private String time;
	   private int guests;
	   private String specialRequests;
	public reservation(int id, String name, String email, String phone, String date, String time, int guests,
			String specialRequests) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.time = time;
		this.guests = guests;
		this.specialRequests = specialRequests;
	}
	public reservation() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		this.guests = guests;
	}
	public String getSpecialRequests() {
		return specialRequests;
	}
	public void setSpecialRequests(String specialRequests) {
		this.specialRequests = specialRequests;
	}
	@Override
	public String toString() {
		return "reservation [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", date=" + date
				+ ", time=" + time + ", guests=" + guests + ", specialRequests=" + specialRequests + "]";
	}
	   
	   

}
