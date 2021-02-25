package Main;


import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choose;
		Manager man = new Manager(); 
		
		do {
			ManagerMenu();
			System.out.println("Nhập lựa chọn của bạn: ");
			
			try {
				choose = sc.nextInt();
			} catch (Exception e) {
				choose = 9;
			} 
			
			sc.nextLine();
			switch (choose) {
			case 1: {

				for (int i = 0; i < 6; i++) {
					SinhVien sv = new SinhVien("d",i,"Nam","S","HN");
					man.addStuden(sv);
				}
				
				
				System.out.println("Acess!");
				
				break;
			}
			
			case 2: {
				man.sortById();
				System.out.println("Thông tin sinh viên (xếp theo thứ tự tăng dần id):");
				man.showInfo();
			}
				break;
				
			case 3: {
				System.out.println("Nhập Id sinh viên cần sửa");
				int id = sc.nextInt();
				
				man.searchStudenById(id);
				man.editStuden(id);
			
				break;
			}
			
			case 4: {
				
				System.out.println("Nhập Id sinh viên cần tìm: ");
				int id = sc.nextInt();
				
				System.out.println("Thông tin sinh viên có id = " + id);
				man.searchStudenById(id);
				
			}
				break;
				
			case 5: {
				
				System.out.println("Nhập tên sinh viên cần tìm: ");
				String name = sc.nextLine();
				
				System.out.println("Thông tin sinh viên " + name);
				man.searchStudenByName(name);
				
			}
				break;
				
			case 6: {
				
				System.out.println("Nhập Id sinh viên cần xóa: ");
				int id = sc.nextInt();
				
				man.deleteStuden(id);
				man.showInfo();
						
				break;
			}
				
			case 7: {
				
				man.saveStuden();
				System.out.println("Acess!");
				
			}
				break;
				
			case 8: {
				
				man.openFileStudens();
				System.out.println("Acess!");
				
			}
				break;
				
			default:
				
			}
			
		}while(choose != 9);
		
		
		
		System.out.println("Exit!");
		
	}
	
	public static void ManagerMenu() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("1/ Nhập thông tin sinh viên."
				+ "\n2/ Hiển thị thông tin sinh viên."
				+ "\n3/ Sửa thông tin sinh viên theo Id."
				+ "\n4/ Tìm kiếm thông tin sinh viên theo Id."
				+ "\n5/ Tìm kiếm thông tin sinh viên theo Name."
				+ "\n6/ Xóa thông tin sinh viên theo Id."
				+ "\n7/ Save file.dat(chỉ được mở bằng trình biên dịch)."
				+ "\n8/ Open file.dat."
				+ "\n9/ Exit.");
	}
	
	public static void inputInfo(SinhVien sv) {
		System.out.println("Nhập tên sinh viên: "); sv.setName(sc.nextLine());
		System.out.println("Nhập địa chỉ: "); sv.setAddress(sc.nextLine());
		System.out.println("Nhập giới tính: "); sv.setGender(sc.nextLine());
		System.out.println("Nhập email: "); sv.setEmail(sc.nextLine());
	}

}
