package fr.alefebvre.walker.application;

import fr.alefebvre.walker.gameObject.BasicGameObject;
import fr.alefebvre.walker.gameObject.GameObject;
import fr.alefebvre.walker.gameObject.map.TilesMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameHandler {

    protected CopyOnWriteArrayList<GameObject> objects = new CopyOnWriteArrayList<>();

    protected BasicGameObject map = null;

    public CopyOnWriteArrayList<GameObject> getObjects() {
        return objects;
    }

    public void tick() {
        objects.forEach(GameObject::tick);
    }

    public void render(Graphics g) {
        objects.forEach(gameObj -> gameObj.render(g));
    }

    public void addMap(TilesMap newMap) {
        this.map = newMap;
        objects.addAll(newMap.getTiles());
    }
}
