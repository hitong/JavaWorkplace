package fourthTest;

public class Test5 {
	public static boolean knap(int[] n, int i,  int s){
		if(i < 0 || i >= n.length || n[i] < 0){
			throw new IllegalArgumentException();
		}
		
		if(s == 0){
			return true;
		}
		if(s < 0){
			return false;
		}
		if(i == n.length - 1){
			if(s - n[i] == 0){
				return true;
			}
			else{
				return false;
			}
		}
		
		if(knap(n,i + 1,s - n[i])){
			System.out.print(n[i] + " ");
			return true;
		}
		if(knap(n, i + 1,  s)){
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args){
		int m = (int)(Math.random() * 10) + 10;
		int[] n = new int[m];
		int s =(int)( Math.random() * 10 )+ 10;
		for(int i = 0; i < m; i++){
			n[i] = (int)(Math.random() * 10);
		}
		System.out.print("该数组为：");
		for(int t: n){
			System.out.print(t + " ");
		}
		System.out.println();
		System.out.println("包容量：" + s);
		if(!knap(n, 0, s)){
			System.err.println("无解");
		};
	}
}
