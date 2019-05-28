import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FXEvent extends Application {

    Label response;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage myStage) {
        myStage.setTitle("Кнопки и события");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene( rootNode,400, 400);
        myStage.setScene(myScene);
        response = new Label("Нажми на кнопку");


        Button btnAlpha = new Button("Альфа");
        Button btnBeta = new Button("Бетта");

        btnAlpha.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                btnAlpha.setTranslateX(Math.random()*150-50);
                btnAlpha.setTranslateY(Math.random()*150-50);
            }
        });

        btnAlpha.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Нажали на Альфу");
                alert.showAndWait();
            }
        });

        btnAlpha.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Нажали на Бетту");
            }
        });

        btnBeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                response.setText("Нажали на Бетту");
            }
        });


        rootNode.getChildren().addAll(response,btnBeta,btnAlpha);
        myStage.show();
    }
}