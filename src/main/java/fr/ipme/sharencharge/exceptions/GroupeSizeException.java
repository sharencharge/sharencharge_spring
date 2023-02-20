package fr.ipme.sharencharge.exceptions;

public class GroupeSizeException extends RuntimeException{
    public GroupeSizeException(Integer id) {
        super("nombre d'equipe dans le groupe incorrect : " + id);
    }
}
