package controller;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class LoginCommand {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
    private boolean rememberEmail;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberEmail() {
        return rememberEmail;
    }

    public void setRememberEmail(boolean rememberEmail) {
        this.rememberEmail = rememberEmail;
    }
}
