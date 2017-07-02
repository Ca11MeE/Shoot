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
	private int speed=1;
	
	//构造方法
	public Bullet(Hero hero) {
		// TODO Auto-generated constructor stub
		setX(hero.getX()+hero.getWidth()/2);setY(hero.getY());setWidth(2);setHeight(2);
	}
	
	public Bullet(int x,int y){
		setX(x);
		setY(y);
		setWidth(2);
		setHeight(2);
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
	
	@Override
	boolean outOfBound() {
		// TODO Auto-generated method stub
		if (this.y<-this.height) {
			return true;
		}
		return false;
	}

	@Override
	boolean hit(FlyingObject flyingObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	int getLife() {
		// TODO Auto-generated method stub
		return 1;
	}
}
