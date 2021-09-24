package org.vi.app.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.vi.app.data.MediaFile;

import java.io.IOException;

@Service
@Log4j2
@AllArgsConstructor
public class FileService {

    private final ResourceLoader resourceLoader;

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


    public MediaFile getFileByName(String name) {
        Resource resource = resourceLoader.getResource("classpath:files/" + name );
        byte[] contents = new byte[0];
        try {
            contents = resource.getInputStream().readAllBytes();
        } catch (IOException e) {
            log.error("Failed to fetch file", e);
        }

        return MediaFile.builder()
                .name(name)
                .contents(contents)
                .build();
    }
}
