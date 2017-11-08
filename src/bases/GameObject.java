package bases;

import bases.actions.Action;
import brain.FallingObjects.FallingObjects;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by duyanh on 10/31/17.
 */
public class GameObject {
    public Vector2D position;

    
    public Renderer renderer;
    
    public static boolean isActive;

    public ArrayList<Action> actions;
    public ArrayList<Action> newActions;
    
    static Vector<GameObject> gameObjects = new Vector<>();
    
    static Vector<GameObject> newGameObjects = new Vector<>();

    static Vector<GameObject> rmGameObects = new Vector<>();

    public GameObject(){
        position = new Vector2D();
        isActive = true;
        actions = new ArrayList<>();
        newActions = new ArrayList<>();
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

    public void runActions(){
        // run for all actions and if run return true then remove it
        this.actions.removeIf(action -> action.run(this));
        this.actions.addAll(newActions);
        newActions.clear();
    }

    public void addAction(Action action){
        newActions.add(action);
    }
    
    public static void runAll(){
        for(GameObject gameObject : gameObjects){
            if(gameObject.isActive){
                gameObject.run();
                gameObject.runActions();
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
