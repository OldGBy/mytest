//��дһ���������㣬�����������㡢��������㣬������Ӵ������ŵ����㣨����֧��ʮ�����������㣩
//�Ӽ����޸�����������������
//������ֵ��Χ

package test;
import java.util.*;
public class siZe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N;
		int mid;
		System.out.println("��������Ŀ��������");
		N = scan.nextInt();
		String[] timu = new String[N];//���ڴ洢��Ŀ
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
	
	//��������
	public static String[] zhengShu(int n){
		String[] timu = new String[n];
		String linshi = "";
		int num1,num2,singal = 0;
		int i = 0;//ͳ�ƴ���
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
	
	
	//���������
	public static String[] zhenFenshu(int n){
		String[] timu = new String[n];
		String linshi = "";
		int num1,num2,singal, x , y  = 0; //num1��num2Ϊ����,a��bΪ����
		int i = 0;//ͳ�ƴ���
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
	
	//�Է������л���
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
	
	//�ж���Ŀ�Ƿ��ظ�
	public static boolean bChongFu(String[] timu,String linshi,int n){
		for(int i = 0;i<n;i++){
			if(timu[i].equals(linshi))
				return false;
		}
		return true;
		
	}
	

}
