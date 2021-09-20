package org.vi.app.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MediaFileDto {
    private String name;
    private String extension;
    private byte[] contents;
}
