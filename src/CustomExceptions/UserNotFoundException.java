package CustomExceptions;

/**
 * Une exception personnalisée pour indiquer qu'un utilisateur n'a pas été trouvé.
 */
public class UserNotFoundException extends Exception {

    /**
     * Constructeur prenant un message d'erreur en paramètre.
     *
     * @param message le message d'erreur décrivant la raison de l'exception
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
