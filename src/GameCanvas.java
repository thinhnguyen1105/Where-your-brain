import bases.GameObject;
import bases.SceneManager;
import brain.background.*;
import brain.scenes.GameStartScene;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by duyanh on 10/31/17.
 */
public class GameCanvas extends JPanel {

    BufferedImage backBuffer;
    Graphics backGraphics;
    Score score = new Score();

    public GameCanvas(){
        backBuffer = new BufferedImage(384,600, BufferedImage.TYPE_INT_ARGB);

        backGraphics = backBuffer.getGraphics();
        SceneManager.changeScene(new GameStartScene());

    }

    public void run() {

        GameObject.runAll();
        SceneManager.changeSceneIfNeeded();

    }

    public void render() {

        GameObject.renderAll(backGraphics);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        g.drawImage(backBuffer,0,0,null);

    }
}
