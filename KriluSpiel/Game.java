import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

/**
 * This Class is used as a small framework for 2D games.
 * It should have a subclass which calls its constructor.
 * @author Lukas Reining
 * @version 1.0 from 21.04.2016
 */
public abstract class Game extends Canvas implements KeyListener{
	
	private static final long serialVersionUID = 1L;
	private static int width = 320;
	private static int height = width /12 * 9;
	private static int scale = 2;
	final double amountOfTicks;
	private String title = "";
	public JFrame jFrame;
	private BufferedImage image = new BufferedImage(width , height ,BufferedImage.TYPE_INT_RGB );
	
	
	/**
	 * The constructor for the Game class
	 * @param windowSize The size of the window.
	 * @param ticks The amount of updates and FPS
	 * @param title The amount of updates and FPS
	 * @param pListener The Keylistener for the Game
	 */
	public Game(String title ,int windowSize , int ticks){
		this.title = title;
		amountOfTicks = ticks;
		scale = windowSize;
		this.initWindow();
	}
	
	/**
	 * This method updates all objects in the game.
	 */
	abstract void update();
	
	/**
	 * Fill this with objects to render.
	 */
	abstract void render(Graphics g);
	
	private void renderGameBuffered() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		////Rendered objects//////////
		render(g);
        /////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	/**
	 * Initialises the window
	 */
	private void initWindow(){
		this.setPreferredSize(new Dimension(width * scale , height * scale));
		this.setMaximumSize(new Dimension(width * scale , height * scale));
		this.setMinimumSize(new Dimension(width * scale , height * scale));
		jFrame = new JFrame(this.title);
		jFrame.add(this);
		jFrame.addKeyListener(this);
		jFrame.pack();
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setResizable(false);
		jFrame.setFocusable(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}
	
	
	/**
	 * Starts the game.
	 * The objects get updated and rendered
	 */
	public void startGame(){
		long lastTime = System.nanoTime();
		double ns = 1000000000 / amountOfTicks;
		double frames = 0;
		double updates = 0;
		int updateCount = 0;
		int frameCount = 0;
		long timer = System.currentTimeMillis();
		
		while(true){
			long now = System.nanoTime();
			updates += (now - lastTime)/ns;
			frames += (now - lastTime)/ns;
			lastTime = now;
			if(updates >=1 ){
				update();
				updateCount++;
				updates --;
			}
			if(frames >=1 ){
				renderGameBuffered();
				frameCount++;
				frames--;
			}
			
			//Gives out the Fps and the updates in the console
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println(updateCount + " Updates, " + frameCount + " Fps");
				updateCount = 0;
				frameCount = 0;
				
			}
			
		}	
	}

}
