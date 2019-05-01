package tank;

import java.awt.Frame;

import tank.common.CommonUtil;
import tank.common.WindowListener;

public class TankFrame extends Frame {

	TankFrame() {
		setSize(CommonUtil.GAME_WIDTH, CommonUtil.GAME_HEIGHT);
		setResizable(false);
		setTitle("筱士巍巍的坦克大战");
		setVisible(true);
		
		
		addWindowListener(new WindowListener());
	}
}
