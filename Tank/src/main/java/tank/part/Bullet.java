package tank.part;

import java.awt.Graphics;

import tank.common.Dir;
import tank.common.ResourceMgr;

public class Bullet {
	private int x;
	private int y;
	private Dir dir;
	
	public Bullet(int x, int y, Dir dir) {
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
	
	
	/**
	 * 画出子弹
	 * @param g
	 */
	public void paint(Graphics g) {
		switch(dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		}
		
		move();
	}
	
	/**
	 * 子弹的移动
	 */
	private void move() {
		switch(dir) {
		case LEFT:
			x -= ResourceMgr.BULLET_SPEED;
			break;
		case UP:
			y -= ResourceMgr.BULLET_SPEED;;
			break;
		case RIGHT:
			x += ResourceMgr.BULLET_SPEED;;
			break;
		case DOWN:
			y += ResourceMgr.BULLET_SPEED;;
			break;
		}
	}
}
