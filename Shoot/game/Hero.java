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
	private int life=3;
	private int fireValue=0;
	public static final int UP=0;
	public static final int DOWN=1;
	public static final int LEFT=2;
	public static final int RIGHT=3;
	
	//构造方法(无参)
	public Hero() {
		// TODO Auto-generated constructor stub
		setX(200);setY(300);setWidth(50);setHeight(50);
	}
	
	public Hero(int x,int y){
		this();
		setX(x);
		setY(y);
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
	
	//增加生命
	public void  addLife() {
		life++;

	}
	
	//减少生命
	public void subLife(){
		life--;
	}
	
	//获取生命
	public int getLife(){
		return life;
	}
	
	//获取火力值
	public void addFire(){
		fireValue+=40;
	}
	
	//英雄机射击
	//setX(hero.getX()+hero.getWidth()/2);setY(hero.getY());
	public Bullet[] shoot(){
		if (fireValue>0) {
			fireValue-=5;
			return new Bullet[]{new Bullet(this.getX()+this.getWidth()/4, this.getY()),new Bullet(this.getX()+this.getWidth()/4*3, this.getY())};
		}
		return new Bullet[]{new Bullet(this)};
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

	@Override
	void step() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean outOfBound() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	boolean hit(FlyingObject flyingObject) {
		
		boolean b=this.x>=this.x-flyingObject.getWidth()
					&& this.x<=this.x+this.width+flyingObject.getWidth()
					&&
					this.y>=this.y-flyingObject.getHeight()
					&&
					this.y<=this.y+this.height+flyingObject.getHeight();
		if (b) {
			return true;
		}
		return false;
	}
	
	
}
