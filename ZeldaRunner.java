import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import java.io.*;
import javax.sound.sampled.*;





public class ZeldaRunner {
	static Player link = new Player();
	JPanel panel;
	Timer timer;
	boolean soundOn=false;
	boolean alive=true;
	static Clip audio;
	int t = 0;
	Clip audioAlive=get("overworld.wav");
	Clip audioDungeon=get("dungeon.wav");
	Clip audioGameOver=get("gameover.wav");
	
	public static void main(String[] args) {
		new ZeldaRunner().start();
	}

	private void start() {
		JFrame frame = new JFrame("Runner");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawAll(g);
			}
		};
		panel.setPreferredSize(new Dimension(800,600));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(150, 0);
		frame.setSize(1137, 622);
		mapKeyStrokesToActions(panel);
		
		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				updateGame();
				panel.repaint();
			}
		});
		timer.start();
	}

	protected void updateGame() {
		if (audioAlive.isRunning()==true||audioDungeon.isRunning()==true||audioGameOver.isRunning()==true) {
			soundOn=true;
		}else {
			soundOn=false;
		}
		while (soundOn==false&&alive==true) {
			audioAlive.loop(Clip.LOOP_CONTINUOUSLY);
		}
		if (soundOn==false&&alive==false) {
			audioGameOver.start();
		}
		while (alive==false) {
			if (audioAlive.isRunning()==true) {
				audioAlive.stop();	
			}
			audioGameOver.start();
		}
		t++;
		}

	private void mapKeyStrokesToActions(JPanel panel) {
		ActionMap map = panel.getActionMap();
		InputMap inMap = panel.getInputMap();

		inMap.put(KeyStroke.getKeyStroke("pressed UP"), "up");
		map.put("up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hit("up");

			}

			
		});
		panel.getInputMap().put(KeyStroke.getKeyStroke("LEFT"),"left");
		panel.getActionMap().put("left",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("left");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("RIGHT"),"right");
		panel.getActionMap().put("right",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("right");
			}
		});
		
		panel.getInputMap().put(KeyStroke.getKeyStroke("DOWN"),"down");
		panel.getActionMap().put("down",new AbstractAction(){

			@Override
			public void actionPerformed(ActionEvent e) {
				hit("down");
			}
		});
		

	}
	public  void hit(String s) {
		link.keyHit(s);
		panel.repaint();
	}
	
	protected static void drawAll(Graphics g) {
		link.draw(g);
		
	}
	public static Clip get(String filename){
		Clip audios = null;
		try
	    {
	        audios = AudioSystem.getClip();
	        audios.open(AudioSystem.getAudioInputStream(new File(filename)));
	        return audios;
	    }
	    catch (Exception exc)
	    {
	        exc.printStackTrace(System.out);
	    }
		return audios;
	}
	/*public boolean checkWav(String filename){
		try
	    {
	        Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(filename)));
	        if(clip.isActive()==true) {
		    	return true;
	        	}
	        	return false;   	
		   // }
	   // }
	    //catch (Exception exc)
	    {
	        //exc.printStackTrace(System.out);
	    }
	    
	}*/

}
