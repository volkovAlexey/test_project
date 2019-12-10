package ua.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.exceptions.DataNotFoundException;
import ua.service.UserService;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Validator {
    private static final String EMPTY_FIELD = "This field is required!";
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                    "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String WRONG_EMAIL = "Wrong email!";
    private static final String EMAIL_ALREADY_EXISTS = "This email already exists!";
    private static final String NAME_ALREADY_EXISTS = "This name already exists!";
    private static final String NAME_NOT_FOUND = "The username or password you entered is incorrect";
    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    @Autowired
    private final UserService userService;

    public Validator(UserService userService) {
        this.userService = userService;
    }

    public void validateStringField(String fieldName, String value, Map<String, String> errorsMap) {
        if (isEmptyField(value)) {
            errorsMap.put(fieldName, EMPTY_FIELD);
        }
    }

    public void emailValidation(String fieldName, String value, Map<String, String> errorMap) {
        Matcher matcher = pattern.matcher(value);
        if (!matcher.matches()) {
            errorMap.put(fieldName, WRONG_EMAIL);
            return;
        }
        if (hasEmail(value)) {
            errorMap.put(fieldName, EMAIL_ALREADY_EXISTS);
        }
    }

    public void nameValidation(String fieldName, String value, Map<String, String> errorMap) {
        if (hasName(value)) {
            errorMap.put(fieldName, NAME_ALREADY_EXISTS);
        }
    }

    public void checkUser(String fieldName, String valueName, String valuePassword, Map<String, String> errorMap) {
        if (!hasUser(valueName, valuePassword)) {
            errorMap.put(fieldName, NAME_NOT_FOUND);
        }
    }

    private boolean hasUser(String valueName, String valuePassword) {
        try {
            userService.getUserByNameAndPassword(valueName, valuePassword);
        } catch (DataNotFoundException e) {
            return false;
        }
        return true;
    }

    private boolean hasEmail(String email) {
        try {
            userService.getUserByEmail(email);
        } catch (DataNotFoundException e) {
            return false;
        }
        return true;
    }

    private boolean hasName(String name) {
        try {
            userService.getUserByName(name);
        } catch (DataNotFoundException e) {
            return false;
        }
        return true;
    }

    private boolean isEmptyField(String text) {
        return text == null || text.trim().isEmpty();
    }
}
