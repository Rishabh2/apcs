package towerdefense;

import apcs.Window;

public class Bullet {
	private int x;

	private int y;

	private int dx;

	private int dy;

	/**
	 * @param x
	 *            the x coordinate of the bullet
	 * @param y
	 *            the y coordinate of the bullet
	 * @param dx
	 *            the x speed of the bullet
	 * @param dy
	 *            the y speed of the bullet
	 */
	public Bullet(int x, int y, int dx, int dy) {
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
	}

	public Bullet(Tower tower, Enemy enemy) {
		this.x = tower.getX();
		this.y = tower.getY();
		this.dx = enemy.getX() - x;
		this.dy = enemy.getY() - y;
		int magnitude = (int) Math.sqrt(dx * dx + dy * dy);
		this.dx = 5 * this.dx / magnitude;
		this.dy = 5 * this.dy / magnitude;
	}

	/**
	 * Draw the bullet to the Window
	 */
	public void draw() {
		Window.out.color("green");
		Window.out.circle(x, y, 5);
	}

	/**
	 * Move the bullet
	 */
	public void move() {
		x += dx;
		y += dy;
	}

	/**
	 * Return whether the bullet is hitting an enemy
	 * 
	 * @param enemy
	 *            the enemy
	 * @return whether the bullet is hitting the enemy
	 */
	public boolean isHitting(Enemy enemy) {
		return Math.sqrt(Math.pow(enemy.getX() - x, 2)
				+ Math.pow(enemy.getY() - y, 2)) < enemy.getSize() + 10;
	}

}