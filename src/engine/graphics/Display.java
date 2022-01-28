package engine.graphics;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import engine.input.Keyboard;
import engine.input.Mouse;

public class Display {

	private JFrame frame;
	private Canvas canvas;
	private int width;
	private int height;
	private String title;

	public Display(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;
		createFrame();
		createCanvas();
		addMouseInput();
		addKeyInput();
	}
	
	private void createFrame() {
		frame = new JFrame();
		frame.setTitle(title);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void createCanvas() {
		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setLocation(0, 0);
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void addMouseInput() {
		Mouse mouse = new Mouse();
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
	}
	
	private void addKeyInput() {
		Keyboard keys = new Keyboard();
		frame.addKeyListener(keys);
		canvas.addKeyListener(keys);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String getTitle() {
		return title;
	}
	
	public BufferStrategy getBs() {
		return canvas.getBufferStrategy();
	}
	
	public Graphics getG() {
		return canvas.getGraphics();
	}
	
	public void createBufferStrategy(int buffers) {
		canvas.createBufferStrategy(buffers);
	}
}
