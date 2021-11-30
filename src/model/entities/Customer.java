package model.entities;

public class Customer {

	private String name;
	private String profession;
	private int broncoID;
	private String major;
	private String minor;
	private String graduationDate;
	private int phone;
	private String dateOfBirth;
	private String address;
	
	public Customer(String name, String profession, int broncoID, String major, String minor, String graduationDate, String dateOfBirth, String address, int phone) {
		this.name = name;
		this.profession = profession;
		this.broncoID = broncoID;
		this.major = major;
		this.minor = minor;
		this.graduationDate = graduationDate;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getBroncoID() {
		return broncoID;
	}

	public void setBroncoID(int broncoID) {
		this.broncoID = broncoID;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}
	
	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getGraduationDate() {
		return graduationDate;
	}

	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfession() {
		return profession;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public boolean discount() {
		return getProfession() == "Professor" || getProfession() == "professor";
	}
	
	
}
