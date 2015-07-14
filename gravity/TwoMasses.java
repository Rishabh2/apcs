package gravity;

import apcs.Window;

public class TwoMasses {

	
	public static void main(String[] args) {
		Window.size(800, 600);
		Window.setFrameRate(30);
		
		Mass m1 = new Mass(300, 300, 1000, "red");
		m1.setRadius(20);
		Mass m2 = new Mass(500, 300, 1000, "blue");
		m2.setRadius(20);
		
		while (true) {
			Window.out.background("black");
			
			m1.draw();
			m2.draw();
			
			if (! m1.isTouching(m2)) {
				m1.accelerate(m1.gravitationalForce(m2));
				m2.accelerate(m2.gravitationalForce(m1));
			}
			
			m1.move();
			m2.move();
			
			Window.frame();
		}
	}
	
	private static void manyMassesWithNormalForce() {
		Window.size(1000, 800);
		Window.setFrameRate(30);
		
		Mass m1 = new Mass(350, 200, 10, "red");
		Mass m2 = new Mass(450, 400, 20, "blue");
		Mass m3 = new Mass(500, 500, 50, "yellow");
		Mass m4 = new Mass(250, 300, 10, "red");
		
		Mass[] massList = new Mass[] { m3, m1, m2, m4 };
		
		while (true) {
			Window.out.background("black");
			
			for (Mass m : massList) {
				m.draw();
			}
			
			for (Mass m : massList) {
				Vector netForce = new Vector(0, 0);
				for (Mass other : massList) {
					if (m != other) {
						if (! m.isTouching(other)) {
							netForce.add(m.gravitationalForce(other));
						}
					}
				}
				m.accelerate(netForce);
			}
			
			for (Mass m : massList) {
				m.move();
			}
			
			Window.frame();
		}
	}

	public static void twoMasses() {
	}
	
	public static void manyMasses() {
		Window.size(1000, 800);
		Window.setFrameRate(30);
		
		Mass m1 = new Mass(350, 200);
		Mass m2 = new Mass(450, 400);
		Mass m3 = new Mass(500, 500, 50);
		Mass m4 = new Mass(250, 300);
		
		Mass[] massList = new Mass[] { m1, m2, m3, m4 };
		
		while (true) {
			Window.out.background("black");
			
			for (Mass m : massList) {
				m.draw();
			}
			
			for (Mass m : massList) {
				Vector netForce = new Vector(0, 0);
				for (Mass other : massList) {
					if (m != other) {
						netForce.add(m.gravitationalForce(other));
					}
				}
				m.accelerate(netForce);
			}
			
			for (Mass m : massList) {
				m.move();
			}
			
			Window.frame();
		}
	}
}
