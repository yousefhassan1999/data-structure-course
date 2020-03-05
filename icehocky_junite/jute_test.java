package icehocky_junite;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;

import org.junit.jupiter.api.Test;

import icehockey_classes.code;

class jute_test {

	code test1;
	code test3;
	
	@Test
	void conv_string_arr_test() {
		test1=new code();
		String[] photo=new String [2];
		photo[0]="3h3ed3";
		photo[1]="ah3ed3";
		int team=3;
		test1.conv_string_arr(photo,team);
		assertEquals(1,test1.arr[0][0]);
		assertEquals(0,test1.arr[0][1]);
		int counter=0;
		for(int i=0 ; i<6 ; i++) {
			for(int j=0 ; j<2 ; j++) {
				if(test1.arr[j][i]==1) {
					counter++;
				}
			}
		}
		assertEquals(5,counter);
	}
	
	@Test
	void game_test() {
		test1=new code();
		String[] photo=new String [5];
		photo[0]="333ed3";
		photo[1]="a33ed3";
		photo[2]="h30ed3";
		photo[3]="a035d0";
		photo[4]="a33333";
		int team=3;
		test1.conv_string_arr(photo,team);		
		Point[]test =new Point[2];
		test[0]=new Point(3,3);
		test[1]=new Point(7,8);
		Point [] test2=new Point[2];
		test2=test1.findPlayers(photo, team, 16);
		System.out.println(test2[0]);
		System.out.println(test2[1]);
		assertEquals(test[0],test2[0]);	
		assertEquals(test[1],test2[1]);
		///////////////////////////////////////////////////////// Another example
		test3=new code();
		String[] photo1=new String [7];
		photo1[0]="55dlf55ssd5";
		photo1[1]="55rddeddd55";
		photo1[2]="d5dfd5sddf5";
		photo1[3]="f55c55dx5s5";
		photo1[4]="sk55d5ddfg5";
		photo1[5]="sk5555hdfg5";
		photo1[6]="sk55d5ddfg5";
		int team1=5;
		test1.conv_string_arr(photo1,team1);		
		Point[]test4 =new Point[2];
		test4[0]=new Point(6,7);
		test4[1]=new Point(20,7);
		Point [] test5=new Point[2];
		test5=test1.findPlayers(photo1, team1, 16);
		System.out.println(test5[0]);
		System.out.println(test5[1]);
		assertEquals(test4[0],test5[0]);	
		assertEquals(test4[1],test5[1]);
	}
	
	
	
	

}
