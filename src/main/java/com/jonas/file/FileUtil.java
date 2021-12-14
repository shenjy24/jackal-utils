package com.jonas.file;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件操作工具
 *
 * @author shenjiayun
 * @since 2019-12-17
 */
public class FileUtil {

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
            InputStream initialStream = org.apache.commons.io.FileUtils.openInputStream(sourceFile);
            org.apache.commons.io.FileUtils.copyInputStreamToFile(initialStream, file);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 文件复制
     *
     * @param targetFileName 目标文件名
     * @param sourceFileName 源文件名
     * @return
     */
    public static boolean copyFile(String targetFileName, String sourceFileName) {
        if (StringUtils.isBlank(targetFileName) || StringUtils.isBlank(sourceFileName)) {
            return false;
        }

        InputStream sourceInputStream = FileUtil.class.getClassLoader().getResourceAsStream(sourceFileName);
        if (null == sourceInputStream) {
            return false;
        }
        File targetFile = new File(targetFileName);
        if (targetFile.exists()) {
            return false;
        }
        try {
            org.apache.commons.io.FileUtils.copyInputStreamToFile(sourceInputStream, targetFile);
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
    public static boolean createFile(File file) {
        if (null == file || file.exists()) {
            return false;
        }

        mkParentDirs(file);
        try {
            file.createNewFile();
            return true;
        } catch (IOException e) {
            return false;
        }
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
