package services;

import models.User;

public interface registration {
    boolean signUp();

    boolean signIn();

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

}
