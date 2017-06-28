package game;

import java.awt.Color;
import java.awt.Graphics;

public class AwdPkg extends FlyingObject implements Award{
	
	//速度
	private int speed=3;
	
	public AwdPkg() {
		// TODO Auto-generated constructor stub
		this.x=0;
		this.y=0;
		this.width=20;
		this.height=20;
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
		return 0;
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

}
