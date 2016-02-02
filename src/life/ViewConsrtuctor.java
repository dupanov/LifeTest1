package life;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import life.FXApp.MySlider;
import life.FXApp.MySpeedSlider;

/**
 * Created by Вадик on 31.01.2016.
 */
public class ViewConsrtuctor {

    GridPane gridPane;
    MySlider speedSlider;
    private JFXPanel fxPanel;
    private Label label;
    private Scene scene;
    private LifeRunner life;
    private Group root;
    private BorderPane borderPane = new BorderPane();
    private HBox hbox, footer;
    private ScrollPane scrollPane = new ScrollPane();
    private Button move, stop;

    public ViewConsrtuctor(JFXPanel fxPanel, LifeRunner life) {

        this.fxPanel = fxPanel;
        this.life = life;
        createView();
        //     fxPanel.getScene().setTitle("LiFe");
        //   stage.setScene(scene);
        //noinspection deprecation
        scene = fxPanel.getScene();
        //      stage.setTitle("LiFe");
        //      stage.setScene(scene);
        //      stage.show();

        //      stage.setOnCloseRequest(event -> life.setRunningState(false));


        //  root.getChildren().add(borderPane);


    }

    public ViewConsrtuctor(Stage stage, LifeRunner life) {
        this.life = life;
        Group root = new Group();
        Scene scene = new Scene(root, 400, 600);
        root.getChildren().add(createView());
        stage.setScene(scene);

    }

    public BorderPane createView() {

        borderPane.getStylesheets().add(ViewConsrtuctor.class.getResource("life.css").toExternalForm());
        borderPane.setCenter(scrollPane);
        hbox = new HBox();
        hbox.setPrefHeight(300);
        hbox.setSpacing(10);
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.getStyleClass().add("hbox");
        borderPane.setTop(hbox);
        label = new Label();
        setLabelText(label);

        move = new Button();
        move.setText("Move");

        move.setOnMouseClicked(event2 -> {
            life.runner(true);
            setLabelText(label);
        });
        move.getStyleClass().add("button");
        hbox.getChildren().add(move);

        stop = new Button("Stop");
        stop.setOnMouseClicked(event1 -> {
            life.setRunningState(false);
            setLabelText(label);
        });
        stop.getStyleClass().add("button");
        hbox.getChildren().add(stop);

        gridPane = new GridPane();
        gridPane.setHgap(1);
        gridPane.setVgap(1);
        gridPane.setPadding(new Insets(10, 0, 10, 0));
        gridPane.setGridLinesVisible(true);
        gridPane.setVisible(true);
        scrollPane.setContent(gridPane);

        footer = new HBox(300);
        footer.setSpacing(10);
        footer.setPadding(new Insets(15, 12, 15, 12));
        footer.getStyleClass().add("hbox");
        borderPane.setBottom(footer);

        speedSlider = new MySpeedSlider(100, 1000);
        footer.getChildren().add((Node) speedSlider);

        footer.getChildren().add(label);

        life.setActorArrayList(gridPane);

        return borderPane;
    }

    public JFXPanel getPanel() {
        return fxPanel;
    }

    public BorderPane getPane() {
        return borderPane;
    }

    public Scene getScene() {
        return scene;
    }

    public Group getRoot() {
        return root;
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    public LifeRunner getLife() {
        return life;
    }

    public void setLabelText(Label obj) {
        if (life.getRunningState()) obj.setText("Running");
        else obj.setText("Stopped");
    }
}
