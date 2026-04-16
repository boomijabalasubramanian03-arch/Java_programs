import java.util.*;
class Salary
{
    String id;
    String name;
    int age;
    double basicPay;
    String gender;
    String city;
    String dept;

    public Salary(String eid,String ename,int eage,double bp,String egen,String ecity,String edept)
    {
        this.id = eid;
        this.name = ename;
        this.age = eage;
        this.basicPay = bp;
        this.gender = egen;
        this.city = ecity;
        this.dept = edept;
    }
    public void display()
    {
        System.out.println("THE ID OF THE EMPLOYEE IS: "+this.id);
        System.out.println("THE NAME OF THE EMPLOYEE IS: "+this.name);
        System.out.println("THE AGE OF THE EMPLOYEE IS: "+this.age);
        System.out.println("THE BASIC PAY OF THE EMPLOYEE IS: "+this.basicPay);
        System.out.println("THE GENDER OF THE EMPLOYEE IS: "+this.gender);
        System.out.println("THE DEPARTMENT OF THE EMPLOYEE IS: "+this.dept);
        System.out.println("THE CITY OF THE EMPLOYEE IS: "+this.city);
        System.out.println("THE NET SALARY OF THE EMPLOYEE IS: "+calc_NetSal());
    }
    public double calc_GrossSal()
    {
        double hra = this.basicPay*0.1;
        double da = this.basicPay*0.3;
        return this.basicPay+hra+da;
    }
    public double calc_IncomeTax()
    {
        if (calc_GrossSal()>100000)
        {
            return calc_GrossSal()*0.1;
        }
        else
        {
            return 0;
        }
    }
    public double calc_NetSal()
    {
        return calc_GrossSal()-calc_IncomeTax();
    }
}
public class Employee
{
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE ID:");
        String eid = sc.next();
        System.out.println("ENTER THE NAME:");
        String ename = sc.next();
        System.out.println("ENTER THE AGE:");
        int eage = sc.nextInt();
        System.out.println("ENTER THE BASIC PAY:");
        double bp = sc.nextDouble();
        System.out.println("ENTER THE GENDER:");
        String egen = sc.next();
        System.out.println("ENTER THE CITY:");
        String ecity = sc.next();
        System.out.println("ENTER THE DEPARTMENT NAME:");
        String edept = sc.next();
        Salary EmpSal = new Salary(eid,ename,eage,bp,egen,ecity,edept);
        EmpSal.calc_GrossSal();
        EmpSal.calc_IncomeTax();
        EmpSal.display();
    }
}
