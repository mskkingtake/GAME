package snake;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import snake.common.CommonUtil;
import snake.common.Dir;
import snake.common.KeyListener;
import snake.common.ResourceMgr;
import snake.common.WindowListener;
import snake.part.Snake;

public class SnakeFrame extends Frame {
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	
	// 贪吃蛇-蛇头
	Snake mySnake = new Snake(200, 200, Dir.LEFT, true);
	
	// 临时变量
	int x;
	int y;
	
	Image offScreenImage = null;
	
	SnakeFrame() {
		// 初始化窗口
		setLocation(600, 100);
		setSize(ResourceMgr.GAME_WIDTH, ResourceMgr.GAME_HEIGHT);
		setResizable(false);
		setTitle("筱士巍巍的贪吃蛇");
		setVisible(true);
		
		ResourceMgr.mySnake = this.mySnake;
		
		// 设置贪吃蛇头部
		ResourceMgr.SNAKE_LIST.add(mySnake);
		
		// 初始化碎块
		for(int i = 0; i < ResourceMgr.SNAKE_PART_COUNT; i++) {
			x = CommonUtil.getRandomInt(55) * 10 + 50;
			y = CommonUtil.getRandomInt(70) * 10 + 50;
			ResourceMgr.SNAKE_PART_LIST.add(new Snake(x,y, Dir.LEFT, true));
		}
		
		// 初始化贪吃蛇
		for(int i = 1; i < ResourceMgr.SNAKE_INIT_COUNT; i++) {
			x = mySnake.getX() + ResourceMgr.SNAKE_WIDTH * i;
			y = mySnake.getY();
			ResourceMgr.SNAKE_LIST.add(new Snake(x,y, Dir.LEFT, true));
		}
		
		// 窗口监听器
		addWindowListener(new WindowListener());
		
		// 按键监听器
		addKeyListener(new KeyListener(mySnake));
	}
	
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(ResourceMgr.GAME_WIDTH, ResourceMgr.GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, ResourceMgr.GAME_WIDTH, ResourceMgr.GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
		// 显示文字信息
		Color c = g.getColor();
		
		// 游戏结束
		if(!ResourceMgr.mySnake.isLiving()) {
			g.setColor(Color.WHITE);
			g.drawString("本局贪吃蛇长度:" + ResourceMgr.SNAKE_LIST.size(), 200, 300);
			g.drawString("回车键再来一次", 200, 400);
			g.setColor(c);
			return;
		}
		
		//左上角文字信息
		g.setColor(Color.WHITE);
		g.drawString("贪吃蛇长度:" + ResourceMgr.SNAKE_LIST.size(), 10, 60);
		g.setColor(c);
		
		mySnake.paint(g);
	}
}
