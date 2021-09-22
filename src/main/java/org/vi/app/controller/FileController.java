package org.vi.app.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vi.app.data.MediaFile;
import org.vi.app.service.FileService;

import static org.vi.app.util.FileUtils.zipMediaFiles;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/api")
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

    @GetMapping("/gettwofiles")
    public ResponseEntity<byte[]> getTwoFiles() {
        MediaFile whiskeyFile = fileService.getFileByName("Whiskey_in_the_jar.pdf");
        MediaFile orcFile = fileService.getFileByName("Overall ORC I.pdf");

        return ResponseEntity
                .ok()
                .contentType(
                        MediaType.parseMediaType("application/zip"))
                .header("Content-Disposition", "attachment;filename=\"documents.zip\"")
                .body(zipMediaFiles(whiskeyFile, orcFile));
    }

}
