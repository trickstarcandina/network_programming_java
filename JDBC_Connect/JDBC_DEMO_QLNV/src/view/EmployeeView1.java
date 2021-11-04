package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.Employee;

public class EmployeeView1 {
	Scanner scan;
	public EmployeeView1() {
		scan = new Scanner(System.in);
	}
	public void showMessage(String smg) {
		System.out.println("-----------");
		System.out.println(smg);
		System.out.println("-----------");
	}

	public int menu(){
		System.out.println("1. Hien thi tat ca employee");
		System.out.println("2. Hien thi employee theo ten");
		System.out.println("3. Them employee");
		System.out.println("4. Sua employee");
		int choice = 0;
		choice = scan.nextInt();
		return choice;
	}
	public Employee input(int choice){
		switch (choice) {
		case 2:
			BufferedReader scan2 = new BufferedReader(new InputStreamReader(System.in));
			Employee e= new Employee();
			System.out.println("Nhap ten can tim: ");
			String str;
			try {
				str = scan2.readLine();
				e.setEmpName(str);
				return e;
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		case 3:
			
			try {
				BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
				
				Employee insertE = new Employee();
				System.out.println("Them moi employee");
				
				System.out.print("EmpID: "); 
				insertE.setEmpId(Integer.parseInt(scan.readLine()));
				
				System.out.println("EmpName: "); 
				insertE.setEmpName(scan.readLine());
				
				System.out.println("EmpNo:");
				insertE.setEmpNo(scan.readLine());
				
				System.out.println("HireDate (dd/mm/yyyy)");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
				insertE.setHireDate(formatter.parse(scan.readLine()));
				
				System.out.println("Job");
				insertE.setJob(scan.readLine());
				
				System.out.println("Salary");
				insertE.setSalary(Float.parseFloat(scan.readLine()));
				
				System.out.println("Dept_Id");
				insertE.setDeptId(Integer.parseInt(scan.readLine()));
				
				System.out.println("Mng_id");
				insertE.setMngId(BigInteger.valueOf((Long.parseLong(scan.readLine()))));
				return insertE;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
				
			}
			
		case 4:
			try {
				BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
				
				Employee insertE = new Employee();
				System.out.println("Sua employee");
				
				System.out.print("EmpID: "); 
				insertE.setEmpId(Integer.parseInt(scan.readLine()));
				
				System.out.println("EmpName: "); 
				insertE.setEmpName(scan.readLine());
				
				System.out.println("EmpNo:");
				insertE.setEmpNo(scan.readLine());
				
				System.out.println("HireDate (dd/mm/yyyy)");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
				insertE.setHireDate(formatter.parse(scan.readLine()));
				
				System.out.println("Job");
				insertE.setJob(scan.readLine());
				
				System.out.println("Salary");
				insertE.setSalary(Float.parseFloat(scan.readLine()));
				
				System.out.println("Dept_Id");
				insertE.setDeptId(Integer.parseInt(scan.readLine()));
				
				System.out.println("Mng_id");
				insertE.setMngId(BigInteger.valueOf((Long.parseLong(scan.readLine()))));
				return insertE;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
				
			}
		default:
			break;
		}
		return null;
	}
	public void exit(){
		this.scan.close();
	}
	
}
