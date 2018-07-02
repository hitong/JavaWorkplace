package localPattern;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalPattern {
	private int pastMove = -1;// 结果返回
	int[] chess = new int[49];
	MyChess[] chesses = new MyChess[49];// 0坐标为中心对称点，下标对应固定坐标
	int mapKey = 1;// 自增
	HashMap<Integer, int[]> map = new HashMap<>();// 数组下标为落子内部坐标通过chess中对应，下标值对应外部固定值用于返回结果

	public LocalPattern(boolean frist) {
		int[] chess = new int[48];
		for (int i = 0; i < chess.length; i++) {
			chess[i] = i;
			chesses[i] = new MyChess(i, 1, 1);
		}
		map.put(mapKey++, chess);
	}

	/**
	 * 
	 * @param move
	 *            外部坐标
	 * @return
	 */
	public int moveIn(int move) {
		MyChess myChess = chesses[move];
		int[] list = map.remove(myChess.index);
		switch (myChess.board) {
		case 0:
		case 1:
			LocalPattern1(myChess.iLocal, list);
			break;
		case 2:
			LocalPattern2(myChess.iLocal, list);
			break;
		case 3:
			LocalPattern3(myChess.iLocal, list);
			break;
		case 4:
			LocalPattern4(myChess.iLocal, list);
			break;
		case 5:
			LocalPattern5(myChess.iLocal, list);
			break;
		case 6:
			LocalPattern6(myChess.iLocal, list);
			break;
		case 7:
			LocalPattern7(myChess.iLocal, list);
			break;
		case 8:
			LocalPattern8(myChess.iLocal, list);
			break;
		case 9:
			LocalPattern9(myChess.iLocal, list);
			break;
		case 10:
			LocalPattern10(myChess.iLocal, list);
			break;
		case 11:
			LocalPattern11(myChess.iLocal, list);
			break;
		case 12:
			LocalPattern12(myChess.iLocal, list);
			break;
		case 13:
			LocalPattern13(myChess.iLocal, list);
			break;
		case 14:
			LocalPattern14(myChess.iLocal, list);
			break;
		case 15:
			LocalPattern15(myChess.iLocal, list);
			break;
		case 16:
			LocalPattern16(myChess.iLocal, list);
			break;
		case 17:
			LocalPattern17(myChess.iLocal, list);
			break;
		case 18:
			LocalPattern18(myChess.iLocal, list);
			break;
		case 19:
			LocalPattern19(myChess.iLocal, list);
			break;
		case 20:
			LocalPattern20(myChess.iLocal, list);
			break;
		case 21:
			LocalPattern21(myChess.iLocal, list);
			break;
		case 22:
			LocalPattern22(myChess.iLocal, list);
			break;
		case 23:
			LocalPattern23(myChess.iLocal, list);
			break;
		case 24:
			LocalPattern24(myChess.iLocal, list);
			break;
		case 25:
			LocalPattern25(myChess.iLocal, list);
			break;
		case 26:
			LocalPattern26(myChess.iLocal, list);
			break;
		case 27:
			LocalPattern27(myChess.iLocal, list);
			break;
		case 28:
			LocalPattern28(myChess.iLocal, list);
			break;
		case 29:
			LocalPattern29(myChess.iLocal, list);
			break;
		case 30:
			LocalPattern30(myChess.iLocal, list);
			break;
		case 31:
			LocalPattern31(myChess.iLocal, list);
			break;
		case 32:
			LocalPattern32(myChess.iLocal, list);
			break;
		case 33:
			LocalPattern33(myChess.iLocal, list);
			break;
		case 34:
			LocalPattern34(myChess.iLocal, list);
			break;
		case 35:
			LocalPattern35(myChess.iLocal, list);
			break;
		case 36:
			LocalPattern36(myChess.iLocal, list);
			break;
		case 37:
			LocalPattern37(myChess.iLocal, list);
			break;
		case 38:
			LocalPattern38(myChess.iLocal, list);
			break;
		case 39:
			LocalPattern39(myChess.iLocal, list);
			break;
		case 40:
			LocalPattern40(myChess.iLocal, list);
			break;
		case 41:
			LocalPattern41(myChess.iLocal, list);
			break;
		}// 棋盘选择
		return pastMove;
	}

	// 传入内部坐标,board中存放外部坐标
	private void LocalPattern1(int local, int[] board) {
		if (local == 0 || local == 1 || local == 2 || local == 3 || local == 7 || local == 8 || local == 9
				|| local == 10 || local == 14 || local == 15 || local == 16 || local == 21 || local == 22
				|| local == 23) {
			pastMove = board[11];
			putMap(2, new int[] { board[4], board[5] });
			putMap(2, new int[] { board[17], board[18] });// ****
			putMap(3, new int[] { board[6], board[12], board[13], board[19], board[20], board[24], board[25], board[29],
					board[30], board[31], board[32], board[33], board[35], board[36], board[37], board[38], board[39],
					board[40], board[41], board[42], board[43], board[44], board[45], board[46], board[47] });
		} else if (local == 13 || local == 19 || local == 20) {
			pastMove = board[36];
			putMap(2, new int[] { board[29], board[30] });
			putMap(2, new int[] { board[42], board[43] });
			putMap(3,
					new int[] { board[41], board[35], board[34], board[28], board[27], board[23], board[22], board[18],
							board[17], board[16], board[15], board[14], board[12], board[11], board[10], board[9],
							board[8], board[7], board[6], board[5], board[4], board[3], board[2], board[1], board[0] });
		} else if (local == 12 || local == 6) {
			pastMove = board[18];
			putMap(4, new int[] { board[23], board[17], board[17], board[15], board[11], board[10], board[9], board[8],
					board[5], board[4], board[3], board[2], board[1] });
			putMap(5,
					new int[] { board[19], board[24], board[25], board[29], board[30], board[31], board[32], board[35],
							board[36], board[37], board[38], board[39], board[41], board[42], board[43], board[44],
							board[45], board[46] });
		} else if (local == 11) {
			pastMove = board[18];
			putMap(6, new int[] { board[23], board[17], board[16], board[15], board[12], board[10], board[9], board[8],
					board[6], board[5], board[5], board[3], board[2], board[1] });
			putMap(5,
					new int[] { board[19], board[24], board[25], board[29], board[30], board[31], board[32], board[35],
							board[36], board[37], board[38], board[39], board[41], board[42], board[43], board[44],
							board[45], board[46] });
		} else if (local == 5) {
			pastMove = board[19];
			putMap(2, new int[] { board[18], board[24] });
			putMap(7, new int[] { board[23], board[17], board[16], board[15], board[13], board[12], board[10], board[9],
					board[8], board[6], board[4], board[3], board[2], board[1] });
			putMap(8,
					new int[] { board[25], board[29], board[30], board[31], board[32], board[35], board[36], board[37],
							board[38], board[39], board[41], board[42], board[43], board[44], board[45], board[46] });
		} else if (local == 4) {
			pastMove = board[12];
			putMap(2, new int[] { board[5], board[6] });
			putMap(9,
					new int[] { board[18], board[17], board[16], board[11], board[10], board[9], board[3], board[2] });
			putMap(10,
					new int[] { board[19], board[24], board[25], board[29], board[30], board[31], board[32], board[35],
							board[36], board[37], board[38], board[39], board[41], board[42], board[43], board[44],
							board[45], board[46] });
		} else if (local == 17) {
			pastMove = board[18];
			putMap(11,
					new int[] { board[2], board[3], board[4], board[5], board[6], board[9], board[10], board[11],
							board[12], board[13], board[15], board[16], board[19], board[22], board[23], board[24],
							board[25], board[27], board[28], board[29], board[30], board[31], board[32], board[33],
							board[34], board[35], board[36], board[37], board[38], board[39], board[40], board[41],
							board[42], board[43], board[44], board[45], board[46], board[47] });
		} else if (local == 18) {
			pastMove = board[17];
			putMap(12,
					new int[] { board[0], board[1], board[2], board[3], board[4], board[5], board[6], board[7],
							board[8], board[9], board[10], board[11], board[12], board[13], board[14], board[15],
							board[16], board[19], board[20], board[21], board[22], board[23], board[24], board[25],
							board[26], board[27], board[28], board[29], board[30], board[31], board[32], board[33],
							board[34], board[35], board[36], board[37], board[38], board[39], board[40], board[41],
							board[42], board[43], board[44], board[45], board[46], board[47] });
		} else {
		} // 对称落子
	}

	private void LocalPattern2(int local, int[] board) {
		if (local == 0) {
			pastMove = board[1];
		} else {
			pastMove = board[0];
		}
	}

	private void LocalPattern3(int local, int[] board) {
		if (local == 0 || local == 1 || local == 2 || local == 3 || local == 4 || local == 5 || local == 6 || local == 9
				|| local == 10 || local == 11 || local == 12 || local == 14 || local == 15 || local == 16 || local == 17
				|| local == 18 || local == 21 || local == 22 || local == 23 || local == 24) {
			pastMove = board[13];
			putMap(2, new int[] { board[7], board[8] });
			putMap(2, new int[] { board[19], board[20] });
		} else if (local == 7 || local == 13 || local == 19) {
			pastMove = board[9];
			putMap(2, new int[] { board[5], board[8] });
			putMap(13, new int[] { board[10], board[14], board[15], board[16], board[20], board[21], board[22],
					board[23] });
		} else if (local == 20) {
			pastMove = board[12];
			putMap(2, new int[] { board[18], board[19] });
			putMap(9,
					new int[] { board[7], board[8], board[9], board[13], board[14], board[15], board[21], board[22] });
		} else if (local == 8) {
			pastMove = board[7];
			putMap(14,
					new int[] { board[0], board[1], board[2], board[3], board[4], board[5], board[6], board[9],
							board[10], board[12], board[13], board[14], board[15], board[18], board[19], board[20],
							board[21], board[22] });
		} else {
		}
	}

	private void LocalPattern4(int local, int[] board) {
		if (local == 0 || local == 1 || local == 2 || local == 3 || local == 5 || local == 6 || local == 7
				|| local == 10 || local == 11 || local == 12) {
			pastMove = board[4];
			putMap(2, new int[] { board[9], board[8] });
		} else if (local == 4 || local == 8) {
			pastMove = board[2];
			putMap(2, new int[] { board[0], board[1] });
			putMap(13, new int[] { board[3], board[5], board[6], board[7], board[9], board[10], board[11], board[12] });
		} else if (local == 9) {
			pastMove = board[4];
			putMap(15, new int[] { board[0], board[1], board[2], board[5], board[6], board[8], board[10], board[11] });
		}
	}

	private void LocalPattern5(int local, int[] board) {
		if (local == 0 || local == 1 || local == 2 || local == 5 || local == 6 || local == 9 || local == 10
				|| local == 11 || local == 15 || local == 16 || local == 17) {
			pastMove = board[8];
			putMap(2, new int[] { board[3], board[4] });
			putMap(2, new int[] { board[13], board[14] });
		} else if (local == 3 || local == 7 || local == 8 || local == 12 || local == 13) {
			pastMove = board[5];
			putMap(2, new int[] { board[1], board[4] });
			putMap(13,
					new int[] { board[6], board[9], board[10], board[11], board[14], board[15], board[16], board[17] });
		} else if (local == 14) {
			pastMove = board[7];
			putMap(2, new int[] { board[12], board[13] });
			putMap(9, new int[] { board[3], board[4], board[5], board[8], board[9], board[10], board[15], board[16] });
		} else if (local == 4) {
			pastMove = board[3];
			putMap(16, new int[] { board[0], board[1], board[2], board[5], board[6], board[7], board[8], board[9],
					board[10], board[12], board[13], board[14], board[15], board[16] });
		}
	}

	private void LocalPattern6(int local, int[] board) {
		if (local == 0 || local == 1 || local == 2 || local == 3 || local == 5 || local == 6 || local == 7
				|| local == 10 || local == 11 || local == 12 || local == 13) {
			pastMove = board[4];
			putMap(2, new int[] { board[8], board[9] });
		} else if (local == 9 || local == 8 || local == 4) {
			pastMove = board[2];
			putMap(2, new int[] { board[0], board[1] });
			putMap(13,
					new int[] { board[3], board[5], board[6], board[7], board[10], board[11], board[12], board[13] });
		}
	}

	private void LocalPattern7(int local, int[] board) {
		if (local == 0 || local == 1 || local == 2 || local == 3 || local == 6 || local == 7 || local == 8
				|| local == 10 || local == 11 || local == 12 || local == 13) {
			pastMove = board[9];
			putMap(2, new int[] { board[4], board[5] });
		} else if (local == 9 || local == 5 || local == 4) {
			pastMove = board[2];
			putMap(2, new int[] { board[0], board[1] });
			putMap(13,
					new int[] { board[3], board[6], board[7], board[8], board[10], board[11], board[12], board[13] });
		}
	}

	private void LocalPattern8(int local, int[] board) {
		if (local == 0 || local == 3 || local == 4 || local == 5 || local == 7 || local == 8 || local == 9
				|| local == 10 || local == 13 || local == 14 || local == 15) {
			pastMove = board[6];
			putMap(2, new int[] { board[1], board[2] });
			putMap(2, new int[] { board[11], board[12] });
		} else if (local == 1 || local == 6 || local == 11) {
			pastMove = board[3];
			putMap(2, new int[] { board[0], board[2] });
			putMap(13,
					new int[] { board[4], board[7], board[8], board[9], board[12], board[13], board[14], board[15] });
		} else if (local == 12) {
			pastMove = board[5];
			putMap(2, new int[] { board[10], board[11] });
			putMap(9, new int[] { board[1], board[2], board[3], board[6], board[7], board[8], board[13], board[14] });
		} else if (local == 2) {
			pastMove = board[1];
			putMap(17, new int[] { board[0], board[3], board[4], board[5], board[6], board[7], board[8], board[10],
					board[11], board[12], board[13], board[14] });
		}
	}

	private void LocalPattern9(int local, int[] board) {
		if(local == 1 || local == 2 || local == 3 || local == 4 || local == 5 || local == 6 || local == 7){
			pastMove = board[0];
		} else if(local == 0){
			pastMove = board[1];
			putMap(18, new int[]{board[2], board[3], board[4], board[5], board[6], board[7]});
		}
	}

	private void LocalPattern10(int local, int[] board) {
		if(local == 0 || local == 1 || local == 2 || local == 5 || local == 6 || local == 7 || local == 9 || local == 10 || local == 11 || local == 12 || local == 15 || local == 16 || local == 17 ){
			pastMove = board[8];
			putMap(2, new int[]{board[3], board[4]});
			putMap(2, new int[]{board[13], board[14]});
		} else if(local == 3 || local == 8 || local == 13 ){
			pastMove = board[5];
			putMap(2, new int[]{board[1], board[4]});
			putMap(13, new int[]{board[6], board[9], board[10], board[11], board[14], board[15], board[16], board[17]});
		} else if(local == 14){
			pastMove = board[7];
			putMap(2, new int[]{board[12], board[13]});
			putMap(9, new int[]{board[3], board[4], board[5], board[8], board[9], board[10], board[15], board[16]});
		} else if(local == 4 ){
			pastMove = board[3];
			putMap(19, new int[]{board[0], board[1], board[2], board[5], board[6], board[7], board[8], board[9], board[10], board[12], board[13], board[14], board[15], board[16]});
		}
	}

	private void LocalPattern11(int local, int[] board) {
		if (local == 0 || local == 1 || local == 2 || local == 4 || local == 5 || local == 6 || local == 9
				|| local == 10 || local == 11 || local == 13 || local == 14 || local == 17 || local == 18
				|| local == 24) {
			pastMove = board[3];
			putMap(2, new int[] { board[7], board[8] });
			putMap(5,
					new int[] { board[12], board[15], board[16], board[19], board[20], board[21], board[22], board[25],
							board[26], board[27], board[28], board[29], board[31], board[32], board[33], board[34],
							board[35], board[36] });
		} else if (local == 7) {
			pastMove = board[8];
			putMap(2, new int[] { board[3], board[4] });
			putMap(5,
					new int[] { board[12], board[15], board[16], board[19], board[20], board[21], board[22], board[25],
							board[26], board[27], board[28], board[29], board[31], board[32], board[33], board[34],
							board[35], board[36] });
		} else if (local == 8) {
			pastMove = board[7];
			putMap(2, new int[] { board[2], board[3] });
			putMap(5,
					new int[] { board[12], board[15], board[16], board[19], board[20], board[21], board[22], board[25],
							board[26], board[27], board[28], board[29], board[31], board[32], board[33], board[34],
							board[35], board[36] });
		} else if (local == 12 || local == 15 || local == 16 || local == 21 || local == 22 || local == 23 || local == 27
				|| local == 28 || local == 29 || local == 30 || local == 34 || local == 35 || local == 36
				|| local == 37) {
			pastMove = board[26];
			putMap(2, new int[] { board[19], board[20] });
			putMap(2, new int[] { board[32], board[33] });
			putMap(14,
					new int[] { board[31], board[25], board[24], board[18], board[17], board[14], board[13], board[11],
							board[10], board[8], board[7], board[6], board[5], board[4], board[3], board[2], board[1],
							board[0] });
		} else if (local == 25 || local == 31) {
			pastMove = board[19];
			putMap(4, new int[] { board[15], board[20], board[21], board[22], board[26], board[27], board[28],
					board[29], board[32], board[33], board[34], board[35], board[36] });
			putMap(16, new int[] { board[18], board[14], board[13], board[11], board[10], board[8], board[7], board[6],
					board[5], board[4], board[3], board[2], board[1], board[0] });
		} else if (local == 32) {
			pastMove = board[18];
			putMap(2, new int[] { board[14], board[19] });
			putMap(17, new int[] { board[13], board[11], board[10], board[8], board[7], board[6], board[5], board[4],
					board[3], board[2], board[1], board[0] });
			putMap(7, new int[] { board[15], board[20], board[21], board[22], board[26], board[27], board[28],
					board[29], board[31], board[33], board[34], board[35], board[36] });
		} else if (local == 33) {
			pastMove = board[25];
			putMap(2, new int[] { board[31], board[32] });
			putMap(9, new int[] { board[19], board[20], board[21], board[26], board[27], board[28], board[34],
					board[35] });
			putMap(17, new int[] { board[13], board[11], board[10], board[8], board[7], board[6], board[5], board[4],
					board[3], board[2], board[1], board[0] });
		} else if (local == 26) {
			pastMove = board[19];
			putMap(6, new int[] { board[15], board[20], board[21], board[22], board[25], board[27], board[28],
					board[29], board[31], board[32], board[33], board[34], board[35], board[36] });
			putMap(16, new int[] { board[18], board[14], board[13], board[11], board[10], board[8], board[7], board[6],
					board[5], board[4], board[3], board[2], board[1], board[0] });
		} else if (local == 20) {
			pastMove = board[19];
			putMap(16, new int[] { board[12], board[15], board[16], board[21], board[22], board[25], board[26],
					board[27], board[28], board[31], board[32], board[33], board[34], board[35] });
			putMap(16, new int[] { board[18], board[14], board[13], board[11], board[10], board[8], board[7], board[6],
					board[5], board[4], board[3], board[2], board[1], board[0] });
		} else if (local == 19) {
			pastMove = board[20];
			putMap(20,
					new int[] { board[0], board[1], board[2], board[3], board[4], board[5], board[6], board[7],
							board[8], board[9], board[10], board[11], board[12], board[13], board[14], board[15],
							board[16], board[17], board[18], board[21], board[22], board[23], board[24], board[25],
							board[26], board[27], board[28], board[29], board[30], board[31], board[32], board[33],
							board[34], board[35], board[36], board[37] });
		} else if (local == 3) {
			pastMove = board[7];
			putMap(35, new int[] { board[0], board[1], board[2], board[5], board[6], board[10], board[11], board[12],
					board[13], board[14], board[15], board[16], board[17], board[18], board[19], board[20], board[21],
					board[22], board[23], board[24], board[25], board[26], board[27], board[28], board[29], board[30],
					board[31], board[32], board[33], board[34], board[35], board[36], board[37] });
		} else {
		}
	}

	private void LocalPattern12(int local, int[] board) {
	}

	private void LocalPattern13(int local, int[] board) {
	}

	private void LocalPattern14(int local, int[] board) {
	}

	private void LocalPattern15(int local, int[] board) {
	}

	private void LocalPattern16(int local, int[] board) {
	}

	private void LocalPattern17(int local, int[] board) {
	}

	private void LocalPattern18(int local, int[] board) {
	}

	private void LocalPattern19(int local, int[] board) {
	}

	private void LocalPattern20(int local, int[] board) {
	}

	private void LocalPattern21(int local, int[] board) {
	}

	private void LocalPattern22(int local, int[] board) {
	}

	private void LocalPattern23(int local, int[] board) {
	}

	private void LocalPattern24(int local, int[] board) {
	}

	private void LocalPattern25(int local, int[] board) {
	}

	private void LocalPattern26(int local, int[] board) {
	}

	private void LocalPattern27(int local, int[] board) {
	}

	private void LocalPattern28(int local, int[] board) {
	}

	private void LocalPattern29(int local, int[] board) {
	}

	private void LocalPattern30(int local, int[] board) {
	}

	private void LocalPattern31(int local, int[] board) {
	}

	private void LocalPattern32(int local, int[] board) {
	}

	private void LocalPattern33(int local, int[] board) {
	}

	private void LocalPattern34(int local, int[] board) {
	}

	private void LocalPattern35(int local, int[] board) {
	}

	private void LocalPattern36(int local, int[] board) {
	}

	private void LocalPattern37(int local, int[] board) {
	}

	private void LocalPattern38(int local, int[] board) {
	}

	private void LocalPattern39(int local, int[] board) {
	}

	private void LocalPattern40(int local, int[] board) {
	}

	private void LocalPattern41(int local, int[] board) {
	}

	private void putMap(int board, int[] change) {
		for (int i = 0; i < change.length; i++) {
			chesses[change[i]].board = board;
			chesses[change[i]].index = mapKey;
			chesses[change[i]].iLocal = i;
		}
		map.put(mapKey++, change);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		 LocalPattern lp = new LocalPattern(true);
		 while(true){
			 System.out.println(lp.moveIn(input.nextInt()));
		 }
//		StringBuffer str = new StringBuffer(input.nextLine());
//		Pattern pattern = Pattern.compile("\\d+");
//		Matcher matcher = pattern.matcher(str);
//		if (input.nextInt() == 1) {
//			while (matcher.find()) {
//				System.out.print("local == " + (Integer.parseInt(matcher.group()) - 1) + " || ");
//			}
//		} else {
//			System.out.print("new int[]{");
//			while (matcher.find()) {
//				System.out.print("board[" + (Integer.parseInt(matcher.group()) - 1) + "], ");
//			}
//		}
//		System.out.println();
//		input.close();
	}
}
