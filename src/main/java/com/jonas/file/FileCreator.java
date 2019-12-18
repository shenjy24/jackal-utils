package com.jonas.file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * </p>
 *
 * @author shenjiayun
 * @since 2019-12-17
 */
public class FileCreator {

    public static boolean copyFile(String targetFileName, File sourceFile) {
        File file = new File(targetFileName);
        if (file.exists() || !sourceFile.exists()) {
            return false;
        }
        InputStream initialStream = null;
        try {
            initialStream = FileUtils.openInputStream(sourceFile);
            FileUtils.copyInputStreamToFile(initialStream, file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
