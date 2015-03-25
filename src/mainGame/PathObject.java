package mainGame;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class PathObject extends GameObject{

	public int[][] path;
	public int index;
	public boolean loop;
	
	public static int STUNLENGTH = 1000;
	
	public long stunTimer;
	
	public PathObject(int[] position, boolean canBeDestroyed,
			boolean blocksProjectiles, boolean isProjectile,
			String graphicPath, int speed, int direction, int width,
			int height, int[][] path, boolean loop){
		super(position, canBeDestroyed,
			blocksProjectiles, isProjectile,
		    graphicPath, speed, direction, width, height);
		this.index = 0;
		this.path = path;
		this.loop = loop;
		this.stunTimer = 0L;
	}
	
	public boolean proceed(){ //returns whether its ready to be destroyed TODO: direction. diagonal?
		if (path.length==0) return false; //checks if the object is stationary
		else if (System.currentTimeMillis()<stunTimer) return false;
		int[] heading = getHeading();
		
		//moves the object
		position[0] += heading[0]*speed;
		position[1] += heading[1]*speed;
		
		if (heading[0] == 1) direction = 270;
		else if (heading[0] == -1) direction = 90;
		else if (heading[1] == 1) direction = 180;
		else if (heading[1] == -1) direction = 0;
		
		//checks if its time to move on the path
		boolean arrived = true;
		if ( heading[0]>0 && position[0]<path[index][0]) {arrived = false;}
		else if (heading[0]<0 && position[0]>path[index][0]) {arrived = false;}
		if (heading[1]>0 && position[1]<path[index][1]) {arrived = false;}
		else if (heading[1]<0 && position[1]>path[index][1]) {arrived = false;}
		if (arrived) { //if the object is arrived, it updates the destination or says to destroy the object
			position[0] = path[index][0]; //dont do position = path[index] because pointers
			position[1] = path[index][1];
			index++;
			if (index >= path.length){
				if (!loop) return true;
				index = 0;
			}
		}
		return false;
	}
	
	@Override
	public void paint(Graphics2D g) {
		//g.fillRect(position[0], position[1], width, height); //TODO: replace this placeholder with the real graphic
		g.drawImage(graphic, position[0], position[1], null);
		
	}
	
	protected int[] getHeading(){
		//heading[0] is 1 if going left, -1 if right, 0 if neither
		//heading[1] is 1 if going down, -1 if up, 0 if neither
		int previousIndex = index-1;
		if (index-1 < 0) previousIndex = path.length-1;
		int[] heading = {0,0};
		if (path[index][0] < path[previousIndex][0]) heading[0] = -1;
		else if (path[index][0] > path[previousIndex][0]) heading[0] = 1;
		if (path[index][1] < path[previousIndex][1]) heading[1] = -1;
		else if (path[index][1] > path[previousIndex][1]) heading[1] = 1;
		return heading;
	}
	
	
}
