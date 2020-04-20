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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Popup;

/**
 *
 * @author petri
 */
public class GeneraattoriUI extends Application {
    
    Stage ikkuna;
    Scene aloitusNakyma, tehtavaNakyma, laskinNakyma, vaikeusasteNakyma;
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
        Button yhteen = new Button();
        yhteen.setText("Yhteenlasku");
        yhteen.setOnAction(e -> tehtava("+"));
        Button vahennys = new Button();
        vahennys.setText("Vähennyslasku");
        vahennys.setOnAction(e -> tehtava("-"));
        Button kerto = new Button();
        kerto.setText("Kertolasku");
        kerto.setOnAction(e -> tehtava("*"));
        Button jako = new Button();
        jako.setText("Jakolasku");
        jako.setOnAction(e -> tehtava(":"));
        Button laskin = new Button();
        laskin.setText("Laskin");
        laskin.setOnAction(e -> laskin());
        Button vaikeusaste = new Button();
        vaikeusaste.setText("Vaikeusaste");
        vaikeusaste.setOnAction(e -> vaikeusaste());
        Button tilastot = new Button();
        tilastot.setText("Tilastot");
        tilastot.setOnAction(e -> tilastot());
        //Vasen menu
        vasenMenu = new VBox();
        vasenMenu.setSpacing( 10);
        vasenMenu.getChildren().addAll(aloitus, yhteen, vahennys);
        vasenMenu.getChildren().addAll(kerto, jako, laskin);
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
        aloitusNakyma = new Scene(aloitusAsettelu, 400, 300);
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
        aloitusNakyma = new Scene(aloitusAsettelu, 400, 300);
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
            if (tehtava.tarkistus(vastaus.getText())) {
                vastausViesti.setText("Oikein!");
            } else {
                vastausViesti.setText("Väärin");
            }
        });
        BorderPane tehtavaAsettelu = new BorderPane();
        tehtavaAsettelu.setPadding(new Insets(10,10,10,10));
        tehtavaAsettelu.setLeft(vasenMenu);
        tehtavaAsettelu.setCenter(tehtavaKomponentit);
        tehtavaNakyma = new Scene(tehtavaAsettelu, 400, 300);
        ikkuna.setScene(tehtavaNakyma);
    }
    public void laskin() {
        VBox laskinKomponentit = new VBox();
        laskinKomponentit.setSpacing(10);
        laskinKomponentit.setPadding(new Insets(10,10,10,10));
        Label otsikko = new Label("Syötä lauseke allaolevaan kenttään");
        TextField lauseke = new TextField();
        Button laske= new Button();
        laske.setText("Laske");
        Label vastaus = new Label("\n\nVastaus on =\n\n");
        Button ohje = new Button();
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
            String tulos = String.valueOf(Math.round(laskin.laske(lauseke.getText()) * 100.0) / 100.0);
            vastaus.setText("\n\nVastaus on = " + tulos + "\n\n");
        });
        laskinKomponentit.getChildren().addAll(otsikko, lauseke, laske, vastaus, ohje);
        BorderPane laskinAsettelu = new BorderPane();
        laskinAsettelu.setPadding(new Insets(10,10,10,10));
        laskinAsettelu.setLeft(vasenMenu);
        laskinAsettelu.setCenter(laskinKomponentit);
        laskinNakyma = new Scene(laskinAsettelu, 400, 300);
        ikkuna.setScene(laskinNakyma); 
    }
    public void vaikeusaste() {
        /*
        Muokkaa tehtäväluokkaa lisäämään tekijöitä vaikeusasteen mukaan
        
        Scene vaikeusasteNakyma = new Scene();
        ikkuna.setScene(vaikeusasteNakyma);
        */
    }
    public void tilastot() {
        /*
        Asenna käyttäjälogi tekstitiedostoon ja ylläpidä tehtyjen
        tehtävien lkm, oikeinvastaus%, väärinvastaus% yms
        
        Scene tilastotNakyma = new Scene();
        */
    }
}
