package br.unb.unbsolidaria.entities;

import java.io.Serializable;

/**
 * asm95 day 2016-12-04
 * Ideally this should be a super class of Voluntary and Organization because both of them are Users.
 * However, doing that so will just mess up with .persistency.DataBase
 * And forces all org/vol elements to be tied to an user account, which makes no sense (their
 * user/password would be stored there)
 */
public class User implements Serializable {
    private int         id;
    private String      login;
    private String      password;
    private UserType    type;

    public enum UserType{
        organization, voluntary
    }

    //source: http://stackoverflow.com/a/16058059
    private static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public User(String login, String password, UserType type, int id) {
        if (id < 0)
            throw new IllegalArgumentException("User ID must be positive");
        if (!isValidEmailAddress(login))
            throw new IllegalArgumentException("E-mail adress is not valid");
        if (!FormValidation.isValidPassword(password))
            throw new IllegalArgumentException("Password is not valid");

        this.login = login;
        this.password = password;
        this.type = type;
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getPassword() { return password; }

    public String getLogin() { return login; }

    public UserType getType(){
        return this.type;
    }

    public int getTypeInt(){
        switch (this.type){
            case voluntary:
                return 0;
            case organization:
                return 1;
        }
        return -1;
    }

    public static UserType getIntType(int i){
        if (i==0) return UserType.voluntary;
        return UserType.organization;
    }
}
