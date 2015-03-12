package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Drumstick extends PathObject {

	public static final int distance = 32; //distance in pixels
	
	public Drumstick(Player player) {
		super(player.position, true, true, true, "", //TODO: put in graphic path for drumstick
				player.speed, player.direction, 
				new int[][]{{(int)breakDirection(player.direction)[0]*distance,(int)breakDirection(player.direction)[1]*distance}},
				false); //TODO: change speed if needed
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	public void onCollision(GameObject o){
		
	}


}
