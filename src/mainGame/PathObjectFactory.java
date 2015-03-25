package mainGame;

public class PathObjectFactory {
	
	public static Creator createNewOrcArcher(int[] position, int[][] path, long wait, int fireDirection){
		Destroyer prototype = new Destroyer(new int[]{0,0},
				true,false,true,"PNG repository/arrow.png",3,0,6,32,new int[][]{{0,0},{0,0}},
				false); // arrow
		
		return new Creator(position,
				false,true,false,"PNG repository/orcarcher.png",1,0,32,32,path,
				true,prototype,2000,wait,fireDirection);
	}
	
	public static Pusher createNewMovingBlock(){
		return null;
	}
	
	public static Destroyer createNewOrcFighter(int[] position, int[][] path){
		return new Destroyer(position,
				false,false,false,"PNG repository/orcspear.png",1,0,32,32,path,
				true);
	}
	
	public static Pusher createNewWall(){
		return null;
	}
	
	public static Destroyer createNewHazard(int[] position){
		return new Destroyer(position, //TODO replace graphic with water or lava
				false,false,true,"PNG repository/demonspear.png",1,0,32,32,new int[][]{position},
				true); //test hazard tile
	}

}

/*PathObject(int[] position, boolean canBeDestroyed,
boolean blocksProjectiles, boolean isProjectile,
String graphicPath, int speed, int direction, int width,
int height, int[][] path, boolean loop){ 

Creator(int[] position, boolean canBeDestroyed,
			boolean blocksProjectiles, boolean isProjectile,
			String graphicPath, int speed, int direction,
			int width, int height, int[][] path, boolean loop,
			GameObject prototype, int rate, long wait, int fireDirection)*/
