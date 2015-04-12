package fr.alefebvre.walker.gameObject;


import java.awt.*;

public abstract class GameObject extends BasicGameObject {

    protected boolean youShallNotPass;

    public GameObject(int x, int y, GameObjectId id) {
        super(x, y, id);
    }

    public GameObject(int x, int y, GameObjectId id, int velX, int velY) {
        super(x, y, id, velX, velY);
    }

    public boolean isYouShallNotPass() {
        return youShallNotPass;
    }

    public abstract Rectangle getBounds();
}
