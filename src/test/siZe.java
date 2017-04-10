//编写一个四则运算，包括整数运算、真分数运算，并且添加带有括号的运算（最多可支持十个数参与运算）
//加减有无负数，除法有无余数
//增添数值范围

package test;
import java.util.*;
public class siZe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N;
		int mid;
		System.out.println("请输入题目的总数：");
		N = scan.nextInt();
		String[] timu = new String[N];//用于存储题目
		if(N%2== 0)
			mid = N/2;
		else
			mid = (N-1)/2;
		for(int i = 0;i<mid;i++){
			timu = zhengShu(N);
			System.out.println(i+1 + ".)  "+timu[i]);
			
		}
		for(int i = mid;i<N;i++){
			timu = zhenFenshu(N);
			System.out.println(i+1 + ".)  "+timu[i]);
		}

		
		

	}
	
	//整数计算
	public static String[] zhengShu(int n){
		String[] timu = new String[n];
		String linshi = "";
		int num1,num2,singal = 0;
		int i = 0;//统计次数
		Random random = new Random();
		
		while(i < n){
			num1 = random.nextInt(100);
			num2 = random.nextInt(100);
			singal = random.nextInt(4);
			
			if(singal == 0) 
				linshi =  ""+num1 + "+" + num2 + "=" + num1+num2;
			if(singal == 1&&num1>num2)
				linshi =  ""+num1 + "-" + num2 + "=" + (num1-num2);
			if(singal == 2) 
				linshi =  ""+num1 + "*" + num2 + "=" + num1*num2;
			if(singal == 3&&num2!=0&&num1%num2 == 0) 
				linshi =  ""+num1 + "/" + num2 + "=" + num1/num2;
			if(bChongFu(timu,linshi,i)){
				timu[i] = linshi;
				i++;
			}
			
		}
		return timu;
		
	}
	
	
	//真分数计算
	public static String[] zhenFenshu(int n){
		String[] timu = new String[n];
		String linshi = "";
		int num1,num2,singal, x , y  = 0; //num1、num2为分子,a、b为分子
		int i = 0;//统计次数
		Random random = new Random();
		while(i < n){
			num1 = random.nextInt(100);
			num2 = random.nextInt(100);
			singal = random.nextInt(4);
			x = random.nextInt(100);
			y = random.nextInt(100);
			
			if(singal == 0 && y!=0 && num1*y+num2*x<=x*y) 
				linshi =  ""+num1 + "/"  + x +" + "+ num2 + "/" + y + "=" + simpleNumber(num1*y+num2*x,x*y);
			if(singal == 1 && y!=0 && num1*y+num2*x<=x*y) 
				linshi =  ""+num1 + "/"  + x +" - "+ num2 + "/" + y + "=" + simpleNumber(num1*y-num2*x,x*y);
			if(singal == 2 && y!=0 && num1*num2<=x*y) 
				linshi =  ""+num1 + "/"  + x +" * "+ num2 + "/" + y + "=" +simpleNumber (num1*num2,x*y);
			if(singal == 3 && y!=0 && num1*y<=num2*x) 
				linshi =  ""+num1 + "/"  + x + " / "+num2 + "/" + y + "=" + simpleNumber(num1*y,num2*x);
			if(bChongFu(timu,linshi,i)){
				timu[i] = linshi;
				i++;
			}
		}
		return timu;
		
	}
	
	//对分数进行化简
	public static String simpleNumber(int f1,int f2){
		int maxYs = 1;
		for(int i = f1;i>=1;i--){
			if(f1%i==0 && f2%i==0){
				maxYs = i;
				break;
			}
		}
		f1 = f1 / maxYs;
		f2 = f2 / maxYs;
		if(f1 == 0)
			return "0";
		else
			return  +f1+"/"+f2;
}
	
	//判断题目是否重复
	public static boolean bChongFu(String[] timu,String linshi,int n){
		for(int i = 0;i<n;i++){
			if(timu[i].equals(linshi))
				return false;
		}
		return true;
		
	}
	

}
