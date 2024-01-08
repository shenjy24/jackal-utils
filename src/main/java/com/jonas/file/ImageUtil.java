package com.jonas.file;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * ImageUtil
 *
 * @author shenjy
 * @time 2024/1/8 14:25
 */
public class ImageUtil {

    public static void base64ToImage(String base64Image, String savePath) {
        // 解码Base64字符串
        byte[] decodedBytes = Base64.getDecoder().decode(base64Image);

        // 将解码后的字节数组写入图片文件
        try (OutputStream stream = Files.newOutputStream(Paths.get(savePath))) {
            stream.write(decodedBytes);
        } catch (Exception e) {
            System.out.println("出现异常: " + e.getMessage());
        }
        System.out.println("图片已成功解码并保存为文件: " + savePath);
    }
}
