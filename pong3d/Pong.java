package pong3d;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import apcs.Window;

public class Pong {

	static int x = 400;
	static int y = 300;
	
	static int ox = 400;
	static int oy = 300;
	
	static long newox = 400;
	static long newoy = 300;
	static boolean updating = false;
	
	public static void main(String[] args) {
		Firebase server = new Firebase("https://javagame.firebaseio.com"); 
		
		server.child("p2x").addValueEventListener(new ValueEventListener() {
			public void onCancelled(FirebaseError error) {}

			@Override
			public void onDataChange(DataSnapshot data) {
				if (data.getValue() != null) {
					updating = true;
					newox = (Long) data.getValue();
					updating = false;
				}
			}
		});
		
		server.child("p2y").addValueEventListener(new ValueEventListener() {
			public void onCancelled(FirebaseError error) {}

			@Override
			public void onDataChange(DataSnapshot data) {
				if (data.getValue() != null) {
					updating = true;
					newoy = (Long) data.getValue();
					updating = false;
				}
			}
		});
		
		Window.size(800, 600);
		
		// Ball position and speed
		int bx = 0;
		int by = 0;
		int bz = 500;
		
		int dx = 0;
		int dy = 0;
		int dz = 30;
		
		while (true) {
			drawBackground();
			
			if (! updating) {
				ox = (int) newox;
				oy = (int) newoy;
			}
			drawPaddle(ox, oy, 0.5, "blue");
			drawBall(bx, by, bz);
			drawPaddle(x, y, 1, "red");
			
			x = Window.mouse.getX() - 400;
			y = Window.mouse.getY() - 300;
			
			server.child("p1x").setValue(x);
			server.child("p1y").setValue(y);
			
			bx += dx;
			by += dy;
			bz += dz;
			
			if (bz < 0) {
				bz = 0;
				dz = dz * -1;
				if (Math.abs(bx - x) < 80 && Math.abs(by - y) < 60) {
					dx += (bx - x) / 4;
					dy += (by - y) / 4;
				}
			}
			if (bz > 1000) {
				bz = 1000;
				dz = dz * -1;
			}
			if (bx < -400) {
				bx = -400;
				dx = dx * -1;
			}
			if (bx > 400) {
				bx = 400;
				dx = dx * -1;
			}
			if (by < -300) {
				by = -300;
				dy = dy * -1;
			}
			if (by > 300) {
				by = 300;
				dy = dy * -1;
			}
			
			Window.frame();
		}
		
	}

	private static void drawBall(int x, int y, int z) {
		int displayColor = 255 - z / 10;
		double scale = 1 - z / 2000.0;
		Window.out.color(displayColor, displayColor, displayColor);
		int dist = (int) Math.sqrt(x * x + y * y + z * z);
		Window.out.circle((int) (400 + x * scale), (int) (300 + y * scale), 20 - dist / 66);
	}

	private static void drawPaddle(int x, int y, double scale, String color) {
		int displayX = (int) (400 + x * scale);
		int displayY = (int) (300 + y * scale);
		int displayWidth = (int) (160 * scale);
		int displayHeight = (int) (120 * scale);
		int displayThickness = (int) (8 * scale);
		
		Window.out.color(color);
		Window.out.rectangle(displayX, displayY - displayHeight / 2, displayWidth, displayThickness);
		Window.out.rectangle(displayX, displayY + displayHeight / 2, displayWidth, displayThickness);
		Window.out.rectangle(displayX + displayWidth / 2, displayY, displayThickness, displayHeight + displayThickness);
		Window.out.rectangle(displayX - displayWidth / 2, displayY, displayThickness, displayHeight + displayThickness);
	}

	private static void drawBackground() {
		Window.out.background("black");
		
		Window.out.color("green");
		Window.out.line(0, 0, 200, 150);
		Window.out.line(0, 600, 200, 450);
		Window.out.line(200, 150, 200, 450);
		
		Window.out.line(800, 0, 600, 150);
		Window.out.line(800, 600, 600, 450);
		Window.out.line(600, 150, 600, 450);
		
		Window.out.line(200, 150, 600, 150);
		Window.out.line(200, 450, 600, 450);
	}

}
