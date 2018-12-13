import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestGame extends Game{
	
	private static final long serialVersionUID = 1L;
	public static TestGame test;
	int x , y;
	Player player1, player2;
	
	
	public TestGame(){
		super("Krilus Spiel" , 3 , 60);
		player1 = new Player(100 , 100 , Color.GREEN , 5);
		player2 = new Player(100 , 200 , Color.MAGENTA , 7);
		startGame();
	}

	public static void main(String[] args) {
	}
	
	@Override
	void update() {
	    player1.update();
	    player2.update();
	}

	@Override
	void render(Graphics g) {
		player1.render(g);
		player2.render(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int id = e.getKeyCode();
	    if(id == KeyEvent.VK_W){
	        player1.directionY = -1;
	    }
	    if(id == KeyEvent.VK_S){
	        player1.directionY = 1;
	    }
	    if(id == KeyEvent.VK_A){
	        player1.directionX = -1;
	    }
	    if(id == KeyEvent.VK_D){
	        player1.directionX = 1;
	    }
	    
	    if(id == KeyEvent.VK_UP){
	        player2.directionY = -1;
	    }
	    if(id == KeyEvent.VK_DOWN){
	        player2.directionY = 1;
	    }
	    if(id == KeyEvent.VK_LEFT){
	        player2.directionX = -1;
	    }
	    if(id == KeyEvent.VK_RIGHT){
	        player2.directionX = 1;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int id = e.getKeyCode();
	    if(id == KeyEvent.VK_W){
	        player1.directionY = 0;
	    }
	    if(id == KeyEvent.VK_S){
	        player1.directionY = 0;
	    }
	    if(id == KeyEvent.VK_A){
	        player1.directionX = 0;
	    }
	    if(id == KeyEvent.VK_D){
	        player1.directionX = 0;
	    }
	    
	    if(id == KeyEvent.VK_UP){
	        player2.directionY = 0;
	    }
	    if(id == KeyEvent.VK_DOWN){
	        player2.directionY = 0;
	    }
	    if(id == KeyEvent.VK_LEFT){
	        player2.directionX = 0;
	    }
	    if(id == KeyEvent.VK_RIGHT){
	        player2.directionX = 0;
	    }
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
