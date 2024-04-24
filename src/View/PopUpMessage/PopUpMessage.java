package View.PopUpMessage;

import javax.swing.JOptionPane;

/**
 * Classe utilitaire pour afficher des messages contextuels sous forme de pop-up.
 */
public class PopUpMessage {

    /**
     * Affiche un message d'erreur sous forme de pop-up.
     *
     * @param message Le message d'erreur à afficher.
     */
    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Affiche un message de succès sous forme de pop-up.
     *
     * @param message Le message de succès à afficher.
     */
    public static void showSuccessMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Succès", JOptionPane.INFORMATION_MESSAGE);
    }
}

