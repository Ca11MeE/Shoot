package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 子弹
 * @author keliyi
 *
 */
public class Bullet extends FlyingObject {
	
	//速度
	private int speed=4;
	
	//构造方法(无参)
	public Bullet(int x,int y) {
		// TODO Auto-generated constructor stub
		setX(x);setY(y);setWidth(2);setHeight(2);
	}

	//前进
	public void step(){
		this.y-=speed;
	}
	
	@Override
	void paintObj(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.drawOval(this.x, this.y , this.width, this.height);
	}
	
}
