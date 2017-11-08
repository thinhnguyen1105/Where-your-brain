package brain;

import bases.GameObject;

public class Score extends GameObject {

    public static int score;
    public Score(){
        score = 0;
    }
    public static void addScore(int num){
        score+=num;
    }
}
