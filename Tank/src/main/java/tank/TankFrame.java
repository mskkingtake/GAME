package tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import tank.common.CommonUtil;
import tank.common.KeyListener;
import tank.common.WindowListener;
import tank.part.Tank;

public class TankFrame extends Frame {
	
	// 我的坦克
	Tank myTank = new Tank(100,100);
	
	Image offScreenImage = null;

	TankFrame() {
		setSize(CommonUtil.GAME_WIDTH, CommonUtil.GAME_HEIGHT);
		setResizable(false);
		setTitle("筱士巍巍的坦克大战");
		setVisible(true);
		
		// 窗口监听器
		addWindowListener(new WindowListener());
		
		// 按键监听器
		addKeyListener(new KeyListener(myTank));
	}
	
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(CommonUtil.GAME_WIDTH, CommonUtil.GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, CommonUtil.GAME_WIDTH, CommonUtil.GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		myTank.paint(g);
	}
}
