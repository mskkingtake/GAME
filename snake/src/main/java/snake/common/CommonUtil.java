package snake.common;

import java.util.Random;

public class CommonUtil {
	// 生成种子
	private static int random=(int)(Math.random()*10);
    private static Random rand = new Random(random);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
    
    /**
	 * 生成一个随机数
	 * @return
	 */
    public static int getRandomInt(int maxInt) {
		return (int)(Math.random() * maxInt);
	}
}
