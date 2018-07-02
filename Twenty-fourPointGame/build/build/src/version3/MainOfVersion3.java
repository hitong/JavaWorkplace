package version3;

import util.Count24;

public class MainOfVersion3 {
	public static void main(String[] args) {
		int maxNumber = 13;
		int tmp  = 0;
		double t = 0;
		Count24 c = new Count24();
		c.setVersion3();
		for(int i = 1; i <= maxNumber; i++) {
			for(int j = i; j <=maxNumber; j++) {
				for(int k = j; k <= maxNumber; k++) {
					for(int l = k; l <= maxNumber; l++) {
						try {
							c.getSolutions(new int[] {i,j,k,l});
						}
						catch(Exception ex) {
							t++;
						}
						tmp++;
					}
				}
			}
		}
		
		System.out.println("总共选牌(不考虑花色选择顺序): " + tmp + "次");//不考虑花色
		System.out.println("存在有解的情况：" + (int)t + "个");
		System.out.println("成功几率：" + t / tmp * 100 + "%");
	}
}
