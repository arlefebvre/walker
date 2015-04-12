package fr.alefebvre.walker.gameObject;

import java.awt.*;

public abstract class BasicGameObject {

    protected int x, y;

    protected boolean visible = false;
    protected GameObjectId id;
    protected int velX, velY;

    public BasicGameObject(int x, int y, GameObjectId id) {
        super();
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public BasicGameObject(int x, int y, GameObjectId id, int velX, int velY) {
        this(x, y, id);
        this.velX = velX;
        this.velY = velY;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public GameObjectId getId() {
        return id;
    }

    public void setId(GameObjectId id) {
        this.id = id;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

}
