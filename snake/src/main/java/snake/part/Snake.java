package snake.part;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Random;

import snake.common.CommonUtil;
import snake.common.Dir;
import snake.common.ResourceMgr;

public class Snake extends Part{
	private String name = "Snake";
	private int x;
	private int y;
	private boolean moving = true;
	private boolean living = true;
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
	
	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		if(this == ResourceMgr.mySnake) {
			switch (dir) {
			case LEFT:
				g.drawString("贪吃蛇", x - ResourceMgr.SNAKE_WIDTH , y);
				break;
			case UP:
				g.drawString("贪吃蛇", x - ResourceMgr.SNAKE_WIDTH , y);
				break;
			case RIGHT:
				g.drawString("贪吃蛇", x , y);
				break;
			case DOWN:
				g.drawString("贪吃蛇", x - ResourceMgr.SNAKE_WIDTH , y + ResourceMgr.SNAKE_HEIGHT * 2);
				break;
			}
			
		}
		
		Snake snakeTemp;
		
		// 贪吃蛇
		for(Iterator<Snake> it = ResourceMgr.SNAKE_LIST.iterator(); it.hasNext();) {
			snakeTemp = it.next();
			g.fillRect(snakeTemp.getX(), snakeTemp.getY(), ResourceMgr.SNAKE_WIDTH, ResourceMgr.SNAKE_HEIGHT);
		}
		
		// 随机部分
		for(Iterator<Snake> it = ResourceMgr.SNAKE_PART_LIST.iterator(); it.hasNext();) {
			snakeTemp = it.next();
			g.fillRect(snakeTemp.getX(), snakeTemp.getY(), ResourceMgr.SNAKE_WIDTH, ResourceMgr.SNAKE_HEIGHT);
		}
		
		g.setColor(c);
		
		move();
	}
	
	/**
	 * 贪吃蛇的移动
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
				
				if(x < 0 || 
				   y < 0 + 20 || 
				   x + ResourceMgr.SNAKE_WIDTH > ResourceMgr.GAME_WIDTH || 
				   y + ResourceMgr.SNAKE_HEIGHT > ResourceMgr.GAME_HEIGHT) {
					this.living = false;
				}
				
				this.rectangle.setLocation(x, y);
				
				//  吃碎块
				for(int ii = 0; ii < ResourceMgr.SNAKE_PART_LIST.size(); ii++) {
					Snake snakeTempi = ResourceMgr.SNAKE_PART_LIST.get(ii);
					snakeTemp.collideWith(snakeTempi);
				}
			} else {
				int xx = xTemp;
				int yy = yTemp;
				
				xTemp = snakeTemp.getX();
				yTemp = snakeTemp.getY();
				
				snakeTemp.setX(xx);
				snakeTemp.setY(yy);
				
				this.rectangle.setLocation(xx, yy);
			}
		}
		
		// 蛇身相撞
		for(int j = 0; j < ResourceMgr.SNAKE_LIST.size(); j++) {
			Snake snakeTempj = ResourceMgr.SNAKE_LIST.get(j);
			if(snakeTempj == ResourceMgr.mySnake) {
				continue;
			}
			
			if(ResourceMgr.mySnake.getX() == snakeTempj.getX() && ResourceMgr.mySnake.getY() == snakeTempj.getY()) {
				ResourceMgr.mySnake.setLiving(false);
			}
		}
	}
	
	/**
	 * 碰撞检测
	 * @param tank
	 */
	public void collideWith(Snake snake) {
		if(this.getRectangle().intersects(snake.getRectangle())) {
			ResourceMgr.SNAKE_PART_LIST.remove(snake);
			ResourceMgr.SNAKE_LIST.add(snake);
			
			int x = CommonUtil.getRandomInt(55) * 10 + 50;
			int y = CommonUtil.getRandomInt(70) * 10 + 50;
			ResourceMgr.SNAKE_PART_LIST.add(new Snake(x,y, Dir.LEFT, true));
		}
	}
}
