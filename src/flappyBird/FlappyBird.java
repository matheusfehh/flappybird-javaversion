package flappyBird;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class FlappyBird implements ActionListener {

	public static FlappyBird flappyBird;
	public final int WIDTH = 800, HEIGHT = 800;
	public Renderer renderer;
	public Rectangle bird;
	
	public FlappyBird() {
		JFrame jFrame = new JFrame();
		Timer timer = new Timer(20, this);
		
		renderer = new Renderer();
		
		jFrame.add(renderer);
		jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setTitle("Flappy Bird - Java Version");
		jFrame.setResizable(false);
		jFrame.setVisible(true);
		
		bird = new Rectangle(WIDTH / 2 - 10, HEIGHT / 2 - 10, 20, 20);
		
		timer.start();
	}
	
	public static void main(String[] args) {
		flappyBird = new FlappyBird();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		renderer.repaint();
	}
	
	public void paintColumn(Graphics g, Rectangle column) {
		g.setColor(Color.GREEN.darker());
		g.fillRect(column.x, column.y, column.width, column.height);
	}

	public void repaint(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		g.setColor(Color.ORANGE);
		g.fillRect(0, HEIGHT - 150, WIDTH, 150);
		
		g.setColor(Color.GREEN);
		g.fillRect(0, HEIGHT - 150, WIDTH, 20);
		
		g.setColor(Color.RED);
		g.fillRect(bird.x, bird.y, bird.width, bird.height);
	}
	
}