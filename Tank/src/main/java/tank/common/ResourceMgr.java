package tank.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import tank.part.Bullet;
import tank.part.Tank;

public class ResourceMgr {
	// 坦克图片
	public static BufferedImage tankL;
	public static BufferedImage tankU; 
	public static BufferedImage tankR; 
	public static BufferedImage tankD; 
	
	// 子弹图片
	public static BufferedImage bulletL; 
	public static BufferedImage bulletU; 
	public static BufferedImage bulletR;
	public static BufferedImage bulletD;
	
	// 爆炸样式
	public static BufferedImage[] explodes = new BufferedImage[16];
	
	// 图片初始化
	static {
		try {
			tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankL.gif"));
			tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankU.gif"));
			tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankR.gif"));
			tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankD.gif"));
			
			bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/bulletL.gif"));
			bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/bulletU.gif"));
			bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/bulletR.gif"));
			bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/bulletD.gif"));
			
			for(int i=0; i<16; i++) {
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/e" + (i+1) + ".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 游戏画面宽度
	public static final int GAME_WIDTH = 600;
	// 游戏画面高度
	public static final int GAME_HEIGHT  = 800;
	
	// 坦克宽度
	public static final int TANK_WIDTH = tankL.getWidth();
	// 坦克高度
	public static final int TANK_HEIGHT  = tankL.getHeight();
	// 坦克速度
	public static final int TANK_SPEED  = 5;

	// 子弹宽度
	public static final int BULLET_WIDTH = bulletL.getWidth();
	// 子弹高度
	public static final int BULLET_HEIGHT  = bulletL.getHeight();
	// 子弹速度
	public static final int BULLET_SPEED  = 10;
	
	// 子弹的集合
	public static List<Bullet> BULLET_LIST = new ArrayList<Bullet>();
	// 坦克的集合
	public static List<Tank> TANK_LIST = new ArrayList<Tank>();
	
	
	
	
	
}
