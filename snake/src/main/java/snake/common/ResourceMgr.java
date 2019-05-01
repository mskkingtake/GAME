package snake.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import snake.part.Snake;

public class ResourceMgr {
	// 坦克图片
	public static Snake mySnake;
	
	// 坦克图片
	public static int INIT_X = 200;
	
	// 坦克图片
	public static int INIT_Y = 200;
	// 坦克图片
	public static int tankNumber = 10;
	
	public static boolean RESET_FLAG = false;
	
	
	// 坦克图片
	public static BufferedImage SANKE_L;
	public static BufferedImage SANKE_U; 
	public static BufferedImage SANKE_R; 
	public static BufferedImage SANKE_D;
	
	// 图片初始化
	static {
		try {
			SANKE_L = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankL.gif"));
			SANKE_U = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankU.gif"));
			SANKE_R = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankR.gif"));
			SANKE_D = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("resource/images/tankD.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 游戏画面宽度
	public static final int GAME_WIDTH = 600;
	// 游戏画面高度
	public static final int GAME_HEIGHT  = 800;
	
	// 坦克宽度
	public static final int SNAKE_WIDTH = SANKE_L.getWidth();
	// 坦克高度
	public static final int SNAKE_HEIGHT  = SANKE_L.getHeight();
	// 坦克速度
	public static final int SNAKE_SPEED  = 10;
	// 坦克的集合
	public static List<Snake> SNAKE_LIST = new ArrayList<Snake>();	
}
