import java.util.*;
class Matrix
{
    public int row;
    public int col;
    public int data[][];
         public Matrix (int row,int col)
    {
        this.row = row;
        this.col = col;
        data = new int[row][col];
    }
    public Matrix multiplication(Matrix m)
    {
        Matrix res = new Matrix(row,col);
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                for (int k=0;k<col;k++)
                {
                    res.data[i][j] += this.data[i][k] * m.data[k][j];
                }
            }
        }
        return res;
    }
    public void transpose()
    {
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                System.out.print(this.data[j][i] + "\t");
            }
            System.out.println();
        }
    }
    public void display()
    {
        for (int i=0;i<row;i++)
        {
            for (int j=0;j<col;j++)
            {
                System.out.print(this.data[i][j] + "\t");
            }
            System.out.println();
        }
    }

}


public class MatrixOperations
{
    public static void main(String args[])
    {
        System.out.println("----------MATRIX MULTIPLICATION AND TRANSPOSE---------");
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE NO OF ROWS:");
        int r = sc.nextInt();
        System.out.println("ENTER THE NO OF COLUMNS:");
        int c = sc.nextInt();
        Matrix m1 = new Matrix(r,c);
        Matrix m2 = new Matrix(r,c);
        System.out.println("ENTER THE ELEMENTS OF THE MATRIX M1:");
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                System.out.println("POSITION : "+i+j);
                m1.data[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        System.out.println("ENTER THE ELEMENTS OF THE MATRIX M2:");
        for (int i=0;i<r;i++)
        {
            for (int j=0;j<c;j++)
            {
                System.out.println("POSITION : "+i+j);
                m2.data[i][j] = sc.nextInt();
            }
            System.out.println();
        }
        System.out.println("---------MATRIX MULTIPLICATION---------");
        System.out.println("RESULT OF M1 * M2");
        Matrix res1 = m1.multiplication(m2);
        res1.display();
        System.out.println("RESULT OF M2 * M1");
        Matrix res2 = m2.multiplication(m1);
        res2.display();
        System.out.println("---------TRANSPOSE OF MATRIX M1---------");
        m1.transpose();
        System.out.println("---------TRANSPOSE OF MATRIX M2---------");
        m2.transpose();
    }
}
