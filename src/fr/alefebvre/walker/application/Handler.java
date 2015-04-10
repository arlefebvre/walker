package fr.alefebvre.walker.application;

import fr.alefebvre.walker.gameObject.GameObject;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    protected LinkedList<GameObject> objects = new LinkedList<>();

    public LinkedList<GameObject> getObjects() {
        return objects;
    }

    public void tick() {
        objects.forEach(GameObject::tick);
    }

    public void render(Graphics g) {
        objects.forEach(gameObj -> gameObj.render(g));
    }
}
