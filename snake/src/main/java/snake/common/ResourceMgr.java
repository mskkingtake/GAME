package snake.common;

import java.util.ArrayList;
import java.util.List;

import snake.part.Snake;

public class ResourceMgr {
	// 坦克图片
	public static Snake mySnake;
	
	// 贪吃蛇初始位置
	public static int INIT_X = 200;
	
	// 贪吃蛇初始位置
	public static int INIT_Y = 200;
	
	// 贪吃蛇果实
	public static List<Snake> SNAKE_PART_LIST = new ArrayList<Snake>();
	// 贪吃蛇果实
	public static int SNAKE_PART_COUNT = 3;
	
	
	// 游戏画面宽度
	public static final int GAME_WIDTH = 600;
	// 游戏画面高度
	public static final int GAME_HEIGHT  = 800;
	
	// 贪吃蛇果实
	public static int SNAKE_INIT_COUNT = 20;
	// 贪吃蛇每部分宽度
	public static final int SNAKE_WIDTH = 10;
	// 贪吃蛇每部分高度
	public static final int SNAKE_HEIGHT  = 10;
	// 贪吃蛇速度
	public static final int SNAKE_SPEED  = 10;
	// 贪吃蛇的集合
	public static List<Snake> SNAKE_LIST = new ArrayList<Snake>();
}
