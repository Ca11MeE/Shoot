package game;

import java.awt.Color;
import java.awt.Graphics;

public class AwdPkg extends FlyingObject implements Award{
	
	//速度
	private int speed=1;
	private int awdType;
	
	public AwdPkg() {
		// TODO Auto-generated constructor stub
		this.x=0;
		this.y=0;
		this.width=20;
		this.height=20;
		this.life=1;
		this.awdType=(int)(Math.random()*AWARD_NUM);
	}
	
	public AwdPkg(int x,int y){
		this();
		setX(x);setY(y);
	}
	
	public AwdPkg(int x,int y,int width,int height){
		this(x,y);
		setWidth(width);
		setHeight(height);
	}
	
	public void step(){
		y+=speed;
	}
	
	@Override
	public int getAward() {
		// TODO Auto-generated method stub
		return awdType;
	}

	@Override
	void paintObj(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.PINK);
		g.fill3DRect(this.x, this.y, this.width, this.height,true);
		g.setColor(Color.black);
		g.drawLine(this.x+this.width/2, this.y, this.x+this.width/2, this.y+this.height);
		g.drawLine(this.x, this.y+this.height/2, this.x+this.width, this.y+this.height/2);
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

	@Override
	int getLife() {
		// TODO Auto-generated method stub
		return life;
	}
}
