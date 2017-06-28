package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.sound.midi.VoiceStatus;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

/**
 * 英雄机
 * @author keliyi
 *
 */
public class Hero extends FlyingObject{
	
	private int speed=5;
	public static final int UP=0;
	public static final int DOWN=1;
	public static final int LEFT=2;
	public static final int RIGHT=3;
	
	//构造方法(无参)
	public Hero() {
		// TODO Auto-generated constructor stub
		setX(200);setY(300);setWidth(50);setHeight(50);
	}
	
	//设置速度
	public void setSpeed(int speed){
		this.speed=speed;
	}
	
	//获取速度
	public int getSpeed() {
		return speed;
	}
	
	//英雄机移动
	public void move(int direct){
		switch (direct) {
		case 0:
			this.y-=speed;
			break;
		case 1:
			this.y+=speed;break;
		case 2:this.x-=speed;break;
		case 3:this.x+=speed;break;
		}
	}
	
	@Override
	void paintObj(Graphics g) {
		// TODO Auto-generated method stub
		/*
		 * 话三角形
		 */
		//三个点的x坐标
		g.setColor(Color.PINK);
		int[] xs={this.x+this.width/2,this.x,this.x+this.width};
		int[] ys={this.y,this.y+this.height/4*3,this.y+this.height/4*3};
		g.fillPolygon(xs, ys, 3);
		int[] xshead={this.x+this.width/2,this.x+this.width/8,this.x+this.width/8*7};
		int[] yshead={this.y+this.height/4*3,this.y+this.height,this.y+this.height};
		g.fillPolygon(xshead, yshead, 3);
		
		/*
		 * 画英雄机的其余部分
		 */
		//画主干
		g.fillRect(this.x+this.width/2-3, this.y+this.height/2, 6, this.height/2);
		//画喷射器
		g.fillRect(this.x+this.width/10, this.y+this.height/10*3, 5, 20);
		g.fillRect(this.x+this.width/10*9-5, this.y+this.height/10*3, 5, 20);
	}
	
	
}
