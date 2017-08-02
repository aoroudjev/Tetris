package Tetris;


public class Shape {
	
	//define blocks//
	enum Blocks {
		Blank(new int[][] { {0,0}, {0,0}, {0,0}, {0,0} } ),
		LBlock(new int[][] { {-1,-1}, {0,-1}, {0,0}, {0,1} } ),
		ReverseLBlock(new int[][] { {1,-1}, {0,-1}, {0,0}, {0,1} } ),
		TBlock(new int[][] { {-1,0}, {0,0}, {1,0}, {0,1} } ),
		SBlock(new int[][] { {0,-1}, {0,0}, {-1,0}, {-1,1} } ),
		SquareBlock(new int[][] { {0,0}, {1,0}, {0,1}, {1,1} } ),
		ZBlock(new int[][] { {0,-1}, {0,0}, {1,0}, {1,1} } ),
		LinePiece(new int[][] { {-1,0}, {0,0}, {0,1}, {0,2} } );
		
		
		
	//coordinates for producing blocks//
	public int[][] coords;
	
	//create/define//
	private Blocks(int[][] c){
		coords = c;
		}
	}
	
	//coordinates for on board function//
	private Blocks currentShape;
	private int[][] coords;
	
	public Shape() {
		coords = new int[4][2];
		setShape(Blocks.Blank);
	}
	
	public void setShape(Blocks shape){
		for (int i=0; i<4; i++){
			for (int j=0; j<2; j++){
				coords[i][j] = shape.coords[i][j];
			}
		}
		currentShape = shape;
	}
	
	//to set x and y of shape
	public void setX(int position, int x){
		coords[position][0] = x;
	}
	public void setY(int position, int y){
		coords[position][1] = y;
	}
	
	// return x and y value
	public int getY(int y){
		return coords[y][1];
	}
	public int getX(int x){
		return coords[x][0];
	}
	
	//returns the current block shape
	public Blocks getBlockType(){
		return currentShape;
	}
	
	public void getRandomShape(){
		int x = (int) Math.random() * 7 +1;
		Blocks[] number = Blocks.values();
		setShape(number[x]);
		}
	
	//min x and y
	public int minX(){
		int m = coords[0][0];
		for(int i=0; i<4; i++){
			m = Math.min(m, coords[i][0]);
		}
		return m;
	}
	public int minY(){
		int m = coords[0][1];
		for(int i=0; i<4; i++){
			m = Math.min(m, coords[i][1]);
		}
		return m;
	}




	
		
	}
	
	
	

