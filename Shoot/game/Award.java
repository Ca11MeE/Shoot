package game;

public interface Award {
	
	/**
	 * 奖励命
	 */
	public static final int LIFE=0;
	/**
	 * 奖励双重火力
	 */
	public static final int DOUBLE_FIRE=1;
	
	/**
	 * 实现返回奖励类型所表示的int值
	 * @return 奖励表示的int值
	 */
	abstract int getAward();
}
			
