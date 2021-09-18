package org.vi.app.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vi.app.service.FileService;


@RestController
@AllArgsConstructor
@Log4j2
public class FileController {

    FileService fileService;

    @GetMapping("/whiskeyfile")
    public ResponseEntity<byte[]> getFile() {
        return ResponseEntity
                .ok()
                .contentType(
                        MediaType.parseMediaType("application/pdf"))
                .header("Content-Disposition", "attachment;filename=\"Whiskey_in_the_jar.pdf\"")
                .body(fileService.getWhiskeyFile());
    }

}
