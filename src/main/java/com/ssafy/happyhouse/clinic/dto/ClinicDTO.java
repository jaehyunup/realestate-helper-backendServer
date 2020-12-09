package com.ssafy.happyhouse.clinic.dto;

public class ClinicDTO {
	private String city;
	private String gu;
	private String hospital;
	private String address;
	private String weekdaytime;
	private String saterday;
	private String sunday;
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
	public String getWeekdaytime() {
		return weekdaytime;
	}
	public void setWeekdaytime(String weekdaytime) {
		this.weekdaytime = weekdaytime;
	}
	public String getSaterday() {
		return saterday;
	}
	public void setSaterday(String saterday) {
		this.saterday = saterday;
	}
	public String getSunday() {
		return sunday;
	}
	public void setSunday(String sunday) {
		this.sunday = sunday;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "ClinicDTO [city=" + city + ", gu=" + gu + ", hospital=" + hospital + ", address=" + address
				+ ", weekdaytime=" + weekdaytime + ", saterday=" + saterday + ", sunday=" + sunday + ", phonenumber="
				+ phonenumber + "]";
	}
	public ClinicDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClinicDTO(String city, String gu, String hospital, String address, String weekdaytime, String saterday,
			String sunday, String phonenumber) {
		super();
		this.city = city;
		this.gu = gu;
		this.hospital = hospital;
		this.address = address;
		this.weekdaytime = weekdaytime;
		this.saterday = saterday;
		this.sunday = sunday;
		this.phonenumber = phonenumber;
	}
	
	
	
}
