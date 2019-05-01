package tank.part;

import java.awt.Graphics;
import java.util.Random;

import tank.common.ResourceMgr;
import tank.common.Dir;

public class Tank {
	private int x;
	private int y;
	private boolean moving = true;
	private Dir dir = Dir.DOWN;
	
	Random random = new Random();
	
	public Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	
	
	
	

	public void paint(Graphics g) {
		switch(dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD, x, y, null);
			break;
		}
		
		move();
	}
	
	/**
	 * 坦克的移动
	 */
	private void move() {
		if(!moving) {
			return ;
		}
		
		switch (dir) {
		case LEFT:
			x -= ResourceMgr.TANK_SPEED;
			break;
		case UP:
			y -= ResourceMgr.TANK_SPEED;;
			break;
		case RIGHT:
			x += ResourceMgr.TANK_SPEED;;
			break;
		case DOWN:
			y += ResourceMgr.TANK_SPEED;;
			break;
		}
		
		if(random.nextInt(10) > 8) {
			System.out.println("aaa");
//			this.fire();
		}
	}

	
	

	
}
