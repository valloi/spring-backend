package org.vi.app.data;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Base64;

@Mapper(componentModel = "spring")
public interface MediaFileMapper {
    MediaFileDto fromEntity(MediaFile entity);

    MediaFile fromDto(MediaFileDto dto);

    @Mapping(target = "contentsBase64", source = "contents", qualifiedByName = "toBase64")
    MediaFileBase64 toBase64(MediaFile entity);

    @Named("toBase64")
    default String bytesToBase64(byte[] in) {
        return (in == null || in.length == 0) ? null : Base64.getEncoder().encodeToString(in);
    }

}
