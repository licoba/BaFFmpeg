package com.licoba.baffmpeg;


import android.widget.TextView;

public class FFMediaPlayer {
    static {
        System.loadLibrary("baffmpeg");
    }

    public static String GetFFmpegVersion() {
        return native_ffmpegInfo();
    }

    private static native String native_ffmpegInfo();
}
