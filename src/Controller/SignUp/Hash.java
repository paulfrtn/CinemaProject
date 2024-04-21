package Controller.SignUp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Cette classe fournit des méthodes pour le hachage des mots de passe et la vérification des mots de passe hachés.
 */
public class Hash {

    /**
     * Hache le mot de passe en utilisant l'algorithme SHA-256.
     *
     * @param password le mot de passe à hacher
     * @return le mot de passe haché encodé en base64
     * @throws RuntimeException si l'algorithme de hachage SHA-256 n'est pas trouvé
     */
    public static String hashPassword(String password) throws RuntimeException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algorithme de hachage SHA-256 non trouvé", e);
        }
    }

    /**
     * Compare un mot de passe brut avec un mot de passe haché pour vérifier s'ils correspondent.
     *
     * @param password       le mot de passe brut à comparer
     * @param hashedPassword le mot de passe haché à comparer
     * @return true si les mots de passe correspondent, sinon false
     */
    public static boolean comparePassword(String password, String hashedPassword) {
        if (hashPassword(password).equals(hashedPassword)) {
            System.out.println("Mot de passe correct");
            return true;
        } else {
            System.out.println("Mot de passe incorrect");
            return false;
        }
    }
}
