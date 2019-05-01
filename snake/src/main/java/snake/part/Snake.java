package snake.part;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Random;

import snake.common.Dir;
import snake.common.ResourceMgr;

public class Snake extends Part{
	private String name = "Snake";
	private int x;
	private int y;
	private boolean moving = true;
	private Dir dir = Dir.DOWN;

	private Rectangle rectangle;
	
	Random random = new Random();
	
	public Snake(int x, int y, Dir dir, Boolean moving) {
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.moving = moving;
		
		rectangle = new Rectangle(x, y, ResourceMgr.SNAKE_WIDTH, ResourceMgr.SNAKE_HEIGHT);
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
	
	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	

	

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		
		for(Iterator<Snake> it = ResourceMgr.SNAKE_LIST.iterator(); it.hasNext();) {
			Snake snakeTemp = it.next();
			g.fillRect(snakeTemp.getX(), snakeTemp.getY(), 10, 10);
		}
		
		g.setColor(c);
		
		move();
	}
	
	/**
	 * 坦克的移动
	 */
	private void move() {
		int xTemp = this.x;
		int yTemp = this.y;
		
		for(int i = 0; i < ResourceMgr.SNAKE_LIST.size(); i++) {
			Snake snakeTemp = ResourceMgr.SNAKE_LIST.get(i);
			
			if(i == 0) {
				xTemp = snakeTemp.getX();
				yTemp = snakeTemp.getY();
				
				switch (dir) {
				case LEFT:
					x = x - ResourceMgr.SNAKE_SPEED;
					break;
				case UP:
					y = y - ResourceMgr.SNAKE_SPEED;
					break;
				case RIGHT:
					x = x + ResourceMgr.SNAKE_SPEED;
					break;
				case DOWN:
					y = y + ResourceMgr.SNAKE_SPEED;
					break;
				}
			} else {
				int xx = xTemp;
				int yy = yTemp;
				
				xTemp = snakeTemp.getX();
				yTemp = snakeTemp.getY();
				
				snakeTemp.setX(xx);
				snakeTemp.setY(yy);
			}
		}
		
		
//		for() {
//			if(!moving) return ;
//			
//			switch (dir) {
//			case LEFT:
//				x -= SPEED;
//				break;
//			case UP:
//				y -= SPEED;
//				break;
//			case RIGHT:
//				x += SPEED;
//				break;
//			case DOWN:
//				y += SPEED;
//				break;
//			}
//		}
	}
	
	/**
	 * 碰撞检测
	 * @param tank
	 */
	public void collideWith(Snake tank) {

	}
	
	/**
	 * 消亡事件
	 */
	@Override
	public void die() {
//		this.living = false;
	}
}
