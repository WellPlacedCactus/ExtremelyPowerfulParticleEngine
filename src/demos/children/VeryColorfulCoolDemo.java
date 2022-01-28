package demos.children;

import java.awt.Graphics;

import demos.Demo;
import engine.entities.Entity;
import engine.entities.EntityHandler;
import engine.input.Mouse;

public class VeryColorfulCoolDemo extends Demo {

	private EntityHandler handler;
	
	public VeryColorfulCoolDemo() {
		handler = new EntityHandler();
	}
	
	private void emit() {
		if (Mouse.down) {
			for (int i = 0; i < 100; i++) {
				handler.add(new Entity(
					Mouse.x,
					Mouse.y,
					(float) (20 + 5 * Math.random()),
					(float) (20 + 5 * Math.random()),
					0,
					(float) (Math.random() * Math.PI * 2),
					5,
					-0.1f,
					0.01f,
					0,
					(float) (-0.05 * Math.random())
				));
			}
		} 
	}
	
	public void tick() {
		emit();
		handler.tick();
	}
	
	public void draw(Graphics g) {
		handler.draw(g);
	}
}
