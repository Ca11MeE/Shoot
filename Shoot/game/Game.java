package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JPanel{
	
	//设置窗口常量
	public static final int FRAME_WIDTH=400;
	public static final int FRAME_HEIGHT=680;
	
	
	
	AirPlane plane=new AirPlane();
	AwdPkg awdPkg=new AwdPkg(50,50);
	
	public static void main(String[] args) {
		JFrame gameFrm=new JFrame("Game");
		Game game=new Game();
		game.setBackground(Color.BLACK);
		gameFrm.setSize(FRAME_WIDTH,FRAME_HEIGHT);
		gameFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrm.setContentPane(game);
		gameFrm.setVisible(true);
		
		
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
	}
}
