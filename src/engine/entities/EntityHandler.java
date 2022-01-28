package engine.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityHandler {

	private float g;
	private List<Entity> entities;
	
	public EntityHandler(float g) {
		this.g = g;
		entities = new ArrayList<Entity>();
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity e = it.next();
			e.dy += g;
			e.tick();
			if (e.isDead()) {
				it.remove();
			}
		}
	}
	
	public void draw(Graphics g) {
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity e = it.next();
			e.draw(g);
		}
	}
	
	public List<Entity> getEntities() {
		return entities;
	}
}
