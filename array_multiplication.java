import java.util.Scanner;
public class array_multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter rows for 1 matrix");
        int r1=sc.nextInt();
        System.out.println("enter  colmuns for first matrix");
        int c1=sc.nextInt();


        System.out.println("enter rows for 2 matrix");
        int r2=sc.nextInt();
        System.out.println(" enter columns for 2nd matrix ");
        int c2=sc.nextInt();
        if (c1!=r2){
            System.out.println("multiplication not possible");
            return;
        }
        int[][] ar1=new int[r1][c1];
        int[][] ar2=new int[r2][c2];
        int[][] result=new int[r1][c2];

        System.out.println("enter elements of first matrix");
        for(int i =0;i<r1;i++){
            for(int j=0;j<c1;j++){
                ar1[i][j]=sc.nextInt();

            }
        }

        System.out.println("enter elements of second matrix");
        for(int i =0;i<r2;i++){
            for(int j=0;j<c2;j++){
                ar2[i][j]=sc.nextInt();

            }
        }   

        System.out.println("multiplication of two matrix is");
        for(int i=0;i<r1;i++){
            for(int j =0 ; j<c2;j++){
                result[i][j]=0;
                for(int k =0 ;k<c1;k++){
                     result[i][j]+=ar1[i][k]*ar2[k][j];
                }
            }
        }
        System.out.println(" resultan matrix ");
        for (int i=0;i<r1;i++){
            for(int j =0;j<c2;j++){
                System.out.print(result[i][j]+"  ");
            }
            System.out.println();
        }
        sc.close();
    }
}      