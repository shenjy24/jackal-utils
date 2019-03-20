package com.jonas.vod;

import com.alibaba.fastjson.JSON;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;

/**
 * 视频工具类
 *
 * @author shenjy 2018/12/03
 */
public class VideoUtils {

    /**
     * 获取视频信息
     *
     * @param file
     * @return
     */
    public static MultimediaInfo getVideoInfo(File file) {
        if (null == file) {
            return null;
        }

        try {
            MultimediaObject multimediaObject = new MultimediaObject(file, new MyFFMPEGLocator());
            MultimediaInfo info = multimediaObject.getInfo();
            return info;
        } catch (EncoderException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String fileName = "/Users/shenjy/Documents/resource/video/卡鲁.mp4";
        File file = new File(fileName);
        //文件大小 bytes
        System.out.println(file.length());

        System.out.println(getVideoInfo(file));
    }
}
