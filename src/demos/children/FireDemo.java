package demos.children;

import java.awt.Graphics;

import demos.Demo;
import engine.entities.Entity;
import engine.entities.EntityHandler;
import engine.input.Mouse;

public class FireDemo extends Demo {

	private EntityHandler handler;
	private float a = 0;
	
	public FireDemo() {
		handler = new EntityHandler(0.1f);
	}
	
	public void tick() {
		if (Mouse.down) {
			a += 0.1;
			for (int i = 0; i < 360; i += 180) {
				handler.add(new Entity(
					Mouse.x,
					Mouse.y,
					25,
					25,
					i,
					(float) (10 * Math.cos(i * Math.PI / 180 + a)),
					(float) (10 * Math.sin(i * Math.PI / 180 + a)),
					-0.5f,
					0
				));
			}
		}
		handler.tick();
	}

	public void draw(Graphics g) {
		handler.draw(g);
	}
}
