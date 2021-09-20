package org.vi.app.data;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.vi.app.data.util.ConversionUtil;

@Mapper(componentModel = "spring", uses = ConversionUtil.class)
public interface MediaFileMapper {
    MediaFileDto fromEntity(MediaFile entity);

    MediaFile fromDto(MediaFileDto dto);

    @Mapping(target = "contentsBase64", source = "contents", qualifiedBy = ConversionUtil.ToBase64.class)
    MediaFileBase64 toBase64(MediaFile entity);

}
