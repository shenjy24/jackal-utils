package com.jonas;

import ws.schild.jave.FFMPEGLocator;

/**
 * 【 enter the class description 】
 *
 * @author shenjy 2018/12/03
 */
public class MyFFMPEGLocator extends FFMPEGLocator {

    private static final String path = "/Users/shenjy/Documents/Tool/ffmpeg_mac";

    @Override
    protected String getFFMPEGExecutablePath() {
        return path;
    }
}
