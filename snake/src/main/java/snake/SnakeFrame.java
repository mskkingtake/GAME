package snake;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import snake.common.Dir;
import snake.common.KeyListener;
import snake.common.ResourceMgr;
import snake.common.WindowListener;
import snake.part.Snake;

public class SnakeFrame extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 我的坦克
	Snake mySnake = new Snake(100, 200, Dir.LEFT, true);
	
	Image offScreenImage = null;
	
	SnakeFrame() {
		setLocation(600, 100);
		setSize(ResourceMgr.GAME_WIDTH, ResourceMgr.GAME_HEIGHT);
		setResizable(false);
		setTitle("筱士巍巍的贪吃蛇");
		setVisible(true);
		
		ResourceMgr.SNAKE_LIST.add(mySnake);
		
		for(int i = 1; i < 20; i++) {
			int x = mySnake.getX() + ResourceMgr.SNAKE_WIDTH * i;
			int y = mySnake.getY();
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
		mySnake.paint(g);
		

	}
}
