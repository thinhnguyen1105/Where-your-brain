package brain.traps;

import bases.GameObject;
import bases.ImageRenderer;

import java.util.concurrent.ThreadLocalRandom;

public class ShapeShifting extends GameObject implements Traps {
    int random = ThreadLocalRandom.current().nextInt(0,2);

    public ShapeShifting(){
        this.position.set(randomX[random], ThreadLocalRandom.current().nextInt(100,400));
        this.hitBox.position.set(this.position);
        this.renderer = new ImageRenderer("assets/images/trap/23201931_692271330979364_1884482132_n.png");
    }
}
