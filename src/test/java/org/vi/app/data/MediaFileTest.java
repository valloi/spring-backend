package org.vi.app.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaFileTest {

    @Test
    void builder() {
        byte[] contents = {20,10,30,5};
        MediaFile mediaFile = MediaFile.builder()
                .name("file")
                .extension("txt")
                .contents(contents)
                .build();
        Assertions.assertEquals("file", mediaFile.getName());
        Assertions.assertEquals("txt", mediaFile.getExtension());
        Assertions.assertEquals(contents, mediaFile.getContents());
    }
}