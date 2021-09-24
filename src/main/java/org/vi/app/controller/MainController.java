package org.vi.app.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
@AllArgsConstructor
@RequestMapping("/")
public class MainController {
    private final ResourceLoader resourceLoader;

    @GetMapping("/")
    public ResponseEntity<Resource> getMainPage() {
        Resource resource = resourceLoader.getResource("classpath:html/index.html");
        return ResponseEntity
                .ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource);
    }

}
