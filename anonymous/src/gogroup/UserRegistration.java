/*
package gogroup;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration {
}


// /user  GET
// /signup POST --body
// /login  POST

class User {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
}

// Singup takes number of fields
class SignupDetails {
    String name;
    String email;
    String password;
}

// Controller
// Path: /user
class UserController {

    boolean signUp(SignupDetails signupDetails) {
        // Pre-validations | empty fields checked here
        // if false, StatusCode of 400 Bad Request with errors



    }

    private boolean validate(SignupDetails signupDetails) {
        // if (signupDetails.email ) Empty return false;
        return true;
    }
}

class UserService {

    // If using Dependency Injection | else create objects of dependencies in constructor
    PasswordService passwordService;
    UserRepository userRepository;

    // Start the transaction here
    private User signUp(SignupDetails signupDetails) {

        List<UserErrors> errors = new ArrayList<>();  // represents list of errors.
        passwordService.setLength(12); // business-logic password length needed.
        String newPassword = passwordService.generate(signupDetails.password); // if user provided good specification meeting password, else generate new
        if (checkUsername(signupDetails.name)) {
            errors.add(new UserErrors("username.invalid", ".."));
            throw new Error(errors, 400); // Not defining another Error class, usually that is given by frameworks;
        }
        // Convert SignupDetails to User
        User newUser = convertToUser(signupDetails);
        // few more checks which may impact business like no. of seats
        // checkForSeatsRemaining();

        User createdUser = userRepository.save(newUser);

        // Also you may decide to send password over email / sms
        // sendUserPassword();
        createdUser.setPassword(null);
        // hide other details
        return createdUser;
    }

    private boolean checkUsername(String username) {
        // length of username. contaning special characters.
        return true;
    }

    private boolean isEmpty(String t) {
        // generaly done by frameworks and languages
        return true;
    }
}


class PasswordService {

    private int length; // represents default length password

    public void setLength(int length) {
        this.length = length;
    }

    public String generate() {
        // use some library to generate this.length
        return "generatedPassword".substring(0, this.length);
    }

    public String generate(String existingPassword) {
        if (existingPassword != null) {
            return generate();
        }
        if (checksRules(existingPassword)) {
            return existingPassword;
        } else {
            throw new Error("incorrect.specification.password"); // i18n friendly.
        }
    }

    private boolean checksRules(String password) {
        return true;
    }
}

// The one with deals with persistence layer, be it DB relation or no-relational or maybe File systems as well
// Making it interface since, Relational DB can hv class implementing it, similarly others
interface UserRepository {

    User save();
    boolean delete();
    // etc
}

class UserErrors {

    UserErrors(String a, String b) {

    }
    private String key;
    private String description;
}*/
