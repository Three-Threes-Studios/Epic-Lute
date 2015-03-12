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
	public Date drumTimer;
	public boolean bass;
	public boolean synth;
	public boolean lute;
	public boolean hasLuteDash;
	public Date luteTimer;
	public int[] velocity;
	
	public Player(){
		super( new int[2] ,true,true,false,"blueCircle.png",3,0); //3 is default speed
		position = new int[2];
		position[0] = 100; //default position
		position[1] = 100;
		
		drums = false;
		hasDrumstick = false;
		drumTimer = null;
		bass = false;
		synth = false;
		lute = false;
		hasLuteDash = false;
		luteTimer = null;

		velocity = new int[2];
		velocity[0] = 0;
		velocity[1] = 0;
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
		g.fillRect(position[0], position[1], 10,10); //TODO: replace this placeholder with the real graphic
		
	}
	
	public Drumstick throwDrumstick(){
		return null;
	}
	
	public void luteDash(){
		return;
	}

}
