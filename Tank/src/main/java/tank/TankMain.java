package tank;

import tank.common.Dir;
import tank.common.Group;
import tank.common.ResourceMgr;
import tank.part.Tank;

public class TankMain {

	public static void main(String[] args) {
		TankFrame tankFrame = new TankFrame();
		
		System.out.println((int)Math.random()*800);
		
		for(int i = 0; i < 7 ;i++) {
			int x = (int)(Math.random() * 800);
			int y = (int)(Math.random() * 600);
			ResourceMgr.TANK_LIST.add(new Tank(x, y, Dir.randomDir(), true, Group.BAD));
		}
		
		while(true) {
			try {
				Thread.sleep(50);
				tankFrame.repaint();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
