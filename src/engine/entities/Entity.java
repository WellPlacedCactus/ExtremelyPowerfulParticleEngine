package engine.entities;

import java.awt.Color;
import java.awt.Graphics;

import engine.Engine;

public class Entity {

	private boolean dead = false;
	
	public int x;
	public int y;
	public int w;
	public int h;
	public int c;
	public int dx;
	public int dy;
	public int dwh;
	public int dc;
	
	public Entity(int x, int y, int w, int h, int c, int dx, int dy, int dwh, int dc) {
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
		g.fillRect(x, y, w, h);
	}
	
	public boolean isDead() {
		return dead;
	}
}
