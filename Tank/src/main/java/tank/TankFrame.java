package tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import tank.common.Dir;
import tank.common.Group;
import tank.common.KeyListener;
import tank.common.ResourceMgr;
import tank.common.WindowListener;
import tank.part.Bullet;
import tank.part.Tank;

public class TankFrame extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 我的坦克
	Tank myTank = new Tank(100,100, Dir.LEFT, false, Group.GOOD);
	
	Image offScreenImage = null;
	
	TankFrame() {
		setLocation(600, 100);
		setSize(ResourceMgr.GAME_WIDTH, ResourceMgr.GAME_HEIGHT);
		setResizable(false);
		setTitle("筱士巍巍的坦克大战");
		setVisible(true);
		
		ResourceMgr.myTank = myTank;
		ResourceMgr.TANK_LIST.add(myTank);
		
		// 窗口监听器
		addWindowListener(new WindowListener());
		
		// 按键监听器
		addKeyListener(new KeyListener(myTank));
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
		if(!ResourceMgr.TANK_LIST.contains(myTank)) {
			ResourceMgr.fpsCount--;
		}
		
		if(ResourceMgr.fpsCount <= 0) {
			Color c = g.getColor();
			g.setColor(Color.WHITE);
			g.drawString("消灭敌人数:" + ResourceMgr.countNumber, 200, 300);
			g.drawString("再接再厉,今晚吃鸡:", 200, 350);
			g.drawString("回车键再来一次", 200, 400);
			g.setColor(c);
			return;
		}
		
		while(ResourceMgr.TANK_LIST.size() < ResourceMgr.tankNumber) {
			int x = (int)(Math.random() * 800);
			int y = (int)(Math.random() * 600);
			ResourceMgr.TANK_LIST.add(new Tank(x, y, Dir.randomDir(), true, Group.BAD));
		}
		
		for(Iterator<Bullet> it1 = ResourceMgr.BULLET_LIST.iterator(); it1.hasNext();) {
			Bullet b1 = it1.next();
			
			for(Iterator<Bullet> it2 = ResourceMgr.BULLET_LIST.iterator(); it2.hasNext();) {
				Bullet b2 = it2.next();
				if(b1 != b2) {
					b1.collideWith(b2);
				}
			}
			
			for(Iterator<Tank> it2 = ResourceMgr.TANK_LIST.iterator(); it2.hasNext();) {
				Tank b2 = it2.next();
				b1.collideWith(b2);
			}
		}
		
		for(Iterator<Tank> it1 = ResourceMgr.TANK_LIST.iterator(); it1.hasNext();) {
			Tank t1 = it1.next();
			
			for(Iterator<Tank> it2 = ResourceMgr.TANK_LIST.iterator(); it2.hasNext();) {
				Tank t2 = it2.next();
				if(t1 != t2) {
					t1.collideWith(t2);
				}
			}
		}
		
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量:" + ResourceMgr.BULLET_LIST.size(), 10, 60);
		g.drawString("敌人的数量:" + ResourceMgr.TANK_LIST.size(), 10, 80);
		g.drawString("消灭敌人数:" + ResourceMgr.countNumber, 10, 100);
		g.setColor(c);
		
		// 画子弹
		for(int i = 0; i < ResourceMgr.BULLET_LIST.size(); i++) {
			ResourceMgr.BULLET_LIST.get(i).paint(g);
		}
		
		// 画坦克
		for(int i = 0; i < ResourceMgr.TANK_LIST.size(); i++) {
			ResourceMgr.TANK_LIST.get(i).paint(g);
		}
		
		// 画坦克
		for(int i = 0; i < ResourceMgr.EXPLODE_LIST.size(); i++) {
			ResourceMgr.EXPLODE_LIST.get(i).paint(g);
		}
	}
}
