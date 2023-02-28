/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.media.Media;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;


import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class MediaPlayerController extends MediaView implements Initializable {

    private String path;
    private MediaPlayer mediaPlayer;
    private boolean pause=false;

    private Label label;
    private StackPane pane;
    private Button openFile;

    private final Slider volumeSlider=new Slider();;

    private Slider progressBar;
    public  MediaPlayerController(String path){
        progressBar=new Slider();
        label=new Label("ere00");
        pane=new StackPane();
        openFile=new Button("Open");
        OpenFileMethod(path);
    }


    private void OpenFileMethod(String hg) {
        /*
        FileChooser fileChooser = new FileChooser();
     FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a .mp4 file", ".mp4");
      fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);*/
        path = hg;

        if(path != null){
            Media media = new Media(new File(path));
            mediaPlayer = new MediaPlayer(media);
            this.setMediaPlayer(mediaPlayer);

            //creating bindings
            DoubleProperty widthProp = this.fitWidthProperty();
            DoubleProperty heightProp = this.fitHeightProperty();


            widthProp.bind(Bindings.selectDouble(this.sceneProperty(), "width"));
            heightProp.bind(Bindings.selectDouble(this.sceneProperty(), "height"));

            volumeSlider.setValue(mediaPlayer.getVolume()*100);
            volumeSlider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeSlider.getValue()/100);
                }
            });

            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<javafx.util.Duration>() {
                                                              @Override
                                                              public void changed(ObservableValue<? extends javafx.util.Duration> observable, javafx.util.Duration oldValue, javafx.util.Duration newValue) {
                                                                  progressBar.setValue(newValue.toSeconds());
                                                              }
                                                          }
            );

            progressBar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });

            progressBar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    mediaPlayer.seek(javafx.util.Duration.seconds(progressBar.getValue()));
                }
            });

            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    javafx.util.Duration total = media.getDuration();
                    progressBar.setMax(total.toSeconds());
                }
            });

            mediaPlayer.play();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void pauseVideo(ActionEvent event){
        pause=true;mediaPlayer.pause();
    }

    public void stopVideo(ActionEvent event){
        mediaPlayer.stop();
    }

    public void playVideo(ActionEvent event){
        pause=false;
        mediaPlayer.play();
        mediaPlayer.setRate(1);
    }

    public void skip5(ActionEvent event){
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(5)));
    }

    public void furtherSpeedUpVideo(ActionEvent event){
        mediaPlayer.setRate(2);
    }

    public void back5(ActionEvent event){
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(javafx.util.Duration.seconds(-5)));
    }

    public void furtherSlowDownVideo(ActionEvent event){
        mediaPlayer.setRate(0.5);

    }
    public void VolumeSet(){mediaPlayer.setVolume(volumeSlider.getValue()*(1.1));

    }
    public void VolumeSet2(){mediaPlayer.setVolume(volumeSlider.getValue()*(0.9));

    }
    public boolean getPause(){
        return pause;
    }
    public void setVolumeSlider(){

    }



}