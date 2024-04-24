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

/**
 * Classe pour afficher une vidéo dans une fenêtre popup.
 */
public class BandeADiffuser {

    /**
     * Affiche une fenêtre popup contenant une vidéo.
     *
     * @param videoPath Le chemin vers le fichier vidéo
     */
    public static void showVideoPopup(String videoPath) {
        JFXPanel jfxPanel = new JFXPanel();
        jfxPanel.setBackground(Color.BLACK);

        File file = new File(videoPath);

        Media media = new Media(file.toURI().toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);

        MediaView mediaView = new MediaView(mediaPlayer);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(mediaView);

        Button playButton = new Button("Play");
        Button pauseButton = new Button("Pause");
        Button stopButton = new Button("Stop");

        playButton.setOnAction(e -> mediaPlayer.play());
        pauseButton.setOnAction(e -> mediaPlayer.pause());
        stopButton.setOnAction(e -> {
            mediaPlayer.stop();
            mediaPlayer.seek(Duration.ZERO);
        });

        borderPane.setBottom(new HBox(playButton, pauseButton, stopButton));

        Scene scene = new Scene(borderPane);

        mediaPlayer.setOnReady(() -> {
            mediaPlayer.seek(Duration.ZERO);
            mediaPlayer.play();
        });

        jfxPanel.setScene(scene);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(jfxPanel, BorderLayout.CENTER);

        // Créez un conteneur Swing JFrame pour contenir le JPanel
        JFrame frame = new JFrame("Video Popup");
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fermer la fenêtre lorsque le pop-up est fermé
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        frame.setContentPane(panel);
        frame.setVisible(true);
    }
}

