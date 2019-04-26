import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Character {
	private static BufferedImage spriteSheet;
	private String direction = "down";
	private int clicks = 0;

	public Player() {
		super(getImage(60,0,15,15), getImage(90,30,15,15), getImage(0,0,15,15), getImage(30,0,15,15), 
				getImage(60,30,15,15), getImage(90,0,15,15), getImage(0,30,15,15), getImage(30,30,15,15),100, 100, 50);
	}
	
	private static Image getImage(int x, int y, int w, int h) {
		try {
			spriteSheet = ImageIO.read(new File("link.png"));
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
	
	public void keyHit(String s) {
		if (s.equals("left")) {
			getRect().translate(-10, 0);
			direction = "left";
			clicks++;
		}
		else if (s.equals("right")) {
			this.getRect().translate(10, 0);
			direction = "right";
			clicks++;
		}
		else if (s.equals("up")) {
			this.getRect().translate(0, -10);
			direction = "up";
			clicks++;
		}
		else if (s.equals("down")) {
			this.getRect().translate(0, 10);
			direction = "down";
			clicks++;
		}
	}
	
	
}

