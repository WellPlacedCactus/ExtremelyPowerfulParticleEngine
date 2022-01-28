package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.Engine;

public class Entity {

	private boolean dead = false;
	
	public float x;
	public float y;
	public float w;
	public float h;
	public float c;
	public float dx;
	public float dy;
	public float dwh;
	public float dc;
	
	public Entity(float x, float y, float w, float h, float c, float dx, float dy, float dwh, float dc) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
		this.dx = dx;
		this.dy = dy;
		this.dwh = dwh;
		this.dc = dc;
	}
	
	private void die() {
		dead = true;
	}
	
	public void tick() {
		
		// MOVE X //
		
		x += dx;
		
		// MOVE Y AND BOUNCE OFF THE FLOOR //
		
		y += dy;
		
		if (dy > 0) {
			if (y + h > Engine.HEIGHT) {
				dy *= -1;
				y = Engine.HEIGHT - h;
			}
		}
		
		// RESIZE AND DIE IF TOO SMALL //
		
		w += dwh;
		h += dwh;
		
		if (w < 0 || h < 0) die();
		
		// CHANGE COLOR //
		
		c += dc;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.getHSBColor(c * 0.01f, 1, 1));
		g.fillRect(
			(int) (x - w / 2),
			(int) (y - h / 2),
			(int) w,
			(int) h);
	}
	
	public boolean isDead() {
		return dead;
	}
}
