package com.survey.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class EncryptDecryptPassword {


    public  static String encrypt(String rawPassword) {

        return new BCryptPasswordEncoder().encode(rawPassword);
    }

    public static void main(String[] args) {
        System.out.println(encrypt("surveypass"));
    }


}
