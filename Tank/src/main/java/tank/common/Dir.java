package tank.common;

public enum Dir {
	LEFT,
	UP,
	RIGHT,
	DOWN;
	
	public static Dir randomDir() {
		return CommonUtil.random(Dir.class);
	}
}
