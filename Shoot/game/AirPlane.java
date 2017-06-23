package game;

import java.awt.Color;
import java.awt.Graphics;

public class AirPlane extends FlyingObject implements Enemy{
	
	//无参构造(设定默认值)
	public AirPlane() {
		// TODO Auto-generated constructor stub
		this.x=0;
		this.y=0;
		this.height=40;
		this.width=40;
	}
	
	//坐标构造
	public AirPlane(int x,int y){
		setX(x);setY(y);
	}
	
	//坐标和大小构造
	public AirPlane(int x,int y,int width,int height){
		setX(x);setY(y);setWidth(width);setHeight(height);
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
	
}
