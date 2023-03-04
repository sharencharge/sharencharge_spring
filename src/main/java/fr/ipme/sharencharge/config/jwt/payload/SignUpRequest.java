package fr.ipme.sharencharge.config.jwt.payload;

import fr.ipme.sharencharge.pojos.Role;

import java.util.Set;

public class SignUpRequest extends LoginRequired{
    private Set<String> roles;

    public SignUpRequest(String email, String password, Set<String> roles) {
        super(email, password);
        this.roles = roles;
    }

    public SignUpRequest(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
