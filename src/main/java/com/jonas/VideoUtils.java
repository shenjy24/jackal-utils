package com.jonas;

import com.alibaba.fastjson.JSON;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaInfo;
import ws.schild.jave.MultimediaObject;

import java.io.File;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/12/03
 */
public class VideoUtils {

    public static void main(String[] args) {
        String fileName = "/Users/shenjy/Documents/resource/video/video.mp4";
        File file = new File(fileName);
        //文件大小 bytes
        System.out.println(file.length());
//        Encoder encoder = new Encoder();
        try {
            MultimediaObject multimediaObject = new MultimediaObject(file, new MyFFMPEGLocator());
            MultimediaInfo info = multimediaObject.getInfo();
            System.out.println(JSON.toJSONString(info));
        } catch (EncoderException e) {
            e.printStackTrace();
        }
    }
}
