package life;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.Serializable;


public class Main extends Application implements Serializable {

    private LifeRunner life;


    /**
     * public void setLifeStage(Stage stage){
     * <p>
     * borderPane = new BorderPane();
     * borderPane.getStylesheets().add(Main.class.getResource("life.css").toExternalForm());
     * scrollPane = new ScrollPane();
     * borderPane.setCenter(scrollPane);
     * <p>
     * <p>
     * hbox = new HBox(300);
     * hbox.setSpacing(10);
     * hbox.setPadding(new Insets(15, 12, 15, 12));
     * hbox.getStyleClass().add("hbox");
     * borderPane.setTop(hbox);
     * <p>
     * label = new Label();
     * setLabelText(label);
     * <p>
     * move = new Button();
     * move.setText("Move");
     * //Thread t = new Thread(life);
     * //t.start();
     * move.setOnMouseClicked(event2 -> {
     * life.runner(true);
     * setLabelText(label);
     * });
     * move.getStyleClass().add("button");
     * hbox.getChildren().add(move);
     * <p>
     * stop = new Button("Stop");
     * stop.setOnMouseClicked(event1 -> {
     * life.setRunningState(false);
     * setLabelText(label);
     * <p>
     * });
     * stop.getStyleClass().add("button");
     * hbox.getChildren().add(stop);
     * <p>
     * gridPane = new GridPane();
     * gridPane.setHgap(1);
     * gridPane.setVgap(1);
     * gridPane.setPadding(new Insets(10, 0, 10, 0));
     * gridPane.setGridLinesVisible(true);
     * gridPane.setVisible(true);
     * scrollPane.setContent(gridPane);
     * <p>
     * footer = new HBox(300);
     * footer.setSpacing(10);
     * footer.setPadding(new Insets(15, 12, 15, 12));
     * footer.getStyleClass().add("hbox");
     * borderPane.setBottom(footer);
     * speedSlider = new MySpeedSlider(100, 1000);
     * footer.getChildren().add(speedSlider);
     * <p>
     * footer.getChildren().add(label);
     * <p>
     * LifeRunner.setActorArrayList(gridPane);
     * <p>
     * scene = new Scene(borderPane, 600, 400);
     * stage.setTitle("LiFe");
     * stage.setScene(scene);
     * stage.show();
     * <p>
     * life.setRunningState(true);
     * stage.setOnCloseRequest(event -> life.setRunningState(false));
     * }
     */


    public static void main(String[] args) {
        launch(args);
    }

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        life = new LifeRunner();
        ViewConsrtuctor view = new ViewConsrtuctor(primaryStage, life);
        primaryStage.show();

    }
}

