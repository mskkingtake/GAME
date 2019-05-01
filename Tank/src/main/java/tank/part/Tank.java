package tank.part;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import tank.common.CommonUtil;
import tank.common.Dir;
import tank.common.Group;
import tank.common.ResourceMgr;

public class Tank extends Part{
	private String name = "Tank";
	private int x;
	private int y;
	private boolean moving = false;
	private Dir dir = Dir.DOWN;
	private boolean living = true;
	private boolean dirChangeFlag = false;
	private Group group;
	private Rectangle rectangle;
	private int fireTime = 1000;
	
	Random random = new Random();
	
	public Tank(int x, int y, Dir dir, Boolean moving, Group group) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.moving = moving;
		this.group = group;
		
		rectangle = new Rectangle(x, y, ResourceMgr.TANK_WIDTH, ResourceMgr.TANK_HEIGHT);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}
	
	

	

	public void paint(Graphics g) {
		if(!living) {
			ResourceMgr.TANK_LIST.remove(this);
		}
		
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
		
		if(this == ResourceMgr.myTank) {
			Color c = g.getColor();
			g.setColor(Color.WHITE);
			g.drawString("我的坦克", x , y);
			g.setColor(c);
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
			if(x - ResourceMgr.TANK_SPEED < 0) {
				x = 0;
				dirChangeFlag = true;
			} else {
				x -= ResourceMgr.TANK_SPEED;
			}
			break;
		case UP:
			if(y - ResourceMgr.TANK_SPEED < 20) {
				y = 20;
				dirChangeFlag = true;
			} else {
				y -= ResourceMgr.TANK_SPEED;
			}
			break;
		case RIGHT:
			if(x + ResourceMgr.TANK_SPEED + ResourceMgr.TANK_WIDTH > ResourceMgr.GAME_WIDTH) {
				x = ResourceMgr.GAME_WIDTH - ResourceMgr.TANK_WIDTH;
				dirChangeFlag = true;
			} else {
				x += ResourceMgr.TANK_SPEED;
			}
			break;
		case DOWN:
			if(y + ResourceMgr.TANK_SPEED + ResourceMgr.TANK_HEIGHT > ResourceMgr.GAME_HEIGHT) {
				y = ResourceMgr.GAME_HEIGHT - ResourceMgr.TANK_HEIGHT;
				dirChangeFlag = true;
			} else {
				y += ResourceMgr.TANK_SPEED;
			}
			
			break;
		}
		
		// 设置模型
		rectangle.setLocation(x, y);
		
		if(this.group != Group.GOOD) {
			// 变更方向
			if(dirChangeFlag) {
				this.dir = Dir.randomDir();
				dirChangeFlag = false;
			} else {
				if(CommonUtil.getRandomInt(1000) > 920) {
					this.dir = Dir.randomDir();
				}
			}
			
			// 随机开火
			fireTime = fireTime + 7;
			if(CommonUtil.getRandomInt(fireTime) > 900) {
				fire();
				fireTime = fireTime - 150;
			}
		}
	}
	
	/**
	 * 坦克发射炮弹方法
	 */
	public void fire() {
		if(!this.living) {
			return;
		}
		
		int xTemp = this.x;
		int yTemp = this.y;
		
		switch (dir) {
		case LEFT:
			yTemp = yTemp + ResourceMgr.TANK_HEIGHT / 2 - 3;
			break;
		case UP:
			xTemp = xTemp + ResourceMgr.TANK_WIDTH / 2 - 5;
			break;
		case RIGHT:
			xTemp = xTemp + ResourceMgr.TANK_WIDTH - 7;
			yTemp = yTemp + ResourceMgr.TANK_HEIGHT / 2 - 2;
			break;
		case DOWN:
			xTemp = xTemp + ResourceMgr.TANK_WIDTH / 2 - 6;
			yTemp = yTemp + ResourceMgr.TANK_HEIGHT - 8;
			break;
		}
		
		ResourceMgr.BULLET_LIST.add(new Bullet(xTemp, yTemp, this.dir, this.group));
	}
	
	/**
	 * 碰撞检测
	 * @param tank
	 */
	public void collideWith(Tank tank) {
		if(this == ResourceMgr.myTank || tank == ResourceMgr.myTank) {
			return;
		}
		
		if (this.getRectangle().intersects(tank.getRectangle())) {
			if(this.group != Group.GOOD) {
				// 变更方向
				Dir randomDir = Dir.randomDir();
				if(this.dir != randomDir && tank.dir == randomDir) {
					this.dir = randomDir;
				}
				
				tank.setDir(Dir.getNegativeDir(this.dir));
			}
		}
	}
	
	/**
	 * 消亡事件
	 */
	@Override
	public void die() {
		this.living = false;
	}
}
