package com.example.demo;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mediaplayer.MediaPlayerController;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main extends Application {
    private StackPane root = new StackPane();
    Button Bsignup,Blogin;
    static  MenuButton films;
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(new Person("Selo","true","true","dffd"));
    private BufferedInputStream bf;
    private static ArrayList<String> user,film,hall,seat;
    private static MenuItem[] menuItems;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        readbackup();

        launch(args);


    }
    public void init(Stage stage) {


        Bsignup = new Button("SİGN UP"); Blogin = new Button("LOGİN");
        VBox vBox = new VBox();


        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Welcome to HUCS Cinema Reservation\nPlease enter your credential below and click LOGIN" +
                        "\nYou can create an account by clicking SİGN UP\nUsername:"),
                new TextField(),
                new Label(" Password"),
                new PasswordField(),
                Blogin,
                Bsignup);
        root=new StackPane(); root.getChildren().addAll(vBox);
        stage = new Stage();
        Scene scene = new Scene(root,400,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Login Example JavaFX");

        Stage finalStage = stage;
        Blogin.setOnAction(actionEvent -> {
            finalStage.close();
            Admin(finalStage);

        });
        Bsignup.setOnAction(actionEvent-> {
            finalStage.close();;
         signin(finalStage);


        })
        ;


    }

    @Override
    public void start(Stage primaryStage) {
        init(primaryStage);




    }



    private  void signin(Stage stage){
        Bsignup = new Button("SİGN UP"); Blogin = new Button("LOGİN");
        VBox vBox = new VBox();
        PasswordField passwordField1=new PasswordField();
        PasswordField passwordField=new PasswordField();

        vBox.setSpacing(8);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.getChildren().addAll(
                new Label("Welcome to HUCS Cinema Reservation\nPlease enter your credential below and click LOGIN" +
                        "\nYou can create an account by clicking SİGN UP\nUsername:"),
                new TextField(),
                new Label(" Password"),
                passwordField, new Label(" Password"),passwordField1,
                Bsignup,
                Blogin);
        root=new StackPane(); root.getChildren().addAll(vBox);
        stage = new Stage();
        Scene scene = new Scene(root,400,600);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Sign UP Example JavaFX");


        Stage finalStage = stage;
        Blogin.setOnAction(actionEvent -> {
            finalStage.close();
            init(finalStage);

        });


    }
    private void Admin(Stage stage){




        Button Bokey=new Button("OK");
        Button Badd=new Button("Add Film");
        Button Bremove=new Button("Remove Film");
        Button Bedit=new Button("Edit Users");
        Button Blogout=new Button("LOG OUT");


        GridPane root = new GridPane();
        // Add the children to the VBox
        root.addRow(0,new Label("Welcome to Admin(Admin-Club Member)\n You can either select movie or do edit"));
        root.addRow(1,films,Bokey);
        root.addRow(2,Badd,Bremove,Bedit);
        root.addRow(3,Blogout);
        Badd.setOnAction(ActionEvent ->{
            Baddfunc(stage);
        });
        Bremove.setOnAction(ActionEvent ->{
            if(film.contains(films.getText())){
            film.remove(film.indexOf(films.getText()));
            films.getItems().clear();
            films.setText("Select");
            for (String flm:film){


                String finalFlm =flm.split("\t")[0];
                // Create the MenuItem ford
                MenuItem item = new MenuItem(finalFlm);
                // Add EventHandler to the MenuItem

                item.setOnAction(e -> films.setText(finalFlm));
                films.getItems().add(item);

            }



        }});
        Bedit.setOnAction(ActionEvent ->{
            EditUsers(stage);
        });
        Blogout.setOnAction(ActionEvent ->{
        signin(stage);
        });
        Bokey.setOnAction(ActionEvent ->{
            if (!films.getText().equals("Select")){
                Player(stage);

            }
        });

        // Set the Size of the VBox
        root.setMinSize(350, 250);

        /*
         * Set the padding of the VBox
         * Set the border-style of the VBox
         * Set the border-width of the VBox
         * Set the border-insets of the VBox
         * Set the border-radius of the VBox
         * Set the border-color of the VBox
         */
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("A MenuButton Example");
        // Display the Stage
        stage.show();

    }  // Helper Method

    private void EditUsers(Stage stage) {
        TableView<Person> table = new TableView<>();
        HBox hb = new HBox();
        Scene scene = new Scene(new Group());
        stage.setWidth(450);
        stage.setHeight(550);


        TableColumn firstNameCol = new TableColumn("Username");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("username"));

        TableColumn lastNameCol = new TableColumn("Club Member");
        lastNameCol.setVisible(true);
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("clubmember"));
        TableColumn adminCol = new TableColumn("Admin");
        adminCol.setMinWidth(100);
        adminCol.setCellValueFactory(
                new PropertyValueFactory<>("admin"));
        TableColumn fourthCol = new TableColumn("fourth");
        fourthCol.setVisible(false);
        fourthCol.setMinWidth(100);
        fourthCol.setCellValueFactory(
                new PropertyValueFactory<>("fourth"));
        table.setItems(data);
        table.getColumns().addAll(firstNameCol, lastNameCol,adminCol,fourthCol);


        final Button backbutton = new Button("Back");
        final Button Bclubmember = new Button("Promote/Demote Club Member");
        final Button BAdmin = new Button("Promote/Demote Admin");


        hb.getChildren().addAll(backbutton,Bclubmember,BAdmin);
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

        backbutton.setOnAction((ActionEvent e) -> {
            // data.add(new Person("görkem","false","true","sdfdsf "));
            Admin(stage);
        });
        Bclubmember.setOnAction(actionEvent -> {
            if (table.getSelectionModel().getSelectedItem()!=null)
                table.getSelectionModel().getSelectedItem().setClubmember("s");
                EditUsers(stage);
        });
        BAdmin.setOnAction(actionEvent -> {
            if (table.getSelectionModel().getSelectedItem()!=null)

                table.getSelectionModel().getSelectedItem().setAdmin("s");
            EditUsers(stage);

        });

    }

    private void Baddfunc(Stage stage) {
        TextField f1=new TextField(),f2=new TextField(),f3=new TextField();
        Button b1=new Button("Back"),b2=new Button("OK");


        GridPane root = new GridPane();
        // Add the children to the VBox
        root.addRow(0,new Label("Please give name, relative path of trailer and duration of movie"));
        root.addRow(1,new Label("Name:"),f1);
        root.addRow(2,new Label("Trailer(path):"),f2);
        root.addRow(3,new Label("Duration(m):"),f3);
        root.addRow(4,b1,b2);
        b1.setOnAction(ActionEvent ->{
            Admin(stage);
        });


        // Set the Size of the VBox
        root.setMinSize(350, 250);

        /*
         * Set the padding of the VBox
         * Set the border-style of the VBox
         * Set the border-width of the VBox
         * Set the border-insets of the VBox
         * Set the border-radius of the VBox
         * Set the border-color of the VBox
         */
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("A work");
        // Display the Stage
        stage.show();

    }

    public void printMessage(String message)
    {
        // Set the Text of the Label
        System.out.println(message);
    }
    private static void readbackup() throws IOException, ClassNotFoundException {
        user=new ArrayList<String>();
        film=new ArrayList<>();
        hall=new ArrayList<>();
        seat=new ArrayList<String>();
      //   bf = new BufferedInputStream (new FileInputStream("news.dat"));
        String str=new File("src/main/java/com/example/demo/backup.dat").toString();
       ArrayList<String > arr= (ArrayList<String>) Files.readAllLines(Paths.get(str));
        for(String s:arr){
            String first=s.split("\t")[0];
            if(first.equals("user"))user.add(s);
            else if(first.equals("hall"))hall.add(s);
            else if(first.equals("film"))film.add(s);
            else if(first.equals("seat"))seat.add(s);

        }
        MenuItems();



    }
    private void Player(Stage stage){

        GridPane root = new GridPane();
        MediaPlayerController mediaPlayerController=new MediaPlayerController("\\src\\main\\java\\com\\example\\demo\\the_batman.mp4");
        Button startstop=new Button("||"),fiveforward=new Button(">>"),fiveback=new Button("<<"),gostart=new Button("|<<");
        Button back=new Button("Back"), addhall=new Button("Add Hall"), removehal=new Button("Remove Hall"),ok=new Button("OK");
        MenuButton MHalls=new MenuButton();
        HBox Bhbox=new HBox();
        Bhbox.getChildren().addAll(back,addhall,removehal,MHalls,ok);
        Slider Svol=new Slider();Svol.setOrientation(Orientation.VERTICAL);
        Svol.setValue(30);
        VBox vBox=new VBox();
        vBox.getChildren().addAll(startstop,fiveback,fiveforward,gostart,Svol);
        HBox hbox=new HBox();
        hbox.getChildren().addAll(mediaPlayerController,vBox);


        root.addRow(0,new Label(films.getText()+GetMunite()));
        root.addRow(1,hbox);
        root.addRow(2,Bhbox);
        startstop.setOnAction(event -> {
            if (mediaPlayerController.getPause() == false) {
                startstop.setText("|>");
                mediaPlayerController.pauseVideo(event);
            } else {
                startstop.setText("||");
                mediaPlayerController.playVideo(event);
            }
        });
        fiveback.setOnAction(event -> {
            mediaPlayerController.back5(event);
        });
        fiveforward.setOnAction(event -> {
            mediaPlayerController.skip5(event);
        });
        gostart.setOnAction(event -> {
            mediaPlayerController.stopVideo(event);
        });

         Svol.addEventHandler(EventType.ROOT, new EventHandler<Event>() {
             @Override
             public void handle(Event event) {
                 if (event==(Svol.getOnSwipeDown()))mediaPlayerController.VolumeSet();
                 else if(event==Svol.getOnSwipeUp())mediaPlayerController.VolumeSet2();
             }
         });


        root.setMinSize(350,350);
        Scene scene = new Scene(root);
        stage.setTitle("Media Player");

        stage.setScene(scene);
        stage.show();
    }
    private static void MenuItems(){
         films = new MenuButton("Select");
        for (String flm:film){


            String finalFlm =flm.split("\t")[1];
        // Create the MenuItem ford
        MenuItem item = new MenuItem(finalFlm);
        // Add EventHandler to the MenuItem

            item.setOnAction(e -> films.setText(finalFlm));
        films.getItems().add(item);

    }

    }
    private String GetMunite(){
            String movie=films.getText();
            for (String s:film){
                if (movie.equals(s.split("\t")[1]))
                    return s.split("\t")[3];
            }
        return null;
    }
}