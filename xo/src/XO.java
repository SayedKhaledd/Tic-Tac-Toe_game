/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author comp
 */
public class XO {

    static char x[][]= new char[3][3];
//	public static void main2() {
//		Scanner scan =new Scanner(System.in);
//
//try{
//	for(int j=0;j<9;j++){
//	System.out.println("----------------");
//
//	for(int i=0;i<3;i++){
//
//System.out.printf("|%3c |%3c |%3c |\n----------------\n",x[i][0],x[i][1],x[i][2]);
//	}
//		 check();
//
//	if((j+1)%2!=0){
//	System.out.println("enter for the row of player x row 1 ,2 or 0 ");
//        int indexr=scan.nextInt();
//				System.out.println("enter for the row of player x row 1 ,2 or 0 ");
//
//		        int indexc=scan.nextInt();
//				if(indexc>2 || indexr>2){
//					System.out.println("ERROR ! Enter an available  index pls !");
//				j--;
//				}
//				else if( x[indexr][indexc]=='\0'){
//     x[indexr][indexc]='X';}
//				else{
//					j--;
//
//				}
//	}
//else{
//		System.out.println("enter for the row of player o row 1 ,2 or 0 ");
//        int indexr=scan.nextInt();
//				System.out.println("enter for the row of player o row 1 ,2 or 0 ");
//
//		        int indexc=scan.nextInt();
//				if(indexc>2 || indexr>2){
//				System.out.println("ERROR ! Enter an available  index pls !");
//					j--;
//				}
//				else if( x[indexr][indexc]=='\0'){
//     x[indexr][indexc]='O';}
//				else{
//					j--;
//				}
//
//}
//}
//System.out.println("Draw ! ");
//}
//catch(Exception e){
//			System.out.println("error");
//			}
//
//
//	}

    public static boolean checkx(){
        boolean result=false;
        for(int i=0; i<3;i++){
            if((x[i][0]=='X' && x[i][1]=='X' & x[i][2]=='X')||(x[0][i]=='X' && x[1][i]=='X' & x[2][i]=='X')){
                System.out.println(" player X wins !!");
                result=true;
            }
            if ((x[1][1]=='X' && x[0][0]=='X' & x[2][2]=='X') ||((x[0][2]=='X' && x[1][1]=='X' & x[2][0]=='X'))){
                System.out.println(" player X wins !!");
                result=true;
            }

        }
        return result;

    }
    public static boolean checko(){
        boolean result=false;
        for(int i=0; i<3;i++){

            if((x[i][0]=='O' && x[i][1]=='O' & x[i][2]=='O')||(x[0][i]=='O' && x[1][i]=='O' & x[2][i]=='O')){
                System.out.println(" player O wins !!");
                result=true;
            }
            if ((x[1][1]=='O' && x[0][0]=='O' & x[2][2]=='O') ||((x[0][2]=='O' && x[1][1]=='O' & x[2][0]=='O'))){
                System.out.println(" player O wins !!");

                result=true;
            }
        }
        return result;

    }

}
