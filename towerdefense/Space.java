package towerdefense;

import java.util.ArrayList;

public class Space {

	private int x;

	private int y;

	private int type;

	private Tower tower;

	private Space next;

	private World world;

	/**
	 * @param x
	 *            the x coordinate of the space
	 * @param y
	 *            the y coordinate of the space
	 * @param type
	 *            the type of the space
	 */
	public Space(int x, int y, World world) {
		this.x = x;
		this.y = y;
		this.tower = null;
		this.world = world;
	}

	public Space[] neighbors() {
		ArrayList<Space> spaces = new ArrayList<Space>();

		if (x > 0 && !world.getSpace(x - 1, y).isGrass()) {
			spaces.add(world.getSpace(x - 1, y));
		}
		if (x + 1 < world.getWidth() && !world.getSpace(x + 1, y).isGrass()) {
			spaces.add(world.getSpace(x + 1, y));
		}
		if (y > 0 && !world.getSpace(x, y - 1).isGrass()) {
			spaces.add(world.getSpace(x, y - 1));
		}
		if (y + 1 < world.getHeight() && !world.getSpace(x, y + 1).isGrass()) {
			spaces.add(world.getSpace(x, y + 1));
		}

		return spaces.toArray(new Space[spaces.size()]);
	}

	public boolean isGrass() {
		return type == world.GRASS;
	}

	/**
	 * Set the type of the space
	 * 
	 * @param type
	 *            the type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * Get the type of the space
	 * 
	 * @return the type of the space
	 */
	public int getType() {
		return type;
	}

	/**
	 * Get the x coordinate of the space
	 * 
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the y coordinate of the space
	 * 
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set this space's tower
	 * 
	 * @param tower
	 *            the tower
	 */
	public void setTower(Tower tower) {
		this.tower = tower;
	}

	/**
	 * Check if the space has a tower
	 * 
	 * @return if the space has a tower
	 */
	public boolean hasTower() {
		return tower != null;
	}

	/**
	 * Get the tower in this space
	 * 
	 * @return the tower
	 */
	public Tower getTower() {
		return tower;
	}

	/**
	 * @return the next
	 */
	public Space getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Space next) {
		this.next = next;
	}

	public int getAbsoluteX() {
		return x * world.getScale() + world.getScale() / 2;
	}

	public int getAbsoluteY() {
		return y * world.getScale() + world.getScale() / 2;
	}
}