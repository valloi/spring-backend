package org.vi.app.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MediaFileBase64 {
    private String name;
    private String extension;
    private String contentsBase64;
}
