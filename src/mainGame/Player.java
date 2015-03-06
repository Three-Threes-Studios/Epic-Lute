package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Calendar;
import java.util.Date;


public class Player implements GameObject {
	
	public boolean drums;
	public boolean hasDrumstick;
	public Date drumTimer;
	public boolean bass;
	public boolean synth;
	public boolean lute;
	public boolean hasLuteDash;
	public Date luteTimer;
	public int speed;
	
	public Player(){
		
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
	
	public Drumstick throwDrumstick(){
		return null;
	}
	
	public void luteDash(){
		return;
	}

}
