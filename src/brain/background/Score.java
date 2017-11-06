package brain.background;

import bases.GameObject;
import com.sun.javafx.text.TextLine;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Score extends GameObject {

    public static int score;

    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Moonshiner",Font.BOLD,30));
        g.drawString("Score : " +Score.score,290,40);
    }

    public Score(){
        score = 0;
        this.position.set(250,50);
    }


    public static void addScore(int num){
        score+=num;
    }
}
