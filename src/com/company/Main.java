package com.company;
import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;



public class Main {
   // static void check(int[][] a) {
       //for (int i = 0; i < n; ++i) {
          //  if (a[i][i] == 0) {
            //    throw new NullPointerException("Can't solve");
            //}
        //}
    //}
    public static void main(String[] args) throws FileNotFoundException{

        int c = 0;
        int n = 3;
        int x[] = new int[n];


        Scanner scanner = new Scanner(new File("in.txt"));
        int[][] a = new int[n][n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 0;
            }
            b[i] = 0;
        }

         for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = scanner.nextInt();
                }
                b[i] = scanner.nextInt();
            }
         for (int i = 0; i < n; ++i) {
            System.out.println();
            for (int j = 0; j < n; ++j) {
              System.out.print(a[i][j] + "\t");

            }
           System.out.print(b[i] + "\t");
        }


//Gaus

            for (int i = n - 1; i >= 0; --i) {
                for (int j = n - 1; j >= 1; --j) {
                    if (i != j - 1) {
                      if(a[i][i]==0) {
                        throw new ArithmeticException("Can't solve");
                      }
                      else if(a[i][i]!=0) {
                          b[i] /= a[i][i];

                          a[i][i] = 1;
                          c = a[j - 1][i];
                          a[j - 1][i] -= a[i][i] * c;
                          b[j - 1] = b[j - 1] - b[i] * c;
                      }
                    }
                }
            }
            System.out.println("\n" + "\n");
            for (int i = 0; i < n; ++i) {
                if(a[i][i]==0) {
                    throw new ArithmeticException("Can't solve");
                }
                else if(a[i][i]!=0) {
                    x[i] = b[i] / a[i][i];
                }
                System.out.print(x[i] + "\t");
            }


        System.out.println("\n"+"\n");

//Reverse

        Scanner sc = new Scanner(new File("rev.txt"));
        double[][] A = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextDouble();
            }
        }





        double temp;
        double [][] E = new double [n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                E[i][j] = 0;

                if (i == j)
                    E[i][j] = 1;
            }

        for (int k = 0; k < n; k++)
        {
            if(A[k][k]==0) {
                throw new NullPointerException("Can't solve");
            }
            else if(A[k][k]!=0){
            temp = A[k][k];

            for (int j = 0; j < n; j++)
            {
                A[k][j] /= temp;
                E[k][j] /= temp;
            }


            for (int i = k + 1; i < n; i++)
            {
                temp = A[i][k];

                for (int j = 0; j < n; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }
        }

        for (int k = n - 1; k > 0; k--)
        {
            for (int i = k - 1; i >= 0; i--)
            {
                temp = A[i][k];

                for (int j = 0; j < n; j++)
                {
                    A[i][j] -= A[k][j] * temp;
                    E[i][j] -= E[k][j] * temp;
                }
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                A[i][j] = E[i][j];
            }


        for (int i = 0; i < n; ++i) {
            System.out.println();
            for (int j = 0; j < n; ++j) {
                System.out.print(A[i][j] + "\t");

            }
        }

    }
}


