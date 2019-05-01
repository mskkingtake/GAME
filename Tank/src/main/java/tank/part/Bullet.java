package tank.part;

import java.awt.Graphics;
import java.awt.Rectangle;

import tank.common.Dir;
import tank.common.Group;
import tank.common.ResourceMgr;

public class Bullet {
	private int x;
	private int y;
	private Dir dir;
	private boolean living = true;
	private Group group;
	private Rectangle rectangle;

	public Bullet(int x, int y, Dir dir, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group = group;
		
		rectangle = new Rectangle(x, y, ResourceMgr.BULLET_WIDTH, ResourceMgr.BULLET_HEIGHT);
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

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	
	
	
	/**
	 * 画出子弹
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		if (!living) {
			ResourceMgr.BULLET_LIST.remove(this);
		}

		switch (dir) {
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
		switch (dir) {
		case LEFT:
			x -= ResourceMgr.BULLET_SPEED;
			break;
		case UP:
			y -= ResourceMgr.BULLET_SPEED;
			;
			break;
		case RIGHT:
			x += ResourceMgr.BULLET_SPEED;
			;
			break;
		case DOWN:
			y += ResourceMgr.BULLET_SPEED;
			;
			break;
		}
		
		// 设置模型
		rectangle.setLocation(x, y);
		
		// 判断子弹是否移动出画面
		if (x < 0 || y < 0 || x > ResourceMgr.GAME_WIDTH || y > ResourceMgr.GAME_HEIGHT) {
			living = false;
		}
	}

	/**
	 * 碰撞检测
	 * @param tank
	 */
	public void collideWith(Tank tank) {
		if (this.group == tank.getGroup()) {
			return;
		}

		if (this.getRectangle().intersects(tank.getRectangle())) {
			tank.die();
			this.die();
		}
	}
	
	/**
	 * 消亡事件
	 */
	private void die() {
		this.living = false;
	}
}
