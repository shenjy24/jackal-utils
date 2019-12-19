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

    /**
     * 文件复制
     *
     * @param targetFileName 目标文件名
     * @param sourceFile     源文件
     * @return
     */
    public static boolean copyFile(String targetFileName, File sourceFile) {
        File file = new File(targetFileName);
        if (file.exists() || !sourceFile.exists()) {
            return false;
        }
        try {
            InputStream initialStream = FileUtils.openInputStream(sourceFile);
            FileUtils.copyInputStreamToFile(initialStream, file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 创建文件及其父目录
     *
     * @param file
     * @return
     */
    public static File createFile(File file) {
        if (null == file) {
            return null;
        }
        if (!file.exists()) {
            mkParentDirs(file);
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }

    /**
     * 创建所给文件或目录的父目录
     *
     * @param file 文件或目录
     * @return 父目录
     */
    public static File mkParentDirs(File file) {
        final File parentFile = file.getParentFile();
        if (null != parentFile && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return parentFile;
    }
}
