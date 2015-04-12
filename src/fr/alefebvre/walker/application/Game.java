package fr.alefebvre.walker.application;

import fr.alefebvre.walker.common.Constants;
import fr.alefebvre.walker.gameObject.Player;
import fr.alefebvre.walker.gameObject.map.TilesMap;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    public static final long serialVersionUID = 1L;

    private boolean running = false;
    private Thread thread;
    private GameHandler gameHandler;

    public Game() {
        this.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));

        gameHandler = new GameHandler();
        this.addKeyListener(new KeyInput(gameHandler));
        initialize();
    }

    public void initialize() {
        gameHandler.getObjects().clear();
        gameHandler.addMap(new TilesMap(0, 0, Constants.TEST_MAP_PATH));
        gameHandler.getObjects().add(new Player(0, 0, 0, 0, gameHandler));
    }

    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        this.gameHandler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        this.gameHandler.render(g);
        g.dispose();
        bs.show();
    }
}
