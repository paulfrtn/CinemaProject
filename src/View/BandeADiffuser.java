package View;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import javafx.scene.layout.HBox;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class BandeADiffuser {

    public static void showVideoPopup(String videoPath) {
        JFXPanel jfxPanel = new JFXPanel(); // Crée un panneau JFXPanel pour afficher la vidéo

        // Créez un objet File à partir du chemin de la vidéo
        File file = new File(videoPath);

        // Créez un objet Media avec le fichier vidéo
        Media media = new Media(file.toURI().toString());

        // Créez un lecteur multimédia avec le fichier Media
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        // Créez une vue multimédia pour afficher le lecteur multimédia
        MediaView mediaView = new MediaView(mediaPlayer);

        // Créez un conteneur JavaFX BorderPane pour contenir la vue multimédia et les contrôles
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(mediaView);

        // Créez des boutons pour les contrôles de lecture
        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button stopButton = new Button("Stop");

        // Ajoutez des actions aux boutons pour contrôler le lecteur multimédia
        playButton.setOnAction(e -> mediaPlayer.play());
        pauseButton.setOnAction(e -> mediaPlayer.pause());
        stopButton.setOnAction(e -> {
            mediaPlayer.stop();
            mediaPlayer.seek(Duration.ZERO);
        });

        // Ajoutez les boutons au conteneur BorderPane
        borderPane.setBottom(new HBox(playButton, pauseButton, stopButton));

        // Créez une scène JavaFX avec le conteneur BorderPane
        Scene scene = new Scene(borderPane);

        // Initialiser le lecteur multimédia
        mediaPlayer.setOnReady(() -> {
            mediaPlayer.seek(Duration.ZERO); // Rembobiner la vidéo au début
            mediaPlayer.play(); // Lancer la lecture de la vidéo
        });

        // Ajouter la scène au JFXPanel
        jfxPanel.setScene(scene);

        // Créez un conteneur Swing JPanel pour contenir le panneau JFXPanel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(jfxPanel, BorderLayout.CENTER);

        // Créez un conteneur Swing JFrame pour contenir le JPanel
        JFrame frame = new JFrame("Video Popup");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermer la fenêtre lorsque le pop-up est fermé
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}
