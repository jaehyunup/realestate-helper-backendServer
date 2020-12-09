package com.ssafy.happyhouse.safehospital.dto;

public class SafehospitalDTO {
	private String city;
	private String gu;
	private String hospital;
	private String address;
	private String type;
	private String phonenumber;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGu() {
		return gu;
	}
	public void setGu(String gu) {
		this.gu = gu;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "safehospitalDTO [city=" + city + ", gu=" + gu + ", hospital=" + hospital + ", address=" + address
				+ ", type=" + type + ", phonenumber=" + phonenumber + "]";
	}
	public SafehospitalDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SafehospitalDTO(String city, String gu, String hospital, String address, String type, String phonenumber) {
		super();
		this.city = city;
		this.gu = gu;
		this.hospital = hospital;
		this.address = address;
		this.type = type;
		this.phonenumber = phonenumber;
	}
	
	
	
}
