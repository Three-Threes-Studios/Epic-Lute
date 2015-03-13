package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Drumstick extends PathObject {

	public static final int distance = 128; //distance in pixels
	
	public Drumstick(Player player) {
		super(player.position.clone(), true, true, true, "", //TODO: put in graphic path for drumstick
				player.speed*2, player.direction, 10, 10,
				new int[][]{player.position.clone(),
			{(int)breakDirection(player.direction)[0]*distance+player.position[0],
					(int)breakDirection(player.direction)[1]*distance+player.position[1]}},

				false); //TODO: change speed if needed
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public void paint(Graphics2D g) {
		g.fillRect(position[0], position[1], 10,10); //TODO: replace this placeholder with the real graphic
		
	}
	
	@Override
	public boolean onCollision(GameObject o){
		return false;
	}


}
