package brain.background;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Renderer;
import bases.SceneManager;
import brain.scenes.GameOverScene;
import brain.scenes.GamePlayScene;

import java.awt.*;

public class LifesOfPlayer extends GameObject {
    public static int life = 3;
    int lifeX = 20;
    int lifeY = 20;
    ImageRenderer lifesOfPlayer;

    public LifesOfPlayer() {
        this.position.set(lifeX, lifeY);
        lifesOfPlayer = new ImageRenderer("assets/images/background/life.png");
    }

    public static void minusLife() {
        life--;
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < life; i++) {
            g.drawImage(lifesOfPlayer.image, lifeX + i * 50, lifeY, null);
        }
    }

    public static void gameOver() {
        SceneManager.changeScene(new GameOverScene());
    }
}
