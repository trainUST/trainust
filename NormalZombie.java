import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NormalZombie extends Zombie {
	private int health=5;
	private int speed=10;
	private int score=10;
	
	public int getSpeed() {
		return speed;
	}
	
	public static void main(String[] args) {
		
		
	    EventQueue.invokeLater(new Runnable() {
	      @Override
	      public void run() {
	        JFrame frame = new JFrame();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.add(new BackgroundPane());
	        frame.pack();
	        frame.setVisible(true);
	      }
	    });
	  }
	}

	class BackgroundPane extends JPanel {
		Zombie zombie=new NormalZombie();
	  private BufferedImage bg;
	  
	  private int xOffset = -600;
	  private int xDelta = 4;

	  public BackgroundPane() {
	    try {
	      bg = ImageIO.read(new File("Zombie1.png"));
	      
	      
	 
	    } catch (Exception ex) {
	      ex.printStackTrace();
	    }
	    
	    Timer timer = new Timer(zombie.getSpeed(), new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	        xOffset += xDelta;
	       
	        repaint();
	      }
	    });
	    timer.start();
	  }

	  @Override
	  public Dimension getPreferredSize() {
	    return new Dimension(1000,1000);
	  }

	  @Override
	  protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g.create();

	    zombie.setxCoord(xOffset);
	    
	    zombie.setyCoord(0);
	    		
	    

	    
	    while (zombie.getyCoord() < getHeight()) {
	      g2d.drawImage(bg, -zombie.getxCoord(), zombie.getyCoord(), this);
	      zombie.setyCoord(zombie.getyCoord() + bg.getHeight());
	    }

	    g2d.dispose();
	  }

}
