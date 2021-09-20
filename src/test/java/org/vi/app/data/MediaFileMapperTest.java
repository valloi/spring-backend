package org.vi.app.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MediaFileMapperTest {
    byte[] contents = {97,98,99,100,101,102,35};

    @Autowired
    MediaFileMapper mediaFileMapper;

    @Test
    void shouldMapFromEntity() {

        MediaFile mediaFile = getMediaFile(contents);

        MediaFileDto mediaFileDto = mediaFileMapper.fromEntity(mediaFile);

        Assertions.assertEquals("file", mediaFileDto.getName());
        Assertions.assertEquals("txt", mediaFileDto.getExtension());
        Assertions.assertArrayEquals(contents, mediaFileDto.getContents());
    }


    @Test
    void shouldMapFromDto() {
        MediaFileDto mediaFileDto = getMediaFileDto(contents);

        MediaFile mediaFile = mediaFileMapper.fromDto(mediaFileDto);

        Assertions.assertEquals("file", mediaFile.getName());
        Assertions.assertEquals("txt", mediaFile.getExtension());
        Assertions.assertArrayEquals(contents, mediaFile.getContents());
    }

    @Test
    void shouldMapToBase64() {
        MediaFile mediaFile = getMediaFile(contents);

        MediaFileBase64 mediaFileBase64 = mediaFileMapper.toBase64(mediaFile);

        Assertions.assertEquals("file", mediaFileBase64.getName());
        Assertions.assertEquals("txt", mediaFileBase64.getExtension());
        Assertions.assertEquals("YWJjZGVmIw==", mediaFileBase64.getContentsBase64());
    }

    private MediaFile getMediaFile(byte[] contents) {

        return MediaFile.builder()
                .name("file")
                .extension("txt")
                .contents(contents)
                .build();
    }

    private MediaFileDto getMediaFileDto(byte[] contents) {

        return MediaFileDto.builder()
                .name("file")
                .extension("txt")
                .contents(contents)
                .build();
    }

}