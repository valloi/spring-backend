package org.vi.app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class FileServiceTest {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    FileService fileService;

    @Test
    void getWhiskeyFile() {
        byte[] whiskeyFile = fileService.getWhiskeyFile();

        assertNotEquals(new byte[0], whiskeyFile);
        assertEquals(readWhiskeyBase64String(), encodeToBase64(whiskeyFile));
    }

    private String readWhiskeyBase64String() {
        try {
            Resource resource = resourceLoader.getResource("classpath:files/Whiskey_in_the_jar.txt");
            return new String(resource.getInputStream().readAllBytes());
        } catch (IOException e) {
            return null;
        }
    }

    private String encodeToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
}