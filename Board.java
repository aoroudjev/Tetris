package Tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Tetris.Shape.Blocks;


public class Board extends JPanel implements Runnable, KeyListener, ActionListener {


	private static final int height = 22;
	private static final int width = 10;
    private static final Color[] COLORS = { new Color(0,0,0), new Color(204,102,102), new Color(102,204,102), new Color(102,102,204),
			new Color(204,204,102), new Color(204,102,204), new Color(102,204,204), new Color(218,170,0)};
	private Timer timer;
	private boolean done = false, start = false;
	private int currentx= 0,currenty = 0;
	private JLabel statusbar;
	private Shape currentBlock;
	private Blocks[] board;
	
	public Board(Tetris x){
		setFocusable(true);
		currentBlock = new Shape(); 
		timer = new Timer(400, this); //time for lines down
		statusbar = x.getStatusBar();
		board = new Blocks[width * height];
		clear();
	}
	
	public int getSquareWidth(){
		return (int) getSize().getWidth()/width;	
	}
	public int getSquareHeight(){
		return (int) getSize().getHeight()/height;	
	}
	
	public Blocks shapeAt(int x, int y){
		return board[y * width + x];
	}
	
	
	
	private void clear() {
		// TODO Auto-generated method stub
		for (int i=0; i<width*height; i++){
			board[i] = Blocks.Blank;
		}
	}
	
	private void blockPlaced(){
		for (int i=0; i<4; i++){
			int x = currentx + currentBlock.getX(i);
			int y = currenty + currentBlock.getY(i);
			board[y* width +x] = currentBlock.getBlockType();
		}
		if (!done){
			newBlock();
		}
		}
	
	

	void newBlock() {
		// TODO Auto-generated method stub
		currentBlock.getRandomShape();
		currentx = width/2 +1;
		currenty = height - 1 + currentBlock.minY();
		
	}
	
	private void fall(){
		blockPlaced();
	}
	

	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		Tetris myTetris = new Tetris();
		myTetris.setLocationRelativeTo(null);
		myTetris.show();
		
	 
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (done){
			done = false;
			newBlock();
		}
		else{
			fall();
		}
	}
	
	public void drawSquare(Graphics g, int x, int y, Blocks shape){
		Color color = COLORS[shape.ordinal()];
		g.setColor(color);
		//g.setColor(Color.MAGENTA);
		g.fillRect(x+1, y+1, getSquareWidth() - 2, getSquareHeight() -2);
		g.setColor(color.brighter());
		//g.setColor(Color.BLACK);
		g.drawLine(x, y+ getSquareHeight() -1, x, y);
		g.drawLine(x, y, x + getSquareWidth() -1, y);
		g.setColor(color.darker());
		
		g.drawLine(x + 1, y + getSquareHeight() -1, x + getSquareWidth() -1, y + getSquareHeight() - 1);
		g.drawLine(x+ getSquareWidth() -1, y + getSquareHeight() - 1, x+ getSquareWidth() -1, y+1);
		}
	
	public void paint(Graphics g){
		super.paint(g);
		Dimension size = getSize();
		int top = (int) size.getHeight() - height * getSquareHeight();
		g.drawString("Prototype v0.23", 0, height- top);
		
		
		for (int i=0; i<height; i++){
			for (int j=0; j<width; ++j){
				Blocks shape = shapeAt(j, height -i -1);
			
			if (shape != Blocks.Blank){
				drawSquare(g, j * getSquareWidth(), top + i * getSquareHeight(), shape);
			}
		  }
		}
		
		if (currentBlock.getBlockType() != Blocks.Blank){
			for (int i=0; i<4; i++){
				int x = currentx + currentBlock.getX(i);
				int y = currenty - currentBlock.getY(i);
				drawSquare(g, x * getSquareWidth(), top + (height -y-1) * getSquareHeight(), currentBlock.getBlockType());

			}
		}	
	}
}
