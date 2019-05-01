package tank.part;

import java.awt.Graphics;

public class Tank {
	private int x;
	private int y;
	

	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void paint(Graphics g) {
		g.fillRect(x, y, 50, 50);
	
	}
}
