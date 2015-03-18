package mainGame;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class GameObject implements Cloneable {

	public int[] position;
	public boolean canBeDestroyed;
	public boolean blocksProjectiles;
	public boolean isProjectile;
	public BufferedImage graphic;
	public int speed;
	public int direction;
	public int width;
	public int height;
	
	public GameObject(int[] position, boolean canBeDestroyed,
			boolean blocksProjectiles, boolean isProjectile,
			String graphicPath, int speed, int direction, int width, int height){
		this.position = position;
		this.canBeDestroyed = canBeDestroyed;
		this.blocksProjectiles = blocksProjectiles;
		this.isProjectile = isProjectile;
		try{
			this.graphic = ImageIO.read(new File(graphicPath));
		} catch (IOException e){
			System.out.printf("could not find graphic %s\n",graphicPath);
			this.graphic = null;
		}
		this.speed = speed;
		this.direction = direction;
		this.width = width;
		this.height = height;
	}
	
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	
	public static double[] breakDirection(int direction){
		double[] broken = new double[2];
		double radians = Math.toRadians((double) direction);
		broken[0] = -Math.sin(radians);
		broken[1] = -Math.cos(radians);
		return broken;
	}
	
	
	public abstract void destroy();
	
	public Rectangle getBounds(){
		return new Rectangle(position[0],position[1],width-1,height-1);
	}
	
	public abstract void paint(Graphics2D g);
	public abstract boolean onCollision(GameObject g); //returns whether or not the object is ready to be destroyed
	
	
}
