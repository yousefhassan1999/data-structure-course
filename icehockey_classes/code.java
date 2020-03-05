package icehockey_classes;

import java.awt.Point;

import icehockyinterface.IPlayersFinder;

public class code implements IPlayersFinder {
	public int y_min , y_max , x_min , x_max;
	public int area=0;
	public int player=0 ;
	public int [][] arr;
	public Point[] center_point ;
	public Point[]requir_arr;
	
	/// to convert the array of string to sparse array to make it easy to check about the player .
	public void conv_string_arr(String[]photo,int team){
		arr=new int [photo.length][photo[0].length()];
		for(int i=0 ; i<photo.length;i++) {
			int k=0;
			for(int j=0 ; j<photo[0].length();j++) {
				if(Character.getNumericValue(photo[i].charAt(k))==team) {
					arr[i][j]=1;
					k++;
				}
				else {
					arr[i][j]=0;
					k++;
				}
			}
		}	
	}
	
	/// i use the recursive to check if it was player or not .
	
	public void recursive(int i, int j , int threshold) {
		
		if(arr[i][j]!=0) {
			if(x_min>j) {
				x_min=j;
			}
			if(x_max<j) {
				x_max=j;
			}	
			if(y_min>i) {
				y_min=i;
			}
			if(y_max<i) {
				y_max=i;
			}
			area++;
			arr[i][j]=0;
			if((j+1)<arr[0].length)
			recursive(i,j+1,threshold);
			if((j-1)>=0)
			recursive(i,j-1,threshold);
			if((i+1)<arr.length)
			recursive(i+1,j,threshold);
			if((i-1)>=0)
			recursive(i-1,j,threshold);
			if(area*4>=threshold) {
				player=1;
			}
			else 
				player=0;
		}
	}
	
	// i sort the require array of points 
	public void bubble_sort(Point[]arr) {
		for(int i=0 ; i<arr.length ; i++) {
			for(int j=0 ; j<arr.length-1-i ; j++) {
				if(arr[j].getX()>arr[j+1].getX()) {
					swap(arr,j,j+1);
				}
				if((arr[j].getX()==arr[j+1].getX())&&(arr[j].getY()>arr[j+1].getY())) {
					swap(arr,j,j+1);
				}
			}
		}
		
	}
	
	public void swap(Point[]arr,int index1,int index2) {
		Point p=new Point();
		p=arr[index1];
		arr[index1]=arr[index2];
		arr[index1]=p;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////
	public java.awt.Point[] findPlayers(String[] photo, int team, int threshold) {
		int m=0;
	    center_point=new Point[2500];
		conv_string_arr(photo,team);
		for(int i=0 ; i<arr.length;i++) {
			for(int j=0 ; j<arr[0].length;j++) {
				if(arr[i][j]==1) {
					y_min=i;
					y_max=i;
					x_min=j;
					x_max=j;
					recursive(i,j,threshold);
					if(player==1) {
						center_point[m] = new Point();
						center_point[m].setLocation(x_max+ x_min+1, y_max +y_min+1);
						m++;
					}
					area=0;
					player=0;
				}
			}
		}
		requir_arr=new Point[m];
		for(int co=0;co<m;co++) {
			requir_arr[co]=center_point[co];
		}
		bubble_sort(requir_arr);
		
		return requir_arr;
	}
}
