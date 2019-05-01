package tank;

import java.awt.Frame;
import java.awt.Graphics;

import tank.common.CommonUtil;
import tank.common.WindowListener;
import tank.part.Tank;

public class TankFrame extends Frame {

	TankFrame() {
		setSize(CommonUtil.GAME_WIDTH, CommonUtil.GAME_HEIGHT);
		setResizable(false);
		setTitle("筱士巍巍的坦克大战");
		setVisible(true);
		
		
		addWindowListener(new WindowListener());
	}
	
	Tank myTank = new Tank(100,100);
	
	
	@Override
	public void paint(Graphics g) {
		myTank.paint(g);
	}
}
