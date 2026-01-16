import java.util.Scanner;
public class array_baisc {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter number of rows: ");
        int row = sc.nextInt();

        System.out.println("enter no of coloumns");
        int cols=sc.nextInt();
        int[][] ar1=new int[row][cols];
        int[][] ar2=new int[row][cols];
        int[][] sum=new int[row][cols];

        System.out.println("enter elements of first matrix");
        for(int i =0;i<row;i++){
            for (int j=0; j<cols;j++){
                ar1[i][j]=sc.nextInt();
            }
        }

        System.out.println("enter elements of second matrix");
        for(int i=0;i<row;i++){
            for(int j =0;j<cols;j++){
                ar2[i][j]=sc.nextInt();

            }
        }

        System.out.println("sum of two matrix is");
        for(int i=0;i<row;i++){
            for(int j  =0; j<cols;j++){
                sum[i][j]=ar1[i][j]+ar2[i][j];
            }
        }
        for(int i=0;i<row;i++){
            for(int j  =0; j<cols;j++){
                System.out.print(sum[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();                             
    }
}   
