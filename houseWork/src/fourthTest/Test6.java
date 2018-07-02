package fourthTest;

public class Test6 {
	public static boolean loop(int[] m, int n){
		int max = m.length - 1;
		int min = 0;
		int mid = max / 2;
		
		while(max >= min){
			if(m[mid] == n){
				return true;
			}			
			if(m[mid] < n){
				min = mid + 1;
				mid = (max + min) / 2;
			}
			else{
				max = mid - 1;
				mid = (max + min) / 2;
			}
		}
		return false;
	}
	
	public static boolean rec(int[] m, int max , int min, int mid, int n){
		if(max < min){
			return false;
		}
		
		if(m[mid] == n){
			return true;
		}
		if(m[mid] > n){
			return rec(m, mid - 1, min , (mid - 1 + min) / 2, n);
		}
		else{
			return rec(m, max , mid + 1 , (max + mid + 1) / 2, n);
		}
	}
	
	public static void main(String[] args){
		int num = 100000000;
		int[] m = new int[num];
		for(int i = 0; i < num; i++){
			m[i] = i	;
		}
		
		int s = (int)(Math.random() * num);
		long tmp = System.nanoTime();
		rec(m,num,0,num / 2, s);
		
		System.out.println("第一轮测试:");
		System.out.println("失败测试:");
		tmp = System.nanoTime();
		rec(m,num,0,num / 2, -1);
		System.out.println("采用递归耗时:" + (System.nanoTime() - tmp));
		
		tmp = System.nanoTime();
		loop(m, -1);
		System.out.println("采用循环耗时:" + (System.nanoTime() - tmp));
		
		System.out.println("成功测试:");	
		tmp = System.nanoTime();
		rec(m,num,0,num / 2, s);
		System.out.println("采用递归耗时:" + (System.nanoTime() - tmp));
		
		tmp = System.nanoTime();
		loop(m, s);
		System.out.println("采用循环耗时:" + (System.nanoTime() - tmp));
		
		System.out.println();
		System.out.println("第二轮测试:");
		System.out.println("成功测试:");	
		tmp = System.nanoTime();
		rec(m,num,0,num / 2, s);
		System.out.println("采用递归耗时:" + (System.nanoTime() - tmp));
		
		tmp = System.nanoTime();
		loop(m, s);
		System.out.println("采用循环耗时:" + (System.nanoTime() - tmp));
		
		System.out.println("失败测试:");
		tmp = System.nanoTime();
		rec(m,num,0,num / 2, -1);
		System.out.println("采用递归耗时:" + (System.nanoTime() - tmp));
		
		tmp = System.nanoTime();
		loop(m, -1);
		System.out.println("采用循环耗时:" + (System.nanoTime() - tmp));
		
	}
}
