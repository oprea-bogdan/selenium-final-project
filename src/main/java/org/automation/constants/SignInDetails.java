package org.automation.constants;

public enum SignInDetails {

    SIGNIN_USER("testbogdantudor@gmail.com", "Testproject_2024");

    private final String username;
    private String password;

    SignInDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }

    SignInDetails(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
