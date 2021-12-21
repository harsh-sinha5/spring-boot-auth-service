package com.covidmgmt.user.util;

import com.lambdaworks.crypto.SCryptUtil;

public class PasswordHashUtil {

    public static String hashPassword(String pwdToHash){
        return SCryptUtil.scrypt(pwdToHash, 16, 16, 16);
    }
}
