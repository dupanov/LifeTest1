package life;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.Serializable;


public class Main  extends Application implements Serializable {

    private static LifeRunner life = new LifeRunner();
    private static Stage stage;
    private static Slider speedSlider ;
    private static Label label;


    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Main.stage = stage;
    }

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

        label = new Label();
        setLabelText(label);

        Button move = new Button();
        move.setText("Move");
        //Thread t = new Thread(life);
        //t.start();
        move.setOnMouseClicked(event2 -> {
            life.runner(true);
            setLabelText(label);
        });
        move.getStyleClass().add("button");
        hbox.getChildren().add(move);

        Button stop = new Button("Stop");
        stop.setOnMouseClicked(event1 -> {
            life.setRunningState(false);
           setLabelText(label);

        });
        stop.getStyleClass().add("button");
        hbox.getChildren().add(stop);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(10, 0, 10, 0));
        gridPane.setGridLinesVisible(true);
        gridPane.setVisible(true);
        scrollPane.setContent(gridPane);

        HBox footer = new HBox(300);
        footer.setSpacing(10);
        footer.setPadding(new Insets(15, 12, 15, 12));
        footer.getStyleClass().add("hbox");
        borderPane.setBottom(footer);
        setSpeedSliderValues(100, 1000);
        footer.getChildren().add(speedSlider);

        footer.getChildren().add(label);

        LifeRunner.setActorArrayList(gridPane);

        Scene scene = new Scene(borderPane, 600, 400);
        primaryStage.setTitle("LiFe");
        primaryStage.setScene(scene);
        primaryStage.show();

        life.setRunningState(true);
        primaryStage.setOnCloseRequest(event -> life.setRunningState(false));
    }

    private static void setSpeedSliderValues(int min, int max) {
        speedSlider = new Slider();
        speedSlider.setMin(min);
        speedSlider.setMax(max);
        speedSlider.setValue((max - min) / 2);
        speedSlider.setBlockIncrement((max - min) / 100);
    }

    public static int getSpeedSliderValue(){
        return (int)speedSlider.getValue();
    }


    public static LifeRunner getLife(){
        return life;
    }


 public static void main(String[] args) {

     launch(args);
    }


    public static void setLabelText(Label obj){
        if(life.getRunningState()) obj.setText("Running");  else  obj.setText("Stopped");
    }

    public static Object getLabel(){
        return label;
    }

}

