package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Date;
import java.util.Calendar;

public class Creator extends Pusher {
	
	static int STUNLENGTH = 5;
	
	public long stunTimer;
	
	public long createTimer;
	public int rate; //of fire
	public int fireDirection;
	public GameObject prototype;

	public Creator(int[] position, boolean canBeDestroyed,
			boolean blocksProjectiles, boolean isProjectile,
			String graphicPath, int speed, int direction,
			int width, int height, int[][] path, boolean loop,
			GameObject prototype, int rate, long wait, int fireDirection) {
		super(position, canBeDestroyed, blocksProjectiles, isProjectile, graphicPath,
				speed, direction, width, height, path, loop);
		this.rate = rate;
		this.prototype = prototype;
		this.stunTimer = 0L;
		this.createTimer = wait;
		this.fireDirection = fireDirection;
	}


	
	@Override
	public void destroy() {
		stunTimer = System.currentTimeMillis();
		
	}
	
	/*
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	} */

	@Override
	public void paint(Graphics2D g) {
		g.fillRect(position[0], position[1], width, height); //TODO: replace this placeholder with the real graphic
		
	}
	
	public PathObject create(){
		
		//fires
		if (System.currentTimeMillis() - createTimer > rate){
			PathObject created;
			try {
				created = (PathObject) prototype.clone();
				created.position[0] = position[0];
				created.position[1] = position[1];
				if (fireDirection != -1) created.direction = fireDirection;
				else created.direction = direction;
				created.path[0][0] = position[0];
				created.path[0][1] = position[1];
				if (created.direction == 0) {
					created.path[1][0] = position[0];
					created.path[1][1] = position[1] - 1000;
				} else if (created.direction == 180) {
					created.path[1][0] = position[0];
					created.path[1][1] = position[1] + 1000;
				} else if (created.direction == 90) {
					created.path[1][0] = position[0] - 1000;
					created.path[1][1] = position[1];
				} else if (created.direction == 270) {
					created.path[1][0] = position[0] + 1000;
					created.path[1][1] = position[1];
				}
				if (created.direction==90 || created.direction==270){
					int temp = created.height;
					created.height = created.width;
					created.width = temp;
				}
				createTimer = System.currentTimeMillis();
				return created;
				
			} catch (CloneNotSupportedException e) {
				System.out.println("cloning is not possible");
				e.printStackTrace();
			}

		}
		if (System.currentTimeMillis() - createTimer > rate) createTimer = System.currentTimeMillis();
		return null;
	}
	
	@Override
	public boolean onCollision(GameObject o){
		return false;
	}
	
}
