import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Octorok extends Character {
	private static BufferedImage spriteSheet;
	private String direction = "down";
	private int clicks = 0;

	public Octorok() {
		super(getImage(60,0,20,20), getImage(90,0,20,20), getImage(0,0,20,20), getImage(30,0,20,20), 
				getImage(60,30,20,20), getImage(90,30,20,20), getImage(0,30,20,20), getImage(30,30,20,20),100, 200, 50, 50);
	}
	
	private static Image getImage(int x, int y, int w, int h) {
		try {
			spriteSheet = ImageIO.read(new File("enemies.png"));
		} catch (IOException e) {
			e.printStackTrace();		
		}
		return ((BufferedImage)spriteSheet).getSubimage(x,y,w,h).getScaledInstance(w, h, BufferedImage.SCALE_SMOOTH);
	}

	public void draw(Graphics g) {
		if (direction.equals("up")) {
			if (clicks%2 ==0)
				g.drawImage(getUpMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getUpImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("right")) {
			if (clicks%2 ==0) 
				g.drawImage(getRightMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getRightImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("down")) {
			if (clicks%2 ==0)
				g.drawImage(getDownMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getDownImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
		else if (direction.equals("left")) {
			if (clicks%2 ==0)
				g.drawImage(getLeftMoveImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
			else 
				g.drawImage(getLeftImg(),(int)(getRect().getX()),(int)(getRect().getY()),(int)(getRect().getWidth()),(int)(getRect().getWidth()), null);
		}
	}
}
