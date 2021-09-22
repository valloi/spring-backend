package org.vi.app.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;
import org.vi.app.data.MediaFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@UtilityClass
@Log4j2
public class FileUtils {
    public static byte[] zipMediaFiles(MediaFile ...mediaFiles){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ZipOutputStream zipOut = new ZipOutputStream(output);
        try {
            for (MediaFile file : mediaFiles) {
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOut.putNextEntry(zipEntry);
                zipOut.write(file.getContents());
            }
            zipOut.close();
        } catch (IOException e) {
            log.error("zipMediaFiles error.", e);
        }

        return output.toByteArray();
    }
}
