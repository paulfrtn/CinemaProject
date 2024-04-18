package Controller.SignUp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.*;

// Nous allons créer deux fonctions :
// - hashPassword : qui prend un mot de passe en paramètre et le hash en SHA-256
// - checkPassword : qui prend un mot de passe et un hash en SHA-256 et vérifie si le mot de passe correspond au hash

// SHA-256 est une fonction de hachage cryptographique qui prend un mot de passe et le transforme en une chaîne de caractères de 64 caractères
// Plus précisément, SHA-256 prend un mot de passe et le transforme en une chaîne de caractères de 256 bits (32 octets) qui est ensuite encodée en base64 pour être stockée dans la base de données.
// Base64 est un encodage qui permet de stocker des données binaires dans une chaîne de caractères.
public class Hash {
    public static String hashPassword(String password) throws RuntimeException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not found", e);
        }
    }

    public static boolean comparePassword(String password, String hashedPassword) {
        if(hashPassword(password).equals(hashedPassword)){
            System.out.println("Mot de passe correct");
            return true;
        }else{
            System.out.println("Mot de passe incorrect");
            return false;
        }
    }
}

