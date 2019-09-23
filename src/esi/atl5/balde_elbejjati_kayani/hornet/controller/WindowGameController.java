/* @pbt certaines images sont présentes 2 fois
@pbt projet trop incomplet
@pbt le projet consomme bcp de ressources chez moi (obligé de faire un kill)
*/

package esi.atl5.balde_elbejjati_kayani.hornet.controller;

import esi.atl5.balde_elbejjati_kayani.hornet.model.Board;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Game;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Hornet;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Position;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Season;
import esi.atl5.balde_elbejjati_kayani.hornet.model.Ratio;
import esi.atl5.balde_elbejjati_kayani.hornet.view.CaseBean;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * FXML Controller class Window of game
 *
 * @author Alpha,Mohamed,Kamal
 */
public class WindowGameController implements Initializable, Observer {

    private int x;
    private int y;
    private int nbGen = 0;
    private int nbHornet = 0;
    private Season season;

    private CaseBean cel;
    private Board board;
    private Game game;
    @FXML
    private Label genLab;
    @FXML
    private Label NbAlive;
    @FXML
    private Button autoPlay;

    @FXML
    private ChoiceBox choiceSeason;
    @FXML
    private ChoiceBox ratio;
    @FXML
    private Button play;
    @FXML
    private Button exit;
    @FXML
    private VBox root;
    @FXML
    private GridPane grid;

    private Ratio ratioFill;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    void manageIconButtons() {
        Image image = new Image(getClass().getResourceAsStream("play.png"));
        ImageView iv1 = new ImageView(image);
        iv1.setFitHeight(40);
        iv1.setFitWidth(50);
        play.setGraphic(iv1);
        Image image2 = new Image(getClass().getResourceAsStream("exit.jpg"));
        ImageView iv2 = new ImageView(image2);
        iv2.setFitHeight(60);
        iv2.setFitWidth(50);
        exit.setGraphic(iv2);
        Image image3 = new Image(getClass().getResourceAsStream("autoplay.png"));
        ImageView iv3 = new ImageView(image3);
        iv3.setFitHeight(60);
        iv3.setFitWidth(50);
        autoPlay.setGraphic(iv3);
    }

    //@pbt il y a encore des lignes trop longues
    /**
     * 
     */
    void manageChoiceBoxs() {
        season = (Season.valueOf(
                choiceSeason.getSelectionModel().getSelectedItem().toString()));
        choiceSeason.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                    String oldValue, 
                    String newValue) {
                board.setSeason(Season.valueOf(newValue));
            }
        });
        ratioFill = Ratio.valueOf(
                ratio.getSelectionModel().getSelectedItem().toString());

        ratio.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, 
                    String oldValue, 
                    String newValue) {

                ratioFill = Ratio.valueOf(newValue);
                board.initBoard(ratioFill);
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        manageIconButtons();

        this.x = 30;
        this.y = 30;

        display(null, null);
        manageChoiceBoxs();

        this.board = new Board(x, y, season, ratioFill);
        this.game = new Game(board);
        game.addObserver(this);

    }

    /**
     * Every click, updated displaying
     *
     * @param event
     */
    @FXML
    public void nextGen(ActionEvent event) {
        this.game.play();
        nbGen += 1;
    }

    @FXML
    public void nextGenAuto() {
        Timeline cycle;
        cycle = new Timeline(new KeyFrame(
                Duration.millis(500),
                event -> game.play()
        ));
        cycle.setCycleCount(Timeline.INDEFINITE);
        cycle.play();
    }

    /**
     * exit program.
     *
     * @param event
     */
    @FXML
    public void exitGame(ActionEvent event) {
        Platform.exit();
    }

    /**
     * 
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        Game game=(Game)o;
        display(this.grid,game);

    }

    /**
     * 
     * @param grid
     * @param game 
     */
    void display(GridPane grid, Game game) {
        if (grid != null && game != null) {

            if (!grid.getChildren().isEmpty()) {
                grid.getChildren().clear();
            }
            for (int i = 0; i < x; i++) {
                //@pbt s/x/y
                for (int j = 0; j < x; j++) {
                    Hornet hr = game
                            .getaBoard()
                            .getHornetAtPos(new Position(i, j));
                    cel = new CaseBean();
                    Color col;
                    if (hr != null && hr.isALive()) {
                        col = Color.RED;
                    } else {
                        col = Color.ALICEBLUE;
                    }
                    cel.setColor(col);
                    grid.add(cel, i, j);

                }
            }
            nbHornet = game.getNbAlive();
            NbAlive.setText(Integer.toString(nbHornet));
            genLab.setText(Integer.toString(nbGen));
        }

    }

}
