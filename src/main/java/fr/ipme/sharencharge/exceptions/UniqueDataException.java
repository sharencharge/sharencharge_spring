package fr.ipme.sharencharge.exceptions;

public class UniqueDataException extends RuntimeException{
    public UniqueDataException() {
        super("Duplicated Data try to be create ! ");
    }
}
