import java.util.*;
class Payment
{
        public String payee;
        public String date;
        public double amt;
        static int id=105;
Payment(String payee,String date,double amt)
{
        this.payee=payee;
        this.date=date;
        this.amt=amt;
}
public void display()
{
        System.out.println("===============DETAILS OF EMPLOYEE================");
        System.out.println("PAYEE NAME:" +payee);
        System.out.println("BILL DATE:" +date);
        System.out.println("BILL AMOUNT:" +amt);
        System.out.println("BILL ID:" +id);
}
static void change()
{
        id++;
}
}
class Cash extends Payment
{
Cash(String payee,String date,double amt)
{
        super(payee,date,amt);
}
public void calamt()
{
        this.amt+=this.amt*0.12;
        System.out.println("AMOUNT WITH GST:"+this.amt);
        super.display();
}
}
class Card extends Payment
{
        public String card_no;
        public String pin_no;
Card(String payee,String date,double amt,String card_no,String pin_no)
{
        super(payee,date,amt);
        this.card_no=card_no;
        this.pin_no=pin_no;
}
}
class Debit extends Card
{
Debit(String payee,String date,double amt,String card_no,String pin_no)
{
        super(payee,date,amt,card_no,pin_no);
}
public void debitcal()
{
        this.amt+=this.amt*0.1;
        super.display();
}
}
class Credit extends Card
{
Credit(String payee,String date,double amt,String card_no,String pin_no)
{
        super(payee,date,amt,card_no,pin_no);
}
public void credited()
{
        this.amt+=this.amt*0.05;
        super.display();
}
}
public class Bill
{
        public static void main (String[] args)
        {
        Scanner Sc=new Scanner(System.in);
        System.out.println("ENTER THE NO OF PAYEE:");
        int n=Sc.nextInt();
        for(int i=0;i<n;i++)
        {
                System.out.println("ENTER NAME,DATE,AMOUNT:");
                String name=Sc.next();
                String date=Sc.next();
                double amt=Sc.nextDouble();

                System.out.println("Select your mode of Payment(card or cash):");
                String mode=Sc.next();
                if(mode.equals("cash"))
                {
                        Cash c=new Cash(name,date,amt);
                        c.calamt();
                }
                else
                {
                        System.out.println("Enter credit or debit:");
            String card=Sc.next();

         if(card.equals("credit"))
                        {
                                System.out.println("ENTER CARD_NO & PIN_NO:");
                                String card_no=Sc.next();
                                String pin_no=Sc.next();
                                Credit c1=new Credit(name,date,amt,card_no,pin_no);
                                c1.credited();
                        }
                        else
                        {
                                System.out.println("ENTER CARD_NO & PIN_NO:");
                                String card_no=Sc.next();
                                String pin_no=Sc.next();
                                Debit d=new Debit(name,date,amt,card_no,pin_no);
                                d.debitcal();
                        }

                }
        }
}
}
