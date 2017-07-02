package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener{
	
	//设置窗口常量
	public static final int FRAME_WIDTH=400;
	public static final int FRAME_HEIGHT=680;
	
	//定义游戏状态常量
	public static final int START=0;
	public static final int PLAYING=1;
	public static final int PAUSE=2;
	public static final int END=3;
	
	//定义游戏状态
	private static int status=0;
	
	//定义英雄机移动开关
	private boolean hUP=false,hDOWN=false,hLEFT=false,hRIGHT=false;
	
	//定义计数变量
	private static int count=0;
	private static int randomNum;
	private static int score=0;
	
	//定义随机器
	Random random=new Random();
	
	Hero hero=new Hero(180,FRAME_HEIGHT/5*4);
	
	//定义飞行物集合
	List<FlyingObject> flyings=new LinkedList<FlyingObject>();
	//定义子弹集合
	List<Bullet> bullets=new LinkedList<Bullet>();
	
	public static void main(String[] args) {
		JFrame gameFrm=new JFrame("Game");
		Game game=new Game();
		game.setBackground(Color.BLACK);
		gameFrm.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		gameFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrm.add(game);
		gameFrm.setVisible(true);
		
		game.runGame();
		gameFrm.addKeyListener(game);
	}
	
	
	public void keyTyped(KeyEvent e) {
	}
	
	//重写鼠标释放
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			hUP=false;
			break;
		case KeyEvent.VK_S:
			hDOWN=false;
			break;
		case KeyEvent.VK_A:
			hLEFT=false;
			break;
		case KeyEvent.VK_D:
			hRIGHT=false;
			break;
		}
	}
	
	//重写键盘按下
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			hUP=true;
			break;
		case KeyEvent.VK_S:
			hDOWN=true;
			break;
		case KeyEvent.VK_A:
			hLEFT=true;
			break;
		case KeyEvent.VK_D:
			hRIGHT=true;
			break;
		case KeyEvent.VK_ENTER:
			if (status==START||status==PAUSE) {
				status=PLAYING;
			}
			if (status==END) {
				status=START;
				hero=new Hero(180,FRAME_HEIGHT/5*4);
			}
			break;
		case KeyEvent.VK_P:
			if (status==PLAYING) {
				status=PAUSE;
			}
			break;
		}
	}
	
	//判断英雄机是否该移动
	public void hMove(){
		if (hUP&&hero.getY()>0) {
			hero.move(Hero.UP);
		}
		if (hDOWN&&hero.getY()<FRAME_HEIGHT-hero.getHeight()) {
			hero.move(Hero.DOWN);
		}
		if (hLEFT&&hero.getX()>0) {
			hero.move(Hero.LEFT);
		}
		if (hRIGHT&&hero.x<FRAME_WIDTH-hero.getWidth()) {
			hero.move(Hero.RIGHT);
		}
	}
	
	
	
	//画出飞行物
	public void paintFlyings(Graphics g){
		for (FlyingObject flyings : flyings) {
			flyings.paintObj(g);
		}
	}
	
	//画出子弹
	public void paintBullets(Graphics g){
		for (Bullet bullet : bullets) {
			bullet.paintObj(g);
		}
	}
	
	//画开始界面
	public void paintStart(Graphics g){
		g.setColor(Color.red);
		g.setFont(new Font("宋体", Font.BOLD, 95));
		g.drawString("飞机大战",0 , FRAME_HEIGHT/5);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("按Enter开始", 120, FRAME_HEIGHT/2);
		g.drawString("按P暂停", 150, FRAME_HEIGHT/2+30);
	}
	
	//画结束界面
	public void paintEnd(Graphics g){
		g.setColor(Color.red);
		g.setFont(new Font("宋体", Font.BOLD, 95));
		g.drawString("游戏结束",0 , FRAME_HEIGHT/2);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("按Enter开始", 120, FRAME_HEIGHT/3*2);
	}
	
	//画暂停界面
	public void paintPause(Graphics g){
		g.setColor(Color.red);
		g.setFont(new Font("宋体", Font.BOLD, 95));
		g.drawString("游戏暂停",0 , FRAME_HEIGHT/2);
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("按Enter开始", 120, FRAME_HEIGHT/3*2);
	}
	
	//打印生命值
	public void paintLife(Graphics g){
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("Life:"+String.valueOf(hero.getLife()),0, 20);
	}
	
	public void paintScore(Graphics g){
		g.setFont(new Font("宋体", Font.BOLD, 30));
		g.drawString("Score:"+String.valueOf(score), 0, 40);
	}
	
	//随机增加敌人行为
	public void addEnemy(int count){
		if (count%100==0) {
			randomNum=random.nextInt(20);
			FlyingObject flyingObject;
			if (randomNum>=3) {
				flyingObject=new AirPlane(random.nextInt(FRAME_WIDTH-40),-40);
				flyings.add(flyingObject);
			}
			else{
				flyingObject=new AwdPkg(random.nextInt(FRAME_WIDTH-40),-40);
				flyings.add(flyingObject);
			}
		}
		
	}
	
	//英雄机发射子弹行为
	public void heroShoot(int count){
		if (count%40==0) {
			Bullet[] bs=hero.shoot();
			for (Bullet bullet : bs) {
				bullets.add(bullet);
			}
				
			}
	}
	
	//窗口所有飞行物移动
	public void steps(){
		for (FlyingObject flyings : flyings) {
			flyings.step();
		}
		for (Bullet bullet : bullets) {
			bullet.step();
		}
	}
	
	//飞行物越界
	public void flyingsOutOfBound(){
		Iterator<FlyingObject> iterator;
		iterator=flyings.iterator();
		while(iterator.hasNext()){
			FlyingObject f=iterator.next();
			if (f.outOfBound()) {
				iterator.remove();
			}
		}
	}
	
	//飞行物碰撞
	public void flyingsHit(){
		for(int i=0;i<flyings.size();i++){
			for(int j=0;j<bullets.size();j++){
				
				if (flyings.get(i).hit(bullets.get(j))) {
					getAward(flyings.get(i));
					if (flyings.get(i).getLife()<=0) {
						flyings.remove(i);	
					}
					bullets.remove(j);
					break;
				}
			}
		}
	}
	
	//定义获取奖励
	public void getAward(FlyingObject obj){
		if(obj instanceof Enemy){
			Enemy enemy =(Enemy)obj;
			score+=enemy.getScore();
		}
		if (obj instanceof Award) {
			Award award=(Award)obj;
			switch (award.getAward()) {
			case Award.LIFE:
				hero.addLife();
				break;
			case Award.DOUBLE_FIRE:
				hero.addFire();
				break;
			}
			
		}
	}
	
	//飞行物与英雄机碰撞
	public void heroHit(){
		for (int i = 0; i < flyings.size(); i++) {
			if (flyings.get(i).hit(hero)) {
				hero.subLife();
				getAward(flyings.get(i));
				flyings.remove(i);
			}
		}
	}
	
	//游戏结束
	public void gameOver(){
		if (hero.getLife()<=0) {
			status=END;
		}
	}
	
	//程序执行
	public void runGame(){
		Timer run=new Timer();
		run.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				repaint();
				gameOver();
				switch (status) {
				case START:
					
					break;
				case PLAYING:
					addEnemy(count);
					heroShoot(count);
					steps();
					hMove();
					flyingsOutOfBound();
					heroHit();
					flyingsHit();
					count++;
					break;
				case PAUSE:
					break;
				case END:
					break;
				}
				
			}
		}, 10,10);
		
	}
	
	@Override
	/**
	 * 重写JPanel的paint方法
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		switch (status) {
		case START:
			paintStart(g);
			hero.paintObj(g);
			break;

		case PLAYING:
			hero.paintObj(g);
			paintFlyings(g);
			paintBullets(g);
			paintLife(g);
			paintScore(g);
			break;
		case PAUSE:
			paintPause(g);
			hero.paintObj(g);
			paintFlyings(g);
			paintBullets(g);
			paintLife(g);
			paintScore(g);
			break;
		case END:
			paintEnd(g);
			break;
		}
		
	}
	
	
}
