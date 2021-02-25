package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Manager implements Comparator<SinhVien>{
	
	Scanner sc = new Scanner(System.in);
	
	List<SinhVien> sv;
	
	public Manager() {
		sv = new ArrayList<SinhVien>();
	}
	
	public void addStuden(SinhVien bot) {
		
		sv.add(bot);
	}
	
	public void edit(SinhVien bot) {
		System.out.println("Nhập tên sinh viên: "); bot.setName(sc.nextLine());
		System.out.println("Nhập địa chỉ: "); bot.setAddress(sc.nextLine());
		System.out.println("Nhập giới tính: "); bot.setGender(sc.nextLine());
		System.out.println("Nhập email: "); bot.setEmail(sc.nextLine());
		
	}
	
	public void editStuden(int id) {
		this.sv.stream().filter(o -> o.getRollno() == id).forEach(o -> edit(o));
	}
	
	public void deleteStuden(int id){
		for (int i = 0; i < sv.size(); i++) {
			if(sv.get(i).getRollno() == id)
				sv.remove(i);
		}
	}

	@Override
	public int compare(SinhVien o1, SinhVien o2) {
		// TODO Auto-generated method stub
		if(o1.getRollno() <= o2.getRollno())
			return 1;
		else
			return -1;
	}
	
	public void showInfo() {
		this.sv.stream().forEach(o -> System.out.println(o.toString()));
	}
	
	public void searchStudenById(int id) {
		this.sv.stream().filter(o -> o.getRollno() == id).forEach(o -> System.out.println(o));
	}
	
	public void searchStudenByName(String name) {
		this.sv.stream().filter(o -> o.getName().equals(name)).findAny().
		ifPresentOrElse(o -> System.out.println(o), null);
	}
	
	public void saveStuden() {
		FileOutputStream fio = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fio = new FileOutputStream("Students.dat");
			oos = new ObjectOutputStream(fio);
			oos.writeObject(sv);
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(fio != null)
					fio.close();
				if(oos != null)
					oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}	
		}
	}
	
	public void openFileStudens() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("Students.dat");
			ois = new ObjectInputStream(fis);
			this.sv =  (List<SinhVien>) ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if(fis != null)
					fis.close();
				if(ois != null)
					ois.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public int sortById() {
		Collections.sort(this.sv, new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				if(o1.getRollno() > o2.getRollno())
					return 1;
				return -1;
			}
		});
		return 1;
	}
	

}