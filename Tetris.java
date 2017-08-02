package Tetris;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Tetris extends JFrame {

	private JLabel statusBar;
//	private JLabel Title;
	
	public Tetris(){
		statusBar = new JLabel("0");
//		Title = new JLabel("Prototype");
//		add(Title, BorderLayout.NORTH);
		add(statusBar, BorderLayout.SOUTH);
		Board board = new Board(this);
		add(board);
		board.setBackground( Color.BLACK);
		
		board.newBlock();
		board.repaint();
		
		setSize(200,400);
		setTitle("the Tetris Project");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		
		
	}
	
	public JLabel getStatusBar() {
		// TODO Auto-generated method stub
		return statusBar;
	}
	@SuppressWarnings("deprecation")
	
	public static void main(String arg[]){
		Tetris tetris = new Tetris();
		tetris.setLocationRelativeTo(null);
		tetris.show();
		
	}

}
