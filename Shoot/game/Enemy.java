package game;


/**
 * 敌人接口
 * @author callmee
 *
 */
public interface Enemy {
	/**
	 * 击毁敌人后获得的分数
	 * @return 返回分数
	 */
	abstract int getScore();
}
