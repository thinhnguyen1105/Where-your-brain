package bases;

import brain.FallingObjects.FallingObjects;

import java.awt.*;
import java.util.Vector;

/**
 * Created by duyanh on 10/31/17.
 */
public class GameObject {
    public Vector2D position;

    
    public Renderer renderer;
    
    public static boolean isActive;
    
    static Vector<GameObject> gameObjects = new Vector<>();
    
    static Vector<GameObject> newGameObjects = new Vector<>();

    static Vector<GameObject> rmGameObects = new Vector<>();

    public GameObject(){
        position = new Vector2D();
        isActive = true;
    }
    public static void add(GameObject gameObject){
        newGameObjects.add(gameObject);
    }

    public void render(Graphics g) {
        if(renderer != null){
            renderer.render(g,position);
        }
    }

    public void run() {

    }
    
    public static void runAll(){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive){
                gameObject.run();
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        gameObjects.removeAll(rmGameObects);
        rmGameObects.clear();
    }

    public static void remove(GameObject gameObject){
        rmGameObects.add(gameObject);
    }

    public static void renderAll(Graphics g){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive){
                gameObject.render(g);
            }
        }
    }

    public static void clearAll() {
        gameObjects.clear();
        newGameObjects.clear();
    }
}
