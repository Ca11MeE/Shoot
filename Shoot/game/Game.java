package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel implements KeyListener{
	
	//设置窗口常量
	public static final int FRAME_WIDTH=400;
	public static final int FRAME_HEIGHT=680;
	
	//定义英雄机移动开关
	private boolean hUP=false,hDOWN=false,hLEFT=false,hRIGHT=false;
	
	AirPlane plane=new AirPlane();
	AwdPkg awdPkg=new AwdPkg(50,50);
	Bullet bullet=new Bullet(200, 50);
	Hero hero=new Hero();
	
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
	
	
	public void keyTyped(KeyEvent e) {}
	
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
		}
	}
	
	//判断英雄机是否该移动
	public void hMove(){
		if (hUP) {
			hero.move(Hero.UP);
		}
		if (hDOWN) {
			hero.move(Hero.DOWN);
		}
		if (hLEFT) {
			hero.move(Hero.LEFT);
		}
		if (hRIGHT) {
			hero.move(Hero.RIGHT);
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
				plane.step();
				awdPkg.step();
				bullet.step();
				hMove();
			}
		}, 30,30);
		
	}
	
	@Override
	/**
	 * 重写JPanel的paint方法
	 */
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		plane.paintObj(g);
		awdPkg.paintObj(g);
		hero.paintObj(g);
		bullet.paintObj(g);
	}
	
	
}
