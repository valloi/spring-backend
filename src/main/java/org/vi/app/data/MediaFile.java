package org.vi.app.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MediaFile {
    private String name;
    private String extension;
    private byte[] contents;
}
