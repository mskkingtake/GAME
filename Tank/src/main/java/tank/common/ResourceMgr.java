package tank.common;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceMgr {
	
	// 游戏画面宽度
	public static final int GAME_WIDTH = 600;
	
	// 游戏画面高度
	public static final int GAME_HEIGHT  = 800;
	
	// 游戏画面宽度
	public static final int TANK_WIDTH = 20;
	
	// 游戏画面高度
	public static final int TANK_HEIGHT  = 20;
	
	
	// 坦克速度
	public static final int TANK_SPEED  = 5;
	
	
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
}
