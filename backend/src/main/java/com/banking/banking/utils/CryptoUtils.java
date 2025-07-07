package com.banking.banking.utils;

import java.security.SecureRandom;

public abstract class CryptoUtils {
    public static String bytesToHexString(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte num : bytes) {
            stringBuffer.append(String.format("%2s", Integer.toHexString(num & 0xff)).replace(" ", "0"));
        }
        return stringBuffer.toString();
    }

    public static String generateSalt() {
        byte[] saltByte = SecureRandom.getSeed(16);
        return bytesToHexString(saltByte);
    }
}
