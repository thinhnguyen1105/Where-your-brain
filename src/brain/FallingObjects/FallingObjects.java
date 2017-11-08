package brain.FallingObjects;


import bases.GameObject;
import bases.physics.BoxCollider;
import brain.FallingObjects.shapes.Circle;
import brain.FallingObjects.shapes.Diamond;
import brain.FallingObjects.shapes.Square;
import brain.FallingObjects.shapes.Triangle;
import brain.background.LifesOfPlayer;


public class FallingObjects extends GameObject {
    public BoxCollider hitBox;
    public static int currentType;

    public static int Speed = 5;

    public static final int CIRCLE = 0;
    public static final int SQUARE = 1;
    public static final int DIAMOND = 3;
    public static final int TRIANGLE = 2;

    public FallingObjects(){
        hitBox = new BoxCollider(5,5);


    }

    public static FallingObjects create(int type) {
        if (type == CIRCLE) {
            currentType = type;
            return new Circle();
        }
        if(type == SQUARE){
            currentType = type;
            return new Square();

        }
        if (type == DIAMOND){
            currentType = type;
            return new Diamond();
        }
        if(type == TRIANGLE){
            currentType = type;
            return  new Triangle();
        }
        return null;

    }
    public void run(){
        this.position.addUp(0,Speed);
        this.hitBox.position.set(this.position);
        checkLife();
    }

    public void checkLife() {
        if (this != null) {
            if (this.position.y > 600 && this.isActive) {
                LifesOfPlayer.minusLife();
                System.out.println(LifesOfPlayer.life);
//                LifesOfPlayer.isActive = false;
                GameObject.remove(this);
            }
        }
        if(LifesOfPlayer.life <= 0){
            LifesOfPlayer.gameOver();
        }
    }

}
