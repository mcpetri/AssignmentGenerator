/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaattoriapp.ui;

import generaattoriapp.logic.Laskin;
import generaattoriapp.logic.Tehtava;
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
public class GeneraattoriUI extends Application {
    
    Stage ikkuna;
    Scene aloitusNakyma, tehtavaNakyma, laskinNakyma, vaikeusNakyma;
    VBox vasenMenu;
    Tehtava tehtava = new Tehtava();
    Laskin laskin = new Laskin();
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tehtävägeneraattori");
        //Menun napit
        Button aloitus = new Button();
        aloitus.setText("Aloitus");
        aloitus.setOnAction(e -> aloitus());
        aloitus.setMinWidth(100);
        Button yhteen = new Button();
        yhteen.setText("Yhteenlasku");
        yhteen.setOnAction(e -> tehtava("+"));
        yhteen.setMinWidth(100);
        Button vahennys = new Button();
        vahennys.setText("Vähennyslasku");
        vahennys.setOnAction(e -> tehtava("-"));
        vahennys.setMinWidth(100);
        Button kerto = new Button();
        kerto.setText("Kertolasku");
        kerto.setOnAction(e -> tehtava("*"));
        kerto.setMinWidth(100);
        Button jako = new Button();
        jako.setText("Jakolasku");
        jako.setOnAction(e -> tehtava(":"));
        jako.setMinWidth(100);
        Button satunnais = new Button();
        satunnais.setText("Satunnaislasku");
        satunnais.setOnAction(e -> tehtava("random"));
        satunnais.setMinWidth(100);
        Button laskin = new Button();
        laskin.setText("Laskin");
        laskin.setOnAction(e -> laskin());
        laskin.setMinWidth(100);
        Button vaikeusaste = new Button();
        vaikeusaste.setText("Vaikeusaste");
        vaikeusaste.setOnAction(e -> vaikeusaste());
        vaikeusaste.setMinWidth(100);
        Button tilastot = new Button();
        tilastot.setText("Tilastot");
        tilastot.setOnAction(e -> tilastot());
        tilastot.setMinWidth(100);
        //Vasen menu
        vasenMenu = new VBox();
        vasenMenu.setSpacing( 10);
        vasenMenu.getChildren().addAll(aloitus, yhteen, vahennys);
        vasenMenu.getChildren().addAll(kerto, jako, satunnais, laskin);
        vasenMenu.getChildren().addAll(vaikeusaste, tilastot);
        //AloitusMenu
        Label aloitusViesti = new Label("Tervetuloa tehtävägeneraattoriin!\n"
                                         + "Ole hyvä ja valitse toiminto\n\n"
                                         + "Huom! Käytä pistettä . desimaalien kanssa\n"
                                         + "ja pyöristä vastaus tarvittaessa sadasosiin");
        BorderPane aloitusAsettelu = new BorderPane();
        aloitusAsettelu.setPadding(new Insets(10,10,10,10));
        aloitusAsettelu.setLeft(vasenMenu);
        aloitusAsettelu.setCenter(aloitusViesti);
        aloitusNakyma = new Scene(aloitusAsettelu, 400, 330);
        primaryStage.setScene(aloitusNakyma);
        ikkuna = primaryStage;
        ikkuna.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void aloitus() {
        Label aloitusViesti = new Label("Tervetuloa tehtävägeneraattoriin!\n"
                                         + "Ole hyvä ja valitse toiminto\n\n"
                                         + "Huom! Käytä pistettä . desimaalien kanssa\n"
                                         + "ja pyöristä vastaus tarvittaessa sadasosiin");
        BorderPane aloitusAsettelu = new BorderPane();
        aloitusAsettelu.setPadding(new Insets(10,10,10,10));
        aloitusAsettelu.setLeft(vasenMenu);
        aloitusAsettelu.setCenter(aloitusViesti);
        aloitusNakyma = new Scene(aloitusAsettelu, 400, 330);
        ikkuna.setScene(aloitusNakyma);
    }
    public void tehtava(String merkki) {
        tehtava.luoTehtava(merkki);
        VBox tehtavaKomponentit = new VBox();
        tehtavaKomponentit.setSpacing(10);
        tehtavaKomponentit.setPadding(new Insets(10,10,10,10));
        Label otsikko = new Label(tehtava.getLauseke());
        TextField vastaus = new TextField();
        Button tarkista = new Button();
        tarkista.setText("Tarkista vastaus");
        Label vastausViesti = new Label("");
        tehtavaKomponentit.getChildren().addAll(otsikko,vastaus,tarkista,vastausViesti);
        tarkista.setOnAction(e -> {
            try {
                if (tehtava.tarkistus(vastaus.getText())) {
                    vastausViesti.setText("Oikein!");
                } else {
                    vastausViesti.setText("Väärin");
                }
            } catch (Exception error) { //Virhe popup
                Popup popup = new Popup();
                popup.setAutoHide(true);
                Label errorMesssage = new Label("Virhe, yritä uudelleen\n\n"
                        + "Tarkista että käytät syötteessä vain numeroita\n"
                        + "ja tarvittaessa desimaalipistettä");
                BorderPane popupAsettelu = new BorderPane();
                popupAsettelu.setMinHeight(100);
                popupAsettelu.setMinWidth(300);
                popupAsettelu.setStyle(" -fx-background-color: white;");
                popupAsettelu.setCenter(errorMesssage);
                popup.getContent().add(popupAsettelu);
                popup.show(ikkuna);
            }
        });
        if (merkki.equals("random")) {
            Label reminder = new Label("                    Muista laskujärjestys!");
            tehtavaKomponentit.getChildren().add(reminder);
        }
        BorderPane tehtavaAsettelu = new BorderPane();
        tehtavaAsettelu.setPadding(new Insets(10,10,10,10));
        tehtavaAsettelu.setLeft(vasenMenu);
        tehtavaAsettelu.setCenter(tehtavaKomponentit);
        tehtavaNakyma = new Scene(tehtavaAsettelu, 400, 330);
        ikkuna.setScene(tehtavaNakyma);
    }
    public void laskin() {
        VBox laskinKomponentit = new VBox();
        laskinKomponentit.setSpacing(10);
        laskinKomponentit.setPadding(new Insets(10,10,10,10));
        Label otsikko = new Label("Syötä lauseke allaolevaan kenttään \n ");
        TextField lauseke = new TextField();
        Button laske = new Button();
        laske.setText("Laske");
        laske.setMinWidth(70);
        Label vastaus = new Label("\n\nVastaus on =\n\n");
        Button ohje = new Button();
        ohje.setMinWidth(70);
        ohje.setText("Ohje");
        ohje.setOnAction(e -> { //Tehdään pop up ikkuna ohjeille
            Popup popup = new Popup();
            popup.setAutoHide(true);
            Label ohjeet = new Label("Tässä laskimessa voit käyttää\n"
                             + "plus-, miinus-, kerto- ja jakomerkkejä\n"
                             + "sekä sulkuja ja etumerkkejä.");
            BorderPane popupAsettelu = new BorderPane();
            popupAsettelu.setMinHeight(100);
            popupAsettelu.setMinWidth(300);
            popupAsettelu.setStyle(" -fx-background-color: white;");
            popupAsettelu.setCenter(ohjeet);
            popup.getContent().add(popupAsettelu);
            popup.show(ikkuna);
        });
        laske.setOnAction(e -> {
            try {
                String tulos = String.valueOf(Math.round(laskin.laske(lauseke.getText()) * 100.0) / 100.0);
                vastaus.setText("\n\nVastaus on = " + tulos + "\n\n");
            }
            catch (Exception error) { //Virhe popup
                Popup popup = new Popup();
                popup.setAutoHide(true);
                Label errorMesssage = new Label("Virhe, yritä uudelleen\n\n"
                        + "Tarkista että käytät syötteessä\n"
                        + "- numeroita\n"
                        + "- merkkejä + , - , * , /\n"
                        + "- oikean verran sulkuja ( )");
                BorderPane popupAsettelu = new BorderPane();
                popupAsettelu.setMinHeight(150);
                popupAsettelu.setMinWidth(300);
                popupAsettelu.setStyle(" -fx-background-color: white;");
                popupAsettelu.setCenter(errorMesssage);
                popup.getContent().add(popupAsettelu);
                popup.show(ikkuna);
            }
        });
        laskinKomponentit.getChildren().addAll(otsikko, lauseke, laske, vastaus, ohje);
        BorderPane laskinAsettelu = new BorderPane();
        laskinAsettelu.setPadding(new Insets(10,10,10,10));
        laskinAsettelu.setLeft(vasenMenu);
        laskinAsettelu.setCenter(laskinKomponentit);
        laskinNakyma = new Scene(laskinAsettelu, 400, 330);
        ikkuna.setScene(laskinNakyma); 
    }
    public void vaikeusaste() {
        Label vaihteluLabel = new Label("Voit vaihtaa tästä tekijöiden suuruutta");
        HBox vaihteluNapit = new HBox();
        Button vaihtelu1 = new Button("0-10");
        Button vaihtelu2 = new Button("0-100");
        Button vaihtelu3 = new Button("0-1000");
        vaihtelu1.setMinWidth(70);
        vaihtelu2.setMinWidth(70);
        vaihtelu3.setMinWidth(70);
        vaihtelu1.setOnAction(e -> {
            tehtava.setVaihtelu(10);
        });
        vaihtelu2.setOnAction(e -> {
            tehtava.setVaihtelu(100);
        });
        vaihtelu3.setOnAction(e -> {
            tehtava.setVaihtelu(1000);
        });
        Label spacing = new Label("");
        vaihteluNapit.getChildren().addAll(vaihtelu1, vaihtelu2, vaihtelu3);
        Label vaikeusLabel = new Label("Voit vaihtaa tästä tekijöiden määrää");
        HBox vaikeusNapit = new HBox();
        Button vaikeus1 = new Button("2");
        Button vaikeus2 = new Button("3");
        Button vaikeus3 = new Button("4");
        Button vaikeus4 = new Button("5");
        vaikeus1.setMinWidth(50);
        vaikeus2.setMinWidth(50);
        vaikeus3.setMinWidth(50);
        vaikeus4.setMinWidth(50);
        vaikeus1.setOnAction(e -> {
            tehtava.setVaikeus(1);
        });
        vaikeus2.setOnAction(e -> {
            tehtava.setVaikeus(2);
        });
        vaikeus3.setOnAction(e -> {
            tehtava.setVaikeus(3);
        });
        vaikeus4.setOnAction(e -> {
            tehtava.setVaikeus(4);
        });
        vaikeusNapit.getChildren().addAll(vaikeus1, vaikeus2, vaikeus3, vaikeus4);
        
        VBox vaikeusKomponentit = new VBox();
        vaikeusKomponentit.setSpacing(10);
        vaikeusKomponentit.setPadding(new Insets(10,10,10,10));
        vaikeusKomponentit.getChildren().addAll(vaihteluLabel, vaihteluNapit, spacing, vaikeusLabel, vaikeusNapit);
        BorderPane vaikeusAsettelu = new BorderPane();
        vaikeusAsettelu.setPadding(new Insets(10,10,10,10));
        vaikeusAsettelu.setLeft(vasenMenu);
        vaikeusAsettelu.setCenter(vaikeusKomponentit);
        vaikeusNakyma = new Scene(vaikeusAsettelu, 400, 330);
        ikkuna.setScene(vaikeusNakyma); 
        
    }
    public void tilastot() {
        /*
        Asenna käyttäjälogi tekstitiedostoon ja ylläpidä tehtyjen
        tehtävien lkm, oikeinvastaus%, väärinvastaus% yms
        
        Scene tilastotNakyma = new Scene();
        */
    }
}
