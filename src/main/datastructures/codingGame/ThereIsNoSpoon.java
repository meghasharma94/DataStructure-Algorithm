package codingGame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class ThereIsNoSpoon {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        int height = in.nextInt(); // the number of cells on the Y axis
        if (in.hasNextLine()) {
            in.nextLine();
        }

        char[][] matrix = new char[width][height];
        System.err.println("Debug messages..."+width + " " + height);


        for (int i = 0; i < height; i++) {
            String line = in.nextLine();// width characters, each either 0 or .
            System.err.println("line.... "+line);
            System.err.println("line.length().... "+line.length());

            for(int j = 0; j < line.length() ; j++){
                System.err.println("line.... "+line.charAt(j) +" - "+ j);
                matrix[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(matrix[i][j]=='0'){
                    System.err.println("Debug messages..."+matrix[i][j]);
                    String result = ""+(j)+" "+(i)+" ";
                    int j1=j+1;
                    int i1=i+1;

                    while(i1 < height){
                        if(matrix[i1][j] == '0'){
                            break;
                        }
                        i1++;
                    }

                    while(j1 < width){
                        if(matrix[i][j1] == '0'){
                            break;
                        }
                        j1++;
                    }

                    if(j1 >=width){
                        result=result +" "+"-1 -1";

                    }else{
                        result=result +" " + j1 +" " +i;
                    }

                    if(i1 >=height){
                        result=result +" "+"-1 -1";

                    }else{
                        result=result +" " + j +" " +i1;
                    }
                    System.out.println(result);
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");


        // Three coordinates: a node, its right neighbor, its bottom neighbor
        //System.out.println("0 0 1 0 0 1");
    }



}