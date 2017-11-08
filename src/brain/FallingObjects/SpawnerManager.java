package brain.FallingObjects;

import bases.GameObject;
import bases.Vector2D;
import bases.actions.Action;
import bases.actions.ActionRepeatForever;
import bases.actions.ActionSequence;
import bases.actions.ActionWait;
import brain.background.Score;

public class SpawnerManager extends GameObject {
    boolean checkObject;
    public SpawnerManager(){

        Action waitAction = new ActionWait(1000);
        Action fallingLeftAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                Spawner leftSpawner = new Spawner(new Vector2D(105,-20));
                GameObject.add(leftSpawner);
                return true;
            }

            @Override
            public void reset() {
                
            }
        };

        Action fallingRightAction = new Action() {
            @Override
            public boolean run(GameObject owner) {
                fallingLeftAction.reset();
                Spawner rightSpawner = new Spawner(new Vector2D(300,-20));
                GameObject.add(rightSpawner);

                return true;
            }

            @Override
            public void reset() {

            }
        };


        Action actionSequence = new ActionSequence(fallingLeftAction,waitAction,fallingRightAction);
        Action actionRepeat = new ActionRepeatForever(actionSequence);
        this.addAction(actionRepeat);

    }
}
