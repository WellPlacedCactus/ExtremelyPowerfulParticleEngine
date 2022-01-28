package engine.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Entity {

	private boolean dead = false;
	
	public float x;
	public float y;
	public float w;
	public float h;
	public float c;
	public float d;
	public float m;
	public float dwh;
	public float dc;
	public float dd;
	public float dm;
	
	public Entity(float x, float y, float w, float h, float c, float d, float m, float dwh, float dc, float dd, float dm) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.c = c;
		this.d = d;
		this.m = m;
		this.dwh = dwh;
		this.dc = dc;
		this.dd = dd;
		this.dm = dm;
	}
	
	private void die() {
		dead = true;
	}
	
	public void tick() {
		
		// MOVE //
		
		x += m * Math.cos(d);
		y += m * Math.sin(d);
		
		// RESIZE AND DIE IF TOO SMALL //
		
		w += dwh;
		h += dwh;
		
		if (w < 0 || h < 0) die();
		
		// CHANGE COLOR //
		
		c += dc;
		
		// SCALE VECTORS AND DIE IF TOO SLOW //
		
		d += dd;
		m += dm;
		
		if (m < 0) die();
	}
	
	public void draw(Graphics g) {
		Rectangle2D.Float rect = new Rectangle2D.Float(
			x - w / 2,
			y - h / 2,
			w,
			h
		);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.getHSBColor(c, 1, 1));
		g2d.fill(rect);
	}
	
	public boolean isDead() {
		return dead;
	}
}
