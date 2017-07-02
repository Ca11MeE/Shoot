package game;

import java.awt.Color;
import java.awt.Graphics;

public class AirPlane extends FlyingObject implements Enemy{
	
	//速度
	private int speed=1;
	
	
	//无参构造(设定默认值)
	public AirPlane() {
		// TODO Auto-generated constructor stub
		this.x=0;
		this.y=0;
		this.height=40;
		this.width=40;
		this.life=1;
	}
	
	//坐标构造
	public AirPlane(int x,int y){
		this();setX(x);setY(y);
	}
	
	//坐标和大小构造
	public AirPlane(int x,int y,int width,int height){
		setX(x);setY(y);setWidth(width);setHeight(height);
	}
	
	public void step(){
		y+=speed;
	}
	
	public int getLife() {
		// TODO Auto-generated method stub
		return life;
	}
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	void paintObj(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.pink);
		g.fillOval(this.x, this.y+(int)(0.5*this.height), this.width, this.width/6);
		g.fillOval(this.x+this.width/12*5, this.y, (int)(this.width/6), this.height);
		g.fillOval(this.x+this.width/6, this.y, this.width/3*2, this.width/8);
		
	}

	@Override
	boolean outOfBound() {
		// TODO Auto-generated method stub
		if (this.y>=Game.FRAME_HEIGHT) {
			return true;
		}
		return false;
	}

	@Override
	boolean hit(FlyingObject flyingObject) {
		// TODO Auto-generated method stub
		boolean b=flyingObject.getX()>=this.x-flyingObject.getWidth() && flyingObject.getY()>=this.y-flyingObject.getHeight()
				&&flyingObject.getX()<=this.x+this.width
				&&flyingObject.getY()<=this.y+this.height;
		if (b) {
			life--;
			if (life<=0) {
				return true;
			}
		}
		return false;
	}
	
}
