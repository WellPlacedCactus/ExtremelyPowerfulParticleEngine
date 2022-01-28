package engine.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntityHandler {

	private List<Entity> entities;
	
	public EntityHandler() {
		entities = new ArrayList<Entity>();
	}
	
	public void add(Entity e) {
		entities.add(e);
	}
	
	public void tick() {
		Iterator<Entity> it = entities.iterator();
		while (it.hasNext()) {
			Entity e = it.next();
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
