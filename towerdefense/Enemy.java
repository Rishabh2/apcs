package towerdefense;

import apcs.Window;

public class Enemy {
	private int x;

	private int y;

	private int size;

	private int speed;

	private Space space;

	private World world;

	public Enemy(int size, int speed, World world) {
		this.size = size;
		this.speed = speed;
		this.world = world;
		this.space = world.getStart();
		this.x = space.getAbsoluteX();
		this.y = space.getAbsoluteY();
	}

	/**
	 * Get the x coordinate of the enemy
	 * 
	 * @return the x coordinate of the enemy
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the y coordinate of the enemy
	 * 
	 * @return the y coordinate of the enemy
	 * */
	public int getY() {
		return y;
	}

	/**
	 * Get the size of the enemy
	 * 
	 * @return the size of the enemy
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Get the speed of the enemy
	 * 
	 * @return the speed of the enemy
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Move the enemy along its path
	 * 
	 * @return true if the enemy has reached the end, false otherwise
	 */
	public boolean move() {
		Space next = space.getNext();
		int dx = next.getX() - space.getX();
		int dy = next.getY() - space.getY();
		if (dx > 0) {
			x = x + speed;
		} else if (dx < 0) {
			x = x - speed;
		}
		if (dy > 0) {
			y = y + speed;
		} else if (dy < 0) {
			y = y - speed;
		}
		if (Math.abs(x - next.getAbsoluteX()) <= 3
				&& Math.abs(y - next.getAbsoluteY()) <= 3) {
			x = next.getAbsoluteX();
			y = next.getAbsoluteY();
			space = next;
		}
		return space == world.getEnd();
	}

	public void draw() {
		Window.out.color("red");
		Window.out.circle(x, y, size);
	}
}