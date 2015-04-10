package fr.alefebvre.walker.application;

import fr.alefebvre.walker.gameObject.BackgroundMap;
import fr.alefebvre.walker.gameObject.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public static final int SCALEDWIDTH = WIDTH * SCALE;
    public static final int SCALEDHEIGHT = HEIGHT * SCALE;
   // public final static int TILESIZE = 32;
    public static final long serialVersionUID = 1L;
    public final String TITLE = "Walker";
    private boolean running = false;
    private Thread thread;
    private Handler gameHandler;
    public Game() {
        this.setPreferredSize(new Dimension(SCALEDWIDTH, SCALEDHEIGHT));

        gameHandler = new Handler();
        this.addKeyListener(new KeyInput(gameHandler));
        initialize();
//		gameHandler.addGameObject(new BackgroundMap(0, 0,"images/map.png"));
//		gameHandler.addGameObject(new Player(WIDTH, HEIGHT, GameObjectId.Player,0, 0));
    }

    public void initialize() {
        gameHandler.getObjects().clear();
        //gameHandler.getObjects().add(new TilesMap(0,0));
        gameHandler.getObjects().add(new BackgroundMap(0, 0, "resources/images/map.png"));
       gameHandler.getObjects().add(new Player(WIDTH, HEIGHT, 0, 0));
      //  gameHandler.addGameObject(new Enemy(WIDTH, HEIGHT, 0, 0));
       // gameHandler.addGameObject(new Menu(SCALEDWIDTH / 2 - 50, SCALEDHEIGHT / 2 - 150));
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

    @Override
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
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
        this.gameHandler.render(g);
        g.dispose();
        bs.show();
    }
}
