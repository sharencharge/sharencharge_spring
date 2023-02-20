package fr.ipme.sharencharge.exceptions;

public class RoleNotDefinedException extends RuntimeException {
    public RoleNotDefinedException() {
        super("No Role defined in new User");
    }
}
