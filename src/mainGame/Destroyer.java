package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Destroyer extends PathObject {
	
	
	public Destroyer(int[] position, boolean canBeDestroyed,
			boolean blocksProjectiles, boolean isProjectile,
			String graphicPath, int speed, int direction, int[][] path, boolean loop) {
		super(position, canBeDestroyed, blocksProjectiles, isProjectile, graphicPath,
				speed, direction, path, loop);
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
