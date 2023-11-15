package com.strauss.passwordgenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

    @GetMapping("/generate")
    public String generatePassword(@RequestParam(value = "length", defaultValue = "8") int passwordLength) {

        String lowerCases = "abcdefghijklmnopqrstuvwxyz";
        String upperCases = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()_+";

        StringBuilder password = new StringBuilder(passwordLength);

        for(int i = 0; i < passwordLength; i++) {
            int random = (int) (Math.random() * 4);

            switch(random) {
                case 0:
                    random = (int) (lowerCases.length() * Math.random());
                    password.append(lowerCases.charAt(random));
                    break;
                case 1:
                    random = (int) (upperCases.length() * Math.random());
                    password.append(upperCases.charAt(random));
                    break;
                case 2:
                    random = (int) (numbers.length() * Math.random());
                    password.append(numbers.charAt(random));
                    break;
                case 3:
                    random = (int) (specialCharacters.length() * Math.random());
                    password.append(specialCharacters.charAt(random));
                    break;
            }
        }
        return password.toString();
    }
}
