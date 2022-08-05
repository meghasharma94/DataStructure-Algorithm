package codingGame;

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class ShadowOfKnight {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();

        int LY=0, LX=0, HY=H-1, HX=W-1;
        in.next();
        X0=(W-1)/2;
        Y0=(H-1)/2;
        System.out.println(X0 + " " + Y0);
        // game loop
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)
            if(bombDir.length() >1 ){
                if(bombDir.charAt(0)=='U'){
                    HY=Y0-1;
                }else{
                    LY=Y0+1;
                }
                if(bombDir.charAt(1)=='L'){
                    HX=X0-1;
                }else  if(bombDir.charAt(1)=='R'){
                    LX=X0+1;
                }
            }else{

                if(bombDir.charAt(0)=='L'){
                    HX=X0-1;
                }else if(bombDir.charAt(0)=='R'){
                    LX=X0+1;
                }else if(bombDir.charAt(0)=='U'){
                    HY=Y0-1;
                }else{
                    LY=Y0+1;
                }

            }
            X0=(HX+LX)/2;
            Y0=(LY+HY)/2;

            // the location of the next window Batman should jump to.
            System.out.println(X0+" "+Y0);
        }
    }
}