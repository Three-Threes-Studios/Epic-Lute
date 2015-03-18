package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;



public class Player extends GameObject {
	
	public boolean drums;
	public boolean hasDrumstick;
	public long drumTimer;
	public boolean bass;
	public boolean synth;
	public boolean lute;
	public boolean hasLuteDash;
	public long luteTimer;
	public int[] velocity;
	
	public Player(){
		super( new int[2] ,true,true,false,"blueCircle.png",3,0, 20, 20); //3 is default speed
		position = new int[2];
		position[0] = 100; //default position
		position[1] = 100;
		
		drums = false;
		hasDrumstick = false;
		drumTimer = 0l;
		bass = false;
		synth = false;
		lute = false;
		hasLuteDash = false;
		luteTimer = 0l;

		velocity = new int[2];
		velocity[0] = 0;
		velocity[1] = 0;
	}

	@Override
	public void destroy() {
		System.out.println("should be game over"); // TODO sent back to start of level
	}

	/*
	@Override
	public Rectangle getBounds() {
		return new Rectangle(position[0],position[1],width,height);
	}*/

	@Override
	public void paint(Graphics2D g) {
		g.fillRect(position[0], position[1], width, height); //TODO: replace this placeholder with the real graphic
		
	}
	
	public void luteDash(){
		return;
	}

	@Override
	public boolean onCollision(GameObject g) {
		if (g instanceof Destroyer){
			return true;
		}
		else if (g instanceof Pusher) { //this kinda works somehow i guess??
			
			position[0] -= velocity[0] * speed;
			if (!getBounds().intersects(g.getBounds())) return false;
			
			position[0] += velocity[0] * speed;
			position[1] -= velocity[1] * speed;
			if (!getBounds().intersects(g.getBounds())) return false;
			
			position[0] -= velocity[0] * speed;
			
			if (!getBounds().intersects(g.getBounds())) return false;
			position[0] += velocity[0] * speed;
			position[1] += velocity[1] * speed;	
			
			while (position[0]+width > g.position[0] && position[0] < g.position[0] && g.direction == 90){
				position[0]--;
			}
			while (position[0] < g.position[0]+g.width && position[0] > g.position[0] && g.direction == 270){
				position[0]++;
			}
			while (position[1]+height > g.position[1] && position[1] < g.position[1] && g.direction == 0){
				position[1]--;
			}
			while (position[1] < g.position[1]+g.width && position[1] > g.position[1] && g.direction == 180){
				position[1]++;
			}
			if (!getBounds().intersects(g.getBounds())) return false;
			while (position[0]+width > g.position[0] && position[0] < g.position[0]){
				position[0]--;
			}
			while (position[0] < g.position[0]+g.width && position[0] > g.position[0]){
				position[0]++;
			}
			while (position[1]+height > g.position[1] && position[1] < g.position[1]){
				position[1]--;
			}
			while (position[1] < g.position[1]+g.width && position[1] > g.position[1]){
				position[1]++;
			}
		}
		return false;
		
	}

}
