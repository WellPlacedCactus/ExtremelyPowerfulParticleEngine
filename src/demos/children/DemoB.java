package demos.children;

import java.awt.Graphics;

import demos.Demo;
import engine.entities.Entity;
import engine.entities.EntityHandler;
import engine.input.Mouse;

public class DemoB extends Demo {

	private EntityHandler handler;
	private float a;
	
	public DemoB() {
		handler = new EntityHandler();
		a = 0;
	}
	
	private void emit() {
		a += 1;
		if (Mouse.down) {
			for (int i = 0; i < 360; i += 60) {
				handler.add(new Entity(
					Mouse.x,
					Mouse.y,
					50,
					50,
					0,
					(float) (i * Math.PI / 180 + a),
					5,
					(float) Math.random() * -1f,
					(float) 0.01f,
					(float) Math.random() * -0.1f,
					(float) -0.1f
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
