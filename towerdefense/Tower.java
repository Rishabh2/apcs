package towerdefense;

import java.util.ArrayList;
import java.util.Comparator;

import apcs.Window;

public class Tower {
	private int x;

	private int y;

	private String color;

	private Space space;

	private World world;

	private int reload;

	private int reloadCount; // TODO

	private int range;

	private Comparator<Enemy> comparator;

	public Tower(Space space, World world, String color, int reload, int range,
			Comparator<Enemy> comparator) {
		this.setSpace(space);
		this.setX(space.getAbsoluteX());
		this.setY(space.getAbsoluteY());
		this.setColor(color);
		this.setWorld(world);
		this.setReload(reload);
		this.setReloadCount(reload); // TODO
		this.setRange(range);
		this.setComparator(comparator);
	}

	public void draw(int size) {
		Window.out.color(color);
		Window.out.circle(x, y, size);
	}

	/**
	 * 
	 * @param enemies
	 *            the enemies to fire at
	 * @return the bullet to be fired, null if no fire-able enemies
	 */
	public Bullet fire(ArrayList<Enemy> enemies) {
		if (this.getReloadCount() == 0) { // TODO
			this.setReloadCount(this.getReload()); // TODO
			Enemy toShoot = null;
			for (Enemy enemy : enemies) {
				int dx = enemy.getX() - getX();
				int dy = enemy.getY() - getY();
				double dist = Math.sqrt(dx * dx + dy * dy);
				if (dist <= getRange()) {
					// enemy is in range
					if (toShoot == null
							|| getComparator().compare(enemy, toShoot) < 0) {
						toShoot = enemy;
					}
				}
			}
			if (toShoot == null) {
				return null;
			}
			// create a new bullet firing at the enemy
			return new Bullet(this, toShoot);
		}
		this.countDown(); // TODO
		return null;// TODO
	}

	// TODO
	private void countDown() {// TODO
		this.setReloadCount(this.getReloadCount() - 1);// TODO
		// TODO
	}// TODO

	/**
	 * @return the reload
	 */
	public int getReload() {
		return reload;
	}

	/**
	 * @param reload
	 *            the reload to set
	 */
	public void setReload(int reload) {
		this.reload = reload;
	}

	/**
	 * @return the range
	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param range
	 *            the range to set
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * @return the world
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @param world
	 *            the world to set
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	/**
	 * @return the space
	 */
	public Space getSpace() {
		return space;
	}

	/**
	 * @param space
	 *            the space to set
	 */
	public void setSpace(Space space) {
		this.space = space;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the comparator
	 */
	public Comparator<Enemy> getComparator() {
		return comparator;
	}

	/**
	 * @param comparator
	 *            the comparator to set
	 */
	public void setComparator(Comparator<Enemy> comparator) {
		this.comparator = comparator;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the reloadCount
	 */
	public int getReloadCount() {
		return reloadCount;
	}

	/**
	 * @param reloadCount
	 *            the reloadCount to set
	 */
	public void setReloadCount(int reloadCount) {
		this.reloadCount = reloadCount;
	}

}