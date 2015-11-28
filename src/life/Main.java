package life;

import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

public class Main extends Application  {


    @Override
    public void start(Stage primaryStage) {

        BorderPane borderPane = new BorderPane();
        borderPane.getStylesheets().add(Main.class.getResource("life.css").toExternalForm());
        ScrollPane scrollPane = new ScrollPane();
        borderPane.setCenter(scrollPane);


        HBox hbox = new HBox(300);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.getStyleClass().add("hbox");
        borderPane.setTop(hbox);

        Button btn = new Button();
        btn.setText("New Game");
        btn.getStyleClass().add("button1");
        hbox.getChildren().add(btn);

        Button edit = new Button("Edit");
        edit.getStyleClass().add("button1");
        hbox.getChildren().add(edit);

        final GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(10, 0, 10, 0));
        gridPane.setGridLinesVisible(true);
        gridPane.setVisible(true);
        scrollPane.setContent(gridPane);

        LifeRunner life = new LifeRunner(); // TODO возможно, main переедет в LifeRunner класс
        ArrayList<Actor> actorArrayList = new ArrayList<>();
        for (int i = 0; i < LifeRunner.size; i++) {
            for (int j = 0; j < LifeRunner.size; j++) {
                final Actor actor = new Actor();
                actorArrayList.add(i + j, actor);//—оздаем нового актера
              //  actor.setDead();
                gridPane.add(actor.getPic(), i, j); //¬т€гиваем картинку на позицию
                actor.getPic().setOnMouseClicked(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent arg0) {
                        GridPane.getRowIndex(actor.getPic());
                        GridPane.getColumnIndex(actor.getPic());
                        if (actor.isAlive()) {
                            actor.setDead();
                        } else {
                            actor.setAlive();
                        }

                    }

                });

            }
            }





        Scene scene = new Scene(borderPane, 600, 400);

        primaryStage.setTitle("LiFe");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
 public static void main(String[] args) {
        launch(args);
    }

}

