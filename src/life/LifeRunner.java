package life;

import javafx.application.Application;

/**
 * Created by Вадик on 24.11.2015.
 */
public class LifeRunner {
    static int size = 50; //размер игрового поля
    static int[][] field = new int[size][size]; //игровое поле



    public int getFieldSize(){
        return size;
    }


    public static void main(String[] args) {
        Main.main(args);
    }

}
