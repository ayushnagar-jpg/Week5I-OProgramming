package com.advance.encript_dcript;

import java.util.Base64;

public class BasicEncryptionUtil {

    // Encrypt data using Base64 encoding
    public static String encrypt(String data) {
        try {
            return Base64.getEncoder().encodeToString(data.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Error encrypting data", e);
        }
    }

    // Decrypt data using Base64 decoding
    public static String decrypt(String encryptedData) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error decrypting data", e);
        }
    }
}
