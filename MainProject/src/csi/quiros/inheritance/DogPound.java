package csi.quiros.inheritance;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;





public class DogPound extends JPanel implements ActionListener{
	
//	List<Dog> dogs1 = new ArrayList<Dog>();
	
	private int B_WIDTH = 800;
	private int B_HEIGHT = 800; 
	private int DOG_SIZE = 120;
	private int ALL_DOGS = 120;
	
	private final int x[] = new int[ALL_DOGS];
    private final int y[] = new int[ALL_DOGS];
	
    private int dogs;
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean isRunning = true;
    
    

	
	private Image greyHound; 
	
	  public DogPound() {
	        
	        initBoard();
	    }
	    
	   private void initBoard() {

	        addKeyListener(new TAdapter());
	        setBackground(new Color(50, 150, 150));
	        setFocusable(true);

	        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
	        initSimulation();
	        loadImages();
	        
	    }
	   
	   private void initSimulation() {

	        dogs = 3;

	        for (int z = 0; z < dogs; z++) {
	            x[z] = 50 - z * 10;
	            y[z] = 50;
	        }
	   }
	   
	   
	   public void loadImages() {

	        ImageIcon iid = new ImageIcon(getClass().getResource("GreyHound.png"));
	        greyHound = iid.getImage().getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
	        iid = new ImageIcon(greyHound);
	        
	   }
	  
	   
	   
	   @Override
	   public void paintComponent(Graphics g) {
		   super.paintComponent(g);
		   

		   doDrawing(g);
	   }
	   
	   private void doDrawing(Graphics g) {
		   
		   
		   if (isRunning) {
	            for (int z = 0; z < dogs; z++) {
	                if (z == 0) {
	                    g.drawImage(greyHound, x[z], y[z], this);
	                } else {
	                	g.drawImage(greyHound, x[z], y[z], this);
	                }
	            }
	            Toolkit.getDefaultToolkit().sync();
		   } else {
			   gameOver(g);
		   }

	   }
	   private void gameOver(Graphics g) {
	    	
			String msg = "Game Over";
			Font small = new Font("Algerian", Font.ITALIC, 130);
			FontMetrics metr = getFontMetrics(small);

			Random rand = new Random();
			int r = rand.nextInt(255);
			int g1 = rand.nextInt(255);
			int b = rand.nextInt(255);

			g.setColor(new Color(r, g1, b));
			g.setFont(small);
			g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
	    }
	   
	    

	   private void move() {

	        for (int z = dogs; z > 0; z--) {
	            x[z] = x[(z - 1)];
	            y[z] = y[(z - 1)];
	        }

	        if (leftDirection) {
	            x[0] -= DOG_SIZE;
	        }

	        if (rightDirection) {
	            x[0] += DOG_SIZE;
	        }

	        if (upDirection) {
	            y[0] -= DOG_SIZE;
	        }

	        if (downDirection) {
	            y[0] += DOG_SIZE;
	        }
	    }
	   
	   
	   
	   private void checkCollision() {

	    	for (int z = dogs; z > 0; z--) {

	    	    if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
	    	        isRunning = false;
	    	    }
	    	}

	        if (y[0] >= B_HEIGHT) {
	            isRunning = false;
	        }

	        if (y[0] < 0) {
	            isRunning = false;
	        }

	        if (x[0] >= B_WIDTH) {
	            isRunning = false;
	        }

	        if (x[0] < 0) {
	            isRunning = false;
	        }
	        
	        if (!isRunning) {
	            
	        }
	    }
	   
	   
	   @Override
	   public void actionPerformed(ActionEvent e) {

	        if (isRunning) {
	            checkCollision();
	            move();
	        }
	        repaint();
	    }
	   
	   private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyPressed(KeyEvent e) {

	            int key = e.getKeyCode();
	            
	            if ((key == KeyEvent.VK_W) && (!upDirection)) {
	                downDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            }
	            
	            if ((key == KeyEvent.VK_D) && (!rightDirection)) {
	                leftDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_A) && (!leftDirection)) {
	                rightDirection = true;
	                upDirection = false;
	                downDirection = false;
	            }

	            if ((key == KeyEvent.VK_S) && (!downDirection)) {
	                upDirection = true;
	                rightDirection = false;
	                leftDirection = false;
	            } 
	            if ((key == KeyEvent.VK_1 && (!isRunning))) {
	            	
	            	
	            }
	        }
	    }
	

}