package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Date;
import java.util.Calendar;

public class Creator extends Pusher {

	public Creator(int[] position, boolean canBeDestroyed,
			boolean blocksProjectiles, boolean isProjectile,
			String graphicPath, int speed, int direction,
			int width, int height, int[][] path, boolean loop) {
		super(position, canBeDestroyed, blocksProjectiles, isProjectile, graphicPath,
				speed, direction, width, height, path, loop);
		// TODO Auto-generated constructor stub
	}

	public Date stunTimer;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	} */

	@Override
	public void paint(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	public Destroyer createDestroyer(){
		return null;
	}
	
	public Pusher createPusher(){
		return null;
	}
	
	@Override
	public boolean onCollision(GameObject o){
		return false;
	}
	
}
