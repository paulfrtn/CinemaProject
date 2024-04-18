package View.TestPage;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ImageFileChooserExample extends JFrame {

    private JLabel imageLabel;

    public ImageFileChooserExample() {
        setTitle("Sélectionner et Enregistrer une Image");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        imageLabel = new JLabel("Aucune image sélectionnée");
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        JButton chooseImageButton = new JButton("Choisir une image");
        chooseImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseImage();
            }
        });
        mainPanel.add(chooseImageButton, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void chooseImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                saveImage(selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveImage(File selectedFile) throws IOException {
        // Copie le fichier sélectionné vers un emplacement et un nom de fichier spécifiés
        File destinationFile = new File("chemin/vers/votre/repertoire/" + "nom_image.jpg"); // Changez le chemin et le nom du fichier selon vos besoins
        Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        imageLabel.setText("Image enregistrée: " + destinationFile.getAbsolutePath());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ImageFileChooserExample().setVisible(true);
        });
    }
}
