package org.vi.app.data.util;

import org.mapstruct.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Base64;

@Component
public class ConversionUtil {
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ToBase64 { }

    @ToBase64
    public String toBase64(byte[] in ) {
        return in.length == 0 ? "" : Base64.getEncoder().encodeToString(in);
    }
}
