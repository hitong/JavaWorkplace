package localPattern;

public class MyChess {
	int iLocal = -1;// 内部坐标,策略判断，从0开始编号
	int board = 1;// 棋盘号，策略选择
	int index = 1;//列表号，map选择
	
	public MyChess(int iLocal, int board, int index){
		this.iLocal = iLocal;
		this.board =board;
		this.index = index;
	}
}