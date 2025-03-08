package org.automation.constants;

public enum SignInDetails {

    SIGNIN_USER("testbogdantudor@gmail.com", "T"),;

    private final String username;
    private String password;

    SignInDetails(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
