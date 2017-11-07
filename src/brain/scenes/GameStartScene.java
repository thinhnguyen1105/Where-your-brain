package brain.scenes;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Scene;
import bases.SceneManager;
import brain.input.InputManager;

public class GameStartScene extends GameObject implements Scene {

    @Override
    public void run() {
        InputManager inputManager = InputManager.instance;
        if(inputManager.spacePressed){
            SceneManager.changeScene(new GamePlayScene());
        }
    }

    @Override
    public void init() {
        GameObject sceneGameStart = new GameObject();
        sceneGameStart.renderer = new ImageRenderer("assets/images/Scenes/GameStartScene.png");
        sceneGameStart.position.set(192,300);
        GameObject.add(sceneGameStart);
        GameObject.add(new GameStartScene());
    }

    @Override
    public void deinit() {
        GameObject.clearAll();
    }
}
