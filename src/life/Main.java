package life;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.Serializable;


public class Main  extends Application implements Serializable {

    private static LifeRunner life = new LifeRunner();
    static Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        BorderPane borderPane = new BorderPane();
        borderPane.getStylesheets().add(Main.class.getResource("life.css").toExternalForm());
        ScrollPane scrollPane = new ScrollPane();
        borderPane.setCenter(scrollPane);


        HBox hbox = new HBox(300);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.getStyleClass().add("hbox");
        borderPane.setTop(hbox);

        Button move = new Button();
        move.setText("Move");
        Thread t = new Thread(life);
        t.start();
        move.setOnMouseClicked(event2 -> life.runner(true));
        move.getStyleClass().add("button1");
        hbox.getChildren().add(move);

        Button stop = new Button("Stop");
        stop.setOnMouseClicked(event1 -> life.setRunningState(false));
        stop.getStyleClass().add("button1");
        hbox.getChildren().add(stop);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(10, 0, 10, 0));
        gridPane.setGridLinesVisible(true);
        gridPane.setVisible(true);
        scrollPane.setContent(gridPane);

        LifeRunner.setActorArrayList(gridPane);

        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setTitle("LiFe");
        primaryStage.setScene(scene);
        primaryStage.show();

        LifeRunner.setRunningState(true);
        primaryStage.setOnCloseRequest(event -> LifeRunner.setRunningState(false));
    }

    public static LifeRunner getLife(){
        return life;
    }


 public static void main(String[] args) {
     launch(args);
    }

}

