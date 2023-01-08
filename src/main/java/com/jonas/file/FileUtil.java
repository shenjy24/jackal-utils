package com.jonas.file;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件操作工具
 *
 * @author shenjiayun
 * @since 2019-12-17
 */
public class FileUtil {

    /**
     * 获取某路径下的文件
     *
     * @param path       目录路径
     * @param extensions 扩展名
     * @param recursive  是否递归
     * @return
     */
    public static List<File> listFile(String path, String[] extensions, boolean recursive) {
        URL url = FileUtil.class.getClassLoader().getResource(path);
        if (url == null) {
            return new ArrayList<>();
        }
        File file = new File(url.getPath());
        if (!file.exists()) {
            return new ArrayList<>();
        }
        return new ArrayList<>(FileUtils.listFiles(file, extensions, recursive));
    }

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
            FileUtils.copyInputStreamToFile(sourceInputStream, targetFile);
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

    public static String readFileContent(File file) {
        try {
            return IOUtils.toString(file.toURI(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readFileToString(String fileName) {
        File file = new File(FileUtil.class.getClassLoader().getResource(fileName).getPath());
        return readFileToString(file);
    }

    public static String readFileToString(File file) {
        try {
            return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        List<File> files = listFile("config", new String[]{"yml"}, true);
        System.out.println(files);
    }
}
