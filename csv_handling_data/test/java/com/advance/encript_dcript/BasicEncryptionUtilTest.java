package com.advance.encript_dcript;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Base64;

import org.junit.jupiter.api.*;

public class BasicEncryptionUtilTest {

 @Test
 public void testEncryptionAndDecryption() {
     // Arrange: The original data
     String originalData = "SensitiveData123";

     // Act: Encrypt the data
     String encryptedData = BasicEncryptionUtil.encrypt(originalData);
     
     // Assert: Ensure that encryption produces a non-null, non-empty result
     assertNotNull(encryptedData);
     assertFalse(encryptedData.isEmpty());
     
     // Act: Decrypt the data
     String decryptedData = BasicEncryptionUtil.decrypt(encryptedData);

     // Assert: The decrypted data should match the original data
     assertEquals(originalData, decryptedData, "Decrypted data does not match the original data.");
 }

 @Test
 public void testInvalidDecryption() {
     // Arrange: Corrupted encrypted data
     String corruptedData = "CorruptedBase64Data!@#";

     // Act & Assert: Ensure that decrypting corrupted data throws a RuntimeException
     RuntimeException exception = assertThrows(RuntimeException.class, () -> {
         BasicEncryptionUtil.decrypt(corruptedData);
     });

     // Assert: Check that the exception message indicates an error during decryption
     assertTrue(exception.getMessage().contains("Error decrypting data"));
 }

 @Test
 public void testEmptyStringEncryption() {
     // Arrange: Empty data
     String emptyData = "";

     // Act: Encrypt the empty data
     String encryptedData = BasicEncryptionUtil.encrypt(emptyData);

     // Assert: Ensure that the encrypted data is not null or empty
     assertNotNull(encryptedData);
     assertEquals("", new String(Base64.getDecoder().decode(encryptedData)), "Decrypted data should be empty.");
 }


 @Test
 public void testNullDataDecryption() {
     // Arrange: Null encrypted data
     String nullEncryptedData = null;

     // Act & Assert: Ensure that decrypting null throws a NullPointerException
     assertThrows(NullPointerException.class, () -> {
         BasicEncryptionUtil.decrypt(nullEncryptedData);
     });
 }
}

