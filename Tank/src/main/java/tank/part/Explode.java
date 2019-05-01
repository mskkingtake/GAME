package tank.part;

import java.awt.Graphics;

import tank.common.ResourceMgr;

public class Explode {
	private int x;
	private int y;

	private int step = 0;

	public Explode(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * 分步骤战士爆炸
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if (step >= ResourceMgr.explodes.length) {
			ResourceMgr.EXPLODE_LIST.remove(this);
		}
	}
}
