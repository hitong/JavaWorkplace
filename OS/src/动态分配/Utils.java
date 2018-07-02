package 动态分配;

import java.util.ArrayList;

public class Utils {
	public static boolean apply(ArrayList<Depart> departs, int longth) {
		for (int i = 0; i < departs.size(); i++) {
			Depart tmp = departs.get(i);
			if (tmp.getStatus() == 0) {
				if (tmp.getLongth() > longth) {
					Depart add1 = new Depart(i, tmp.getStart(), longth, 1);
					Depart add2 = new Depart(i + 1, tmp.getStart() + longth, tmp.getLongth() - longth, 0);
					departs.remove(i);
					departs.add(i, add1);
					departs.add(i + 1, add2);
					return true;
				} else if (tmp.getLongth() == longth) {
					tmp.setStatus(1);
					return true;
				}
			}
		}

		return false;
	}

	public static boolean applyWF(ArrayList<Depart> departs, int longth) {
		Depart tmp = null;
		int l = -1;
		for (int i = 0; i < departs.size(); i++) {
			if (departs.get(i).getStatus() == 0 && departs.get(i).getLongth() >= longth) {
				if (tmp == null || departs.get(i).getLongth() < tmp.getLongth()) {
					tmp = departs.get(i);
					l = i;
				}
			}
		}
		if (l == -1) {
			return false;
		}
		Depart add1 = new Depart(longth, 1);
		;
		if (departs.remove(l).getLongth() != longth) {
			Depart add2 = new Depart(tmp.getLongth() - longth, 0);
			departs.add(l, add2);
		}
		departs.add(l, add1);
	
		return true;
	}

	public static void relise(ArrayList<Depart> departs, int num) {
		departs.get(num).setStatus(0);
		if (departs.size() == 0 || departs.size() - 1 < num) {
			return;
		}
		ArrayList<Depart> tmp = new ArrayList<Depart>();
		tmp.add(departs.remove(0));
		for (int i = 0; i < departs.size(); i++) {
			if (tmp.get(tmp.size() - 1).getStatus() == 0) {
				if (departs.get(i).getStatus() == 0) {
					tmp.get(tmp.size() - 1).setLongth(tmp.get(tmp.size() - 1).getLongth() + departs.get(i).getLongth());
				} else {
					tmp.add(departs.get(i));
				}
			} else {
				tmp.add(departs.get(i));
			}
		}
		departs.clear();
		departs.addAll(tmp);
	}
}
