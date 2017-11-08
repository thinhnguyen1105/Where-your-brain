package bases;

import brain.FallingObjects.FallingObjects;
import brain.FallingObjects.shapes.Circle;
import brain.FallingObjects.shapes.Diamond;
import brain.FallingObjects.shapes.Square;
import brain.FallingObjects.shapes.Triangle;
import brain.traps.Traps;

import java.awt.*;
import java.util.Vector;

/**
 * Created by duyanh on 10/31/17.
 */
public class GameObject {
    public Vector2D position;


    public Renderer renderer;

    public boolean isActive;

    static Vector<GameObject> gameObjects = new Vector<>();

    static Vector<GameObject> newGameObjects = new Vector<>();

    static Vector<GameObject> rmGameObects = new Vector<>();

    public GameObject() {
        position = new Vector2D();
        isActive = true;
    }

    public static void add(GameObject gameObject) {
        newGameObjects.add(gameObject);
    }

    public void render(Graphics g) {
        if (renderer != null) {
            renderer.render(g, position);
        }
    }

    public void run() {

    }

    public static void runAll() {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive) {
                gameObject.trapDetector();
                gameObject.run();
            }
        }
        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
        gameObjects.removeAll(rmGameObects);
        rmGameObects.clear();
    }

    public static void remove(GameObject gameObject) {
        rmGameObects.add(gameObject);
    }

    public static void renderAll(Graphics g) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.isActive) {
                gameObject.render(g);
            }
        }
    }

    public void trapDetector() {
        if (this instanceof FallingObjects) {
            for (GameObject gameObject : gameObjects) {
                if (gameObject instanceof Traps && gameObject.isActive) {
                    if (((FallingObjects) this).hitBox.collideWith(((Traps) gameObject).hitBox)) {
                        gameObject.isActive = false;
                        ((FallingObjects) this).isActive = false;
                        FallingObjects newobj = FallingObjects.changeShape(typeCheck(this));
                        newobj.position.set(this.position);
                        GameObject.add(newobj);
                    }
                }
            }
        }
    }
    public int typeCheck(GameObject gameObject){
        if(gameObject instanceof Circle){
            return 0;
        }
        if(gameObject instanceof Diamond){
            return 3;
        }
        if(gameObject instanceof Square){
            return 1;
        }
        if(gameObject instanceof Triangle){
            return 2;
        }
        return -1;
    }

    public static <T extends GameObject> T recycle(Class<T> cls){
        for(GameObject gameObject:gameObjects){
            if(gameObject.isActive==false && gameObject.getClass().equals(cls)){
                gameObject.isActive=true;
                return (T)gameObject;
            }
        }
        try {
            T newGameObject=  cls.newInstance();//new
            return newGameObject;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
