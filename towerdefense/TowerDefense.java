package towerdefense;

import java.util.ArrayList;

import apcs.Window;

public class TowerDefense {
	public static void main(String[] args) {
		World world = new World("defense");
		ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		ArrayList<Tower> towers = new ArrayList<Tower>();
		ArrayList<Bullet> bullets = new ArrayList<Bullet>();
		while (true) {

			world.draw();

			for (Bullet bullet : bullets) {
				bullet.move(); // TODO
				bullet.draw(); // TODO
			}

			for (int i = 0; i < enemies.size(); i++) {
				Enemy enemy = enemies.get(i);
				enemy.move();
				enemy.draw();

				for (int j = 0; j < bullets.size(); j++) {
					Bullet bullet = bullets.get(j);
					if (bullet.isHitting(enemy)) {
						enemies.remove(i);
						bullets.remove(j);
						i--;
						break;
					}
				}
			}
			if (Window.mouse.clicked()) {
				int x = Window.mouse.getX() / world.getScale();
				int y = Window.mouse.getY() / world.getScale();

				Space space = world.getSpace(x, y);
				String color = "orange";
				int reload = 50;
				int range = world.getScale() * 5;

				if (space.getType() == world.GRASS && space.hasTower() == false) {
					Tower tower = new Tower(space, world, color, reload, range,
							null);
					tower.setComparator(new CloseComparator(tower));
					towers.add(tower);

				}
			}

			for (Tower tower : towers) {
				tower.draw(world.getScale() / 2); // TODO
				Bullet bullet = tower.fire(enemies);
				if (bullet != null) {
					bullets.add(bullet);
				}
			}

			Window.frame();

			if (Window.random(-40, 40) == 0) {
				enemies.add(new Enemy(10, 3, world));
			}

		}
	}
}
