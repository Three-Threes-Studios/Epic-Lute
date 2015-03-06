package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Date;
import java.util.Calendar;

public class Creator extends Pusher {

	public Date stunTimer;
	
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
	
	public Destroyer createDestroyer(){
		return null;
	}
	
	public Pusher createPusher(){
		return null;
	}
	
}
