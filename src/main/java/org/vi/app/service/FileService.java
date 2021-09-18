package org.vi.app.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service
@Log4j2
public class FileService {

    @Autowired
    ResourceLoader resourceLoader;

    public byte[] getWhiskeyFile() {
        Resource resource = resourceLoader.getResource("classpath:files/Whiskey_in_the_jar.pdf");
        byte[] contents = new byte[0];
        try {
            contents = resource.getInputStream().readAllBytes();
        } catch (IOException e) {
            log.error("Failed to fetch file", e);
        }
        return contents;
    }
}
