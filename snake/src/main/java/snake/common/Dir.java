package snake.common;

public enum Dir {
	LEFT,
	UP,
	RIGHT,
	DOWN;
	
	public static Dir randomDir() {
		return CommonUtil.random(Dir.class);
	}
	
	public static Dir getNegativeDir(Dir dir) {
		switch (dir) {
		case LEFT:
			return RIGHT;
		case UP:
			return DOWN;
		case RIGHT:
			return LEFT;
		case DOWN:
			return DOWN;
		default:
			return UP;
		}
	}
}
