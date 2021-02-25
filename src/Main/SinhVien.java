package Main;

import java.io.Serializable;

public class SinhVien implements Serializable{
	//Tạo 1 bảng students gồm các thuộc tính : rollno, fullname, gender, email, address
	private String name;
	private int rollno;
	private String gender;
	private String email;
	private String address;
	
	public SinhVien() {
		
	}

	public SinhVien(String name, int rollno, String gender, String email, String address) {
		
		this.name = name;
		this.rollno = rollno;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sinh Viên: " + this.rollno + "\t" + this.name + "\t"
				 + this.gender + "\t" + this.email + "\t" + this.address;
	}

}
