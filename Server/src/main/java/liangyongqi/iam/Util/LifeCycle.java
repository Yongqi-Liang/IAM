package liangyongqi.iam.Util;

import liangyongqi.iam.IamApplication;
import org.springframework.boot.SpringApplication;

public class LifeCycle {
    public static void start() {
        LogTool.LifeCycleLog("start");
        BackendAudio.ErrorAlert();
    }

    public static void stop() {
        LogTool.LifeCycleLog("stop");
        BackendAudio.ErrorAlert();
    }
}