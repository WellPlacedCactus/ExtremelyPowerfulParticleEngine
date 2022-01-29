package engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

import demos.Demo;
import engine.graphics.Display;
import engine.input.Keyboard;

public class Engine implements Runnable {

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	public static final String TITLE = "ExtremelyPowerfulParticleEngine";
	
	private Display display;
	private Thread thread;
	private BufferStrategy bs;
	private Graphics g;
	
	private Demo demo;
	
	public Engine(Demo demo) {
		this.demo = demo;
		createDisplay();
		start();
	}
	
	private void createDisplay() {
		display = new Display(WIDTH, HEIGHT, TITLE);
	}
	
	public void tick() {
		
		if (Keyboard.keys[KeyEvent.VK_ESCAPE]) {
			stop("Keyboard Escape");
		}
		
		demo.tick();
	}
	
	public void draw() {
		bs = display.getBs();
		if (bs == null) {
			display.createBufferStrategy(2);
			return;
		}
		g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		demo.draw(g);
		
		bs.show();
		g.dispose();
	}
	
	public synchronized void start() {
		thread = new Thread(this, TITLE + " THREAD");
		thread.start();
	}
	
	public synchronized void stop(String error) {
		System.out.println(error);
		System.exit(0);
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while (true) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				draw();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
	}
}
