import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Character {
	private Image upMoveImg;
	private Image rightMoveImg;
	private Image downMoveImg;
	private Image leftMoveImg;
	private Image upImg;
	private Image rightImg;
	private Image downImg;
	private Image leftImg;
	private Rectangle rect;
	
	public Character (Image up, Image right, Image down, Image left, 
			Image moveU, Image moveR, Image moveD, Image moveL, int x, int y, int w) {
		upImg = up;
		rightImg = right;
		downImg = down;
		leftImg = left;
		upMoveImg = moveU;
		rightMoveImg = moveR;
		downMoveImg = moveD;
		leftMoveImg = moveL;
		
		rect = new Rectangle(x,y,w,w);
	}
	
	public Image getUpImg() {
		return upImg;
	}
	
	public Image getLeftImg() {
		return leftImg;
	}
	
	public Image getDownImg() {
		return downImg;
	}
	
	public Image getRightImg() {
		return rightImg;
	}
	
	public Image getUpMoveImg() {
		return upMoveImg;
	}
	
	public Image getLeftMoveImg() {
		return leftMoveImg;
	}
	
	public Image getDownMoveImg() {
		return downMoveImg;
	}
	
	public Image getRightMoveImg() {
		return rightMoveImg;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	//enemies: darknut,ghini, gibdo, goriya, keese, lynel, moblin, octorok, rope, stalfos, 
}
