import java.util.Scanner;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App 
{
    public static void main(String[] args) throws Exception
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Input the number of rows you want Matrix 1 to have");
        Integer row1 = scan.nextInt();
        System.out.println("Inpur the number of columns you want Matrix 1 to have");
        Integer clmn1 = scan.nextInt();

        System.out.println("Input the number of rows you want Matrix 2 to have");
        Integer row2 = scan.nextInt();
        int clmn2 = row1;

        int[][] mtrx1 = createMatrix(row1, clmn1);
        String fp = "matrix1.txt";
        writeMatrix(mtrx1, fp);

        int[][] mtrx2 = createMatrix(row2, clmn2);
        writeMatrix(mtrx2, "matrix2.txt");

        int[][] mtrx3 = multiplyMatrix(mtrx1, mtrx2);
        writeMatrix(mtrx3, "matrix3.txt");

        printMatrix(mtrx1);
        System.out.println("");
        printMatrix(mtrx2);
        System.out.println("");
        printMatrix(mtrx3);

        scan.close();
    }

    public static int[][] createMatrix(int rows, int clmn)
    {
        int[][] mtrx = new int[rows][clmn];
        Random rand = new Random();

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < clmn; j++)
            {
                mtrx[i][j] = rand.nextInt(10);
            }
        }
        return mtrx;
    }

    public static void writeMatrix(int[][] mtrx, String fp) throws IOException
    {
        BufferedWriter write = new BufferedWriter(new FileWriter(fp));

        for (int i = 0; i < mtrx.length; i++)
        {
            for (int j = 0; j < mtrx[i].length; j++)
            {
                write.write(mtrx[i][j] + " ");
            }
            write.newLine();
        }
        write.close();
    }

    public static int[][] multiplyMatrix(int[][] mtrx1, int[][] mtrx2)
    {
        int row1 = mtrx1.length;
        int clmn1 = mtrx1[0].length;
        int clmn2 = mtrx2[0].length;

        int[][] mtrx3 = new int[row1][clmn2];

        for (int i = 0; i < row1; i++)
        {
            for (int j = 0; j < clmn2; j++)
            {
                for (int k = 0; k < clmn1; k++)
                {
                    mtrx3[i][j] += mtrx1[i][k] *mtrx2[k][j];
                }
            }
        }
        return mtrx3;
    }

    public static void printMatrix(int[][] mtrx)
    {
        int clmn = mtrx[0].length;

        for(int i = 0; i < mtrx.length; i++)
        {
            System.out.print("[");
            for (int j = 0; j < mtrx[0].length; j++)
            {
                System.out.print(mtrx[i][j]);
                if (j < clmn -1)
                {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        System.out.println();
    }
}
