package demos.children;

import java.awt.Graphics;

import demos.Demo;
import engine.entities.Entity;
import engine.entities.EntityHandler;

public class TestDemo extends Demo {

	private EntityHandler handler;
	
	public TestDemo() {
		handler = new EntityHandler(1);
		handler.add(new Entity(
			100,
			100,
			50,
			100,
			180,
			0,
			0,
			0,
			1
		));
	}
	
	public void tick() {
		handler.tick();
	}
	
	public void draw(Graphics g) {
		handler.draw(g);
	}
}
