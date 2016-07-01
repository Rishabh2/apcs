package towerdefense;

import java.util.Comparator;

public class CloseComparator implements Comparator<Enemy> {

	private Tower tower;

	public CloseComparator(Tower tower) {
		this.tower = tower;
	}

	@Override
	public int compare(Enemy o1, Enemy o2) {
		int dx1 = o1.getX() - tower.getX();
		int dy1 = o1.getY() - tower.getY();
		double dist1 = Math.sqrt(dx1 * dx1 + dy1 * dy1);

		int dx2 = o2.getX() - tower.getX();
		int dy2 = o2.getY() - tower.getY();
		double dist2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);

		return (int) (dist1 - dist2);
	}

}
