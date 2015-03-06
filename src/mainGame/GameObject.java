package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public interface GameObject {

	/*
	public int[] position;
	public boolean canBeDestroyed;
	public boolean blocksProjectiles;
	public boolean isProjectile;
	public Controller controller;
	*/
	
	public void destroy();
	public abstract Rectangle getBounds();
	public void paint(Graphics2D g);
	
}
