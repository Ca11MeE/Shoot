package game;

import java.awt.Graphics;

/**
 * 飞行物的抽象类
 * @author callmee
 *
 */
abstract class FlyingObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int life;
	
	
	/**
	 * 抽象方法:根据飞行物的具体对象的不同而利用画笔话出图片
	 * @param g 传入的画笔
	 */
	abstract void paintObj(Graphics g);
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	//飞行物走一步
	abstract void step();
	//飞行物越界判断
	abstract boolean outOfBound();
	//飞行物碰撞
	abstract boolean hit(FlyingObject flyingObject);
	//获取生命
	abstract int getLife();
}
