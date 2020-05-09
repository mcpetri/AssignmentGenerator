/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorapp.ui;

import generatorapp.logic.Calculator;
import generatorapp.logic.Assignment;
import generatorapp.logic.Statistics;
import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Popup;

/**
 *
 * @author petri
 */
public class GeneratorUI extends Application {
    
    String user;
    Stage window;
    Scene startScene, assignmentScene, calculatorScene, difficultyScene, loginScene;
    VBox leftMenu;
    Assignment assignment = new Assignment();
    Calculator calculator = new Calculator();
    Statistics statistics = new Statistics();
    
    /**
     * Aloittaa ohjelman avaamalla login Scenen
     * ja luomalla leftMenun
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tehtävägeneraattori");
        //AloitusMenu
        createLeftMenu();
        Label startMessage = new Label("You're not suppoused to see this");
        BorderPane startSetting = new BorderPane();
        startSetting.setCenter(startMessage);
        startScene = new Scene(startSetting, 480, 350);
        primaryStage.setScene(startScene);
        window = primaryStage;
        window.show();
        login();
        int status = statistics.generateStatisticsFile();
        switch (status) {
            case -1:
                popupWindow("Virhe tilastotiedostoa luotaessa");
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void createLeftMenu() {
        //Menun napit
        Button start = new Button();
        start.setText("Aloitus");
        start.setOnAction(e -> start());
        start.setMinWidth(100);
        Button addition = new Button();
        addition.setText("Yhteenlasku");
        addition.setOnAction(e -> {
            assignment("+", -1);
            statistics.increaseAdditionNumber();
            statistics.increaseAssignmentNumber();
            statistics.increaseDifficulty(assignment.getDifficulty());
            statistics.increaseVarition(assignment.getVariation());
                });
        addition.setMinWidth(100);
        Button subtraction=  new Button();
        subtraction.setText("Vähennyslasku");
        subtraction.setOnAction(e -> {
            assignment("-", -1);
            statistics.increaseSubtractionNumber();
            statistics.increaseAssignmentNumber();
            statistics.increaseDifficulty(assignment.getDifficulty());
            statistics.increaseVarition(assignment.getVariation());
                });
        subtraction.setMinWidth(100);
        Button multiplication = new Button();
        multiplication.setText("Kertolasku");
        multiplication.setOnAction(e -> {
            assignment("*", -1);
            statistics.increaseMultiplicationNumber();
            statistics.increaseAssignmentNumber();
            statistics.increaseDifficulty(assignment.getDifficulty());
            statistics.increaseVarition(assignment.getVariation());
                });
        multiplication.setMinWidth(100);
        Button division = new Button();
        division.setText("Jakolasku");
        division.setOnAction(e -> {
            assignment(":", -1);
            statistics.increaseDivisionNumber();
            statistics.increaseAssignmentNumber();
            statistics.increaseDifficulty(assignment.getDifficulty());
            statistics.increaseVarition(assignment.getVariation());
                });
        division.setMinWidth(100);
        Button random = new Button();
        random.setText("Satunnaislasku");
        random.setOnAction(e -> {
            assignment("random", -1);
            statistics.increaseRandomNumber();
            statistics.increaseAssignmentNumber();
            statistics.increaseDifficulty(assignment.getDifficulty());
            statistics.increaseVarition(assignment.getVariation());
                });
        random.setMinWidth(100);
        Button calc = new Button();
        calc.setText("Laskin");
        calc.setOnAction(e -> calculator());
        calc.setMinWidth(100);
        Button difficulty = new Button();
        difficulty.setText("Vaikeusaste");
        difficulty.setOnAction(e -> difficulty());
        difficulty.setMinWidth(100);
        Button stats = new Button();
        stats.setText("Tilastot");
        stats.setOnAction(e -> statistics());
        stats.setMinWidth(100);
        //Vasen menu
        leftMenu = new VBox();
        leftMenu.setSpacing( 10);
        leftMenu.getChildren().addAll(start, addition, subtraction);
        leftMenu.getChildren().addAll(multiplication, division, random, calc);
        leftMenu.getChildren().addAll(difficulty, stats);
    }
    public void start() {
        Label startMessage = new Label("Tervetuloa tehtävägeneraattoriin!\n"
                                         + "Ole hyvä ja valitse toiminto\n\n"
                                         + "Huom! Käytä pistettä . desimaalien kanssa\n"
                                         + "ja pyöristä vastaus tarvittaessa sadasosiin");
        BorderPane startSetting = new BorderPane();
        startSetting.setPadding(new Insets(10,10,10,10));
        startSetting.setLeft(leftMenu);
        startSetting.setCenter(startMessage);
        startScene = new Scene(startSetting, 480, 350);
        window.setScene(startScene);
    }
    public void assignment(String symbol, int correct) {
        assignment.createAssignment(symbol);
        VBox assignmentComponents = new VBox();
        assignmentComponents.setSpacing(10);
        assignmentComponents.setPadding(new Insets(10,10,10,10));
        Label expression = new Label(assignment.getExpression());
        TextField answer = new TextField();
        Button check = new Button();
        check.setText("Tarkista vastaus");
        Label checkMessage = new Label("");
        if(correct == 1) {
            checkMessage.setText("Vastauksesi oli oikein");
        }
        assignmentComponents.getChildren().addAll(expression,answer,check,checkMessage);
        check.setOnAction(e -> {
            try {
                if (assignment.check(answer.getText())) {
                    assignment(symbol, 1);
                    statistics.increaseCorrectNumber();
                    statistics.increaseCorrectPercentage();
                } else {
                    checkMessage.setText("Väärin");
                    statistics.increaseIncorrectNumber();
                    statistics.increaseIncorrectPercentage();
                }
            } catch (Exception error) { //Virhe popup
                popupWindow("Virhe, yritä uudelleen\n\n"
                        + "Tarkista että käytät syötteessä vain numeroita\n"
                        + "ja tarvittaessa desimaalipistettä");
                statistics.increaseErrorNumber();
            }
        });
        if (symbol.equals("random")) {
            Label reminder = new Label("                    Muista laskujärjestys!");
            assignmentComponents.getChildren().add(reminder);
        }
        BorderPane assingmentSetting = new BorderPane();
        assingmentSetting.setPadding(new Insets(10,10,10,10));
        assingmentSetting.setLeft(leftMenu);
        assingmentSetting.setCenter(assignmentComponents);
        assignmentScene = new Scene(assingmentSetting, 480, 350);
        window.setScene(assignmentScene);
    }
    public void calculator() {
        VBox calculatorComponents = new VBox();
        calculatorComponents.setSpacing(10);
        calculatorComponents.setPadding(new Insets(10,10,10,10));
        Label title = new Label("Syötä lauseke allaolevaan kenttään \n ");
        TextField expression = new TextField();
        Button count = new Button();
        count.setText("Laske");
        count.setMinWidth(70);
        Label answer = new Label("\n\nVastaus on =\n\n");
        Button guide = new Button();
        guide.setMinWidth(70);
        guide.setText("Ohje");
        guide.setOnAction(e -> { //Tehdään pop up ikkuna ohjeille
            popupWindow("Tässä laskimessa voit käyttää\n"
                         + "plus-, miinus-, kerto- ja jakomerkkejä\n"
                         + "sekä sulkuja ja etumerkkejä.");
        });
        count.setOnAction(e -> {
            try {
                String result = String.valueOf(Math.round(calculator.count(expression.getText()) * 100.0) / 100.0);
                answer.setText("\n\nVastaus on = " + result + "\n\n");
                statistics.increaseCalculatorNumber();
            }
            catch (Exception error) { //Virhe popup
                popupWindow("Virhe, yritä uudelleen\n\n"
                        + "Tarkista että käytät syötteessä\n"
                        + "- numeroita\n"
                        + "- merkkejä + , - , * , /\n"
                        + "- oikean verran sulkuja ( )");
                statistics.increaseErrorNumber();
            }
        });
        calculatorComponents.getChildren().addAll(title, expression, count, answer, guide);
        BorderPane laskinAsettelu = new BorderPane();
        laskinAsettelu.setPadding(new Insets(10,10,10,10));
        laskinAsettelu.setLeft(leftMenu);
        laskinAsettelu.setCenter(calculatorComponents);
        calculatorScene = new Scene(laskinAsettelu, 480, 350);
        window.setScene(calculatorScene); 
    }
    public void difficulty() {
        Label variationLabel = new Label("Voit vaihtaa tästä tekijöiden suuruutta");
        HBox variationButtons = new HBox();
        Button variation1 = new Button("0-10");
        Button variation2 = new Button("0-100");
        Button variation3 = new Button("0-1000");
        variation1.setMinWidth(70);
        variation2.setMinWidth(70);
        variation3.setMinWidth(70);
        variation1.setOnAction(e -> {
            assignment.setVariation(10);
        });
        variation2.setOnAction(e -> {
            assignment.setVariation(100);
        });
        variation3.setOnAction(e -> {
            assignment.setVariation(1000);
        });
        Label spacing = new Label("");
        variationButtons.getChildren().addAll(variation1, variation2, variation3);
        Label difficultyLabel = new Label("Voit vaihtaa tästä tekijöiden määrää");
        HBox difficultyButtons = new HBox();
        Button difficulty1 = new Button("2");
        Button difficulty2 = new Button("3");
        Button difficulty3 = new Button("4");
        Button difficulty4 = new Button("5");
        difficulty1.setMinWidth(50);
        difficulty2.setMinWidth(50);
        difficulty3.setMinWidth(50);
        difficulty4.setMinWidth(50);
        difficulty1.setOnAction(e -> {
            assignment.setDifficulty(1);
        });
        difficulty2.setOnAction(e -> {
            assignment.setDifficulty(2);
        });
        difficulty3.setOnAction(e -> {
            assignment.setDifficulty(3);
        });
        difficulty4.setOnAction(e -> {
            assignment.setDifficulty(4);
        });
        difficultyButtons.getChildren().addAll(difficulty1, difficulty2, difficulty3, difficulty4);
        
        VBox difficultyComponents = new VBox();
        difficultyComponents.setSpacing(10);
        difficultyComponents.setPadding(new Insets(10,10,10,10));
        difficultyComponents.getChildren().addAll(variationLabel, variationButtons, spacing, difficultyLabel, difficultyButtons);
        BorderPane difficultySetting = new BorderPane();
        difficultySetting.setPadding(new Insets(10,10,10,10));
        difficultySetting.setLeft(leftMenu);
        difficultySetting.setCenter(difficultyComponents);
        difficultyScene = new Scene(difficultySetting, 480, 350);
        window.setScene(difficultyScene);  
    }
    public void statistics() {     
        String[] stats = statistics.parseStatistics(statistics.getStatistics(user));
        double correctPercentage = Double.valueOf(stats[3]) / (Double.valueOf(stats[3]) + Double.valueOf(stats[5]));
        double roundedCorrect = Math.round(correctPercentage * 10000.0) / 100.0;
        double incorrectPercentage = Double.valueOf(stats[5]) / (Double.valueOf(stats[3]) + Double.valueOf(stats[5]));
        double roundedIncorrect = Math.round(incorrectPercentage * 10000.0) / 100.0;
        Label statisticsText = new Label(
                "Generoituja tehtäviä\n"
                + "Oikeinvastausprosentti\n"
                + "Oikeiden vastausten määrä\n"
                + "Väärinvastausprosentti\n"
                + "Väärien vastausten määrä\n"
                + "Generoituja yhteenlaskuja\n"
                + "Generoituja vähennyslaskuja\n"
                + "Generoituja kertolaskuja\n"
                + "Generoituja jakolaskuja\n"
                + "Generoituja satunnaistehtäviä\n"       
                + "Laskimen käyttökerrat\n"
                + "Virheelliset syötteet\n"
                + "Tehtäviä generoitu, kun tekijöiden vaihtelu 0-10\n"
                + "Tehtäviä generoitu, kun tekijöiden vaihtelu 0-100\n"
                + "Tehtäviä generoitu, kun tekijöiden vaihtelu 0-1000\n"
                + "Tehtäviä generoitu, kun tekijöitä 2\n"
                + "Tehtäviä generoitu, kun tekijöitä 3\n"
                + "Tehtäviä generoitu, kun tekijöitä 4\n"
                + "Tehtäviä generoitu, kun tekijöitä 5");     
        Label statisticsNumbers = new Label(
                "  = "+stats[1]+"       \n"                         //tehtävien lkm
                + "  = "+(roundedCorrect)+"       \n"           //oikein %
                + "  = "+stats[3]+"       \n"                       //oikein lkm
                + "  = "+(roundedIncorrect)+"       \n"         //väärin %
                + "  = "+stats[5]+"       \n"                       //väärin lkm
                + "  = "+stats[6]+"       \n"       //yhteen
                + "  = "+stats[7]+"       \n"       //vähennys
                + "  = "+stats[8]+"       \n"       //kerto
                + "  = "+stats[9]+"       \n"       //jako
                + "  = "+stats[10]+"      \n"       //satunnais
                + "  = "+stats[11]+"      \n"       //laskin
                + "  = "+stats[12]+"      \n"       //virhe
                + "  = "+stats[13]+"      \n"       //vaihtelu10
                + "  = "+stats[14]+"      \n"       //vaihtelu100
                + "  = "+stats[15]+"      \n"       //vaihtelu1000
                + "  = "+stats[16]+"      \n"       //vaikeus2
                + "  = "+stats[17]+"      \n"       //vaikeus3
                + "  = "+stats[18]+"      \n"       //vaikeus4
                + "  = "+stats[19]+"      \n"       //vaikeus5
        );
        HBox statsTextNumbers = new HBox();
        statsTextNumbers.getChildren().addAll(statisticsText, statisticsNumbers);
        BorderPane statisticsSetting = new BorderPane();
        statisticsSetting.setPadding(new Insets(10,10,10,10));
        statisticsSetting.setLeft(leftMenu);
        statisticsSetting.setRight(statsTextNumbers);
        difficultyScene = new Scene(statisticsSetting, 480, 350);
        window.setScene(difficultyScene); 
    }
    public void login() {
        Label guide = new Label("   Ilmoita käyttäjä, jolle haluat kirjautua");
        TextField userName = new TextField();
        Button proceed = new Button("Kirjaudu");
        proceed.setOnAction(e -> {
            String tempUserName = String.valueOf(userName.getText());
            String parsedUserName = tempUserName.replaceAll("\\s","");
            try {
                statistics.createNewStatistics(parsedUserName);
            } catch (IOException error) {
                popupWindow("Virhe käyttäjän tiedostoriviä luotaessa");
            }
            this.user = parsedUserName;
            window.setTitle("Tehtävägeneraattori - käyttäjä "+user);
            statistics.setUser(user);
            start();
        });
        HBox textAndButton = new HBox();
        textAndButton.getChildren().addAll(userName, proceed);
        textAndButton.setPadding(new Insets(10,10,10,10));
        VBox loginComponents = new VBox();
        loginComponents.setPadding(new Insets(10,10,10,10));
        loginComponents.getChildren().addAll(guide, textAndButton);
        BorderPane loginSetting = new BorderPane();
        loginSetting.setPadding(new Insets(10,10,10,10));
        loginSetting.setCenter(loginComponents);
        loginScene = new Scene(loginSetting, 300, 100);
        window.setScene(loginScene); 
    }
    public void popupWindow(String text) {
        Popup popup = new Popup();
        popup.setAutoHide(true);
        Label message = new Label(text);
        BorderPane popupSetting = new BorderPane();
        popupSetting.setMinHeight(150);
        popupSetting.setMinWidth(300);
        popupSetting.setStyle(" -fx-background-color: white;");
        popupSetting.setCenter(message);
        popup.getContent().add(popupSetting);
        popup.show(window);
    }
}
