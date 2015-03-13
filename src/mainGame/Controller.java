package mainGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Controller extends JPanel {
	
	public static final int gameSpeed = 120; //BPM
	public int xOffset, yOffset;
	public static double bassModifier, synthModifier;
	
	public ArrayList<GameObject> objectList;
	
	public ArrayList<Character> pressedKeys;
	public Map currentMap;
	
	public Controller(){
		objectList = new ArrayList<GameObject>();
		xOffset = 0;
		yOffset = 0;
		bassModifier = 1.0;
		synthModifier = 1.0;
		Player player = new Player();
		objectList.add(player);
		pressedKeys = new ArrayList<Character>();
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				pressedKeys.remove((Character)e.getKeyChar());
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (!pressedKeys.contains((Character)e.getKeyChar())) 
					pressedKeys.add((Character)e.getKeyChar());
			}
		});
		setFocusable(true);
		
		//TODO: start the music!	
	}
	
	public void move(){
		Player player = (Player) objectList.get(0);
		player.position[0] += player.speed * player.velocity[0];
		player.position[1] += player.speed * player.velocity[1];
		ArrayList<Integer> readyForDestruction = new ArrayList<Integer>();
		for (int i = 1; i < objectList.size(); i++ ){
			PathObject pathObject = (PathObject) objectList.get(i);
			if ( pathObject.proceed() ) readyForDestruction.add(i);
		}
		for (Integer i : readyForDestruction){
			objectList.get(i.intValue()).destroy();
			objectList.remove(i.intValue());
		}
		
	}
	
	public void checkCollisions(){
		ArrayList<Integer> readyForDestruction = new ArrayList<Integer>();
		for (int i = 0; i < objectList.size(); i++ ){
			for (int j = 0; j < objectList.size(); j++){
				if (i != j){
					//System.out.printf("checking for collision with %d %d \n",i,j);
					Rectangle iR = objectList.get(i).getBounds();
					Rectangle jR = objectList.get(j).getBounds();
					if (iR.intersects(jR)){
						if ( objectList.get(i).onCollision(objectList.get(j)) ) readyForDestruction.add(i);
					}
				}
			}
		}
		for (Integer i : readyForDestruction){
			objectList.get(i.intValue()).destroy();
			objectList.remove(i.intValue());
		}
	}
	
	public void manageInput(){ //here is where to edit key bindings
		Player player = (Player) objectList.get(0);
		player.velocity = new int[]{0,0};
		for (Character character : pressedKeys){
			char c = character.charValue();
			if (c == 'a') { player.velocity[0] = -1; player.direction = 90; }
			else if (c == 'd') { player.velocity[0] = 1; player.direction = 270; }
			else if (c == 'w') { player.velocity[1] = -1; player.direction = 0; }
			else if (c == 's') { player.velocity[1] = 1; player.direction=180; }
			else if (c == 'e' && player.drums ) {
				long time = System.currentTimeMillis();
				if (time - player.drumTimer > 1000){ //drumstick cooldown
					objectList.add(new Drumstick(player));
					player.drumTimer = time;
				}
			}
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		for (GameObject object : objectList){
			object.paint(g2d);
		}
		g2d.setColor(Color.GRAY);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Epic Lute");
		Controller controller = new Controller();
		frame.add(controller);
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		controller.objectList.add(new Pusher(new int[]{200,200},
				true,false,true,"",1,0,20,20,new int[][]{{200,250},{250,250},{250,200},{200,200}},
				true)); //test pusher
		controller.objectList.add(new Pusher(new int[]{300,300},
				true,false,true,"",1,0,10,10,new int[][]{{300,300},{300,350}},
				false)); //test pusher
		
		((Player)controller.objectList.get(0)).drums = true;
		/*int[] position, boolean canBeDestroyed,
			boolean blocksProjectiles, boolean isProjectile,
			String graphicPath, int speed, int direction, int[][] path, boolean loop*/
		
		//System.out.println(controller.objectList.get(1).position[0]);
		//System.out.println(controller.objectList.get(1).position[1]);
		while (true) { //game loop
			//System.out.println(controller.objectList.get(1).position[1]);
			controller.manageInput();
			controller.move();
			controller.checkCollisions();
			controller.repaint();
			Thread.sleep(10);
			
		}
	}

	
	
	

}
