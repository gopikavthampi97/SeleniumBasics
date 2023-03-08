package seleniumPrograms;

public class EmployeeSalary {
	
	static String empname;
	static int empsalary;
	

	
	public void set(String name,int salary )
	{
		empname=name;
		empsalary=salary;
		
	}
	
	public void get()
	{
		System.out.println(empname);
		System.out.println(empsalary);
		
	}
	public static void main(String args[])
	{
		EmployeeSalary obj=new EmployeeSalary();
	obj.set("Ramesh", 12000);
	obj.get();
		
	}
	
	}

