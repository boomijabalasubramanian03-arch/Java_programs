public class Arithmetic
{
   static
   {
      System.loadLibrary("arithlib");
   }
   public native int add(int a,int b);
   public native int sub(int a,int b);
   public native int mul(int a,int b);
   public native int div(int a,int b);

   public static void main(String[] args)
   {
      Arithmetic obj = new Arithmetic();
      int a = 20;
      int b=5;
      System.out.println("a="+a+"b="+b);
      System.out.println("Addition:"+obj.add(a,b));
      System.out.println("Subtraction:"+obj.sub(a,b));
      System.out.println("Multiplication:"+obj.mul(a,b));
      System.out.println("Division:"+obj.div(a,b));
   }
}
