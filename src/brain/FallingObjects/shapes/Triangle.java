package brain.FallingObjects.shapes;


import bases.GameObject;
import bases.ImageRenderer;
import brain.FallingObjects.FallingObjects;
import brain.background.LifesOfPlayer;
import brain.background.Score;
import brain.playershape.PlayerLeftShape;
import brain.playershape.PlayerRightShape;

public class Triangle extends FallingObjects {

    public final int type = 2;

    public Triangle(){
        super();
        this.renderer = new ImageRenderer("assets/shape/Triangle.png");
    }

    @Override
    public void run() {
        super.run();
        collide();
    }
    public void collide(){
        if(this.position.x < 200){
            if(this.hitBox.collideWith(PlayerLeftShape.boxCollider) && this.type == PlayerLeftShape.currentType){
                Score.addScore(1);
                this.isActive = false;
                GameObject.remove(this);
            }
        }
        if(this.position.x > 200){
            if(this.hitBox.collideWith(PlayerRightShape.boxCollider) && this.type == PlayerRightShape.currentType ){
                Score.addScore(1);
                GameObject.remove(this);
            }
        }

    }

}
