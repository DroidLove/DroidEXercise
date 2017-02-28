package com.ex.droidlist;

/**
 * Created by Jitesh on 13/4/16.
 */
public class Constants {

    public interface ACTION {
        public static String MAIN_ACTION = "com.ex.droidlist.action.main";
        public static String INIT_ACTION = "com.ex.droidlist.action.init";
        public static String PREV_ACTION = "com.ex.droidlist.action.prev";
        public static String PLAY_ACTION = "com.ex.droidlist.action.play";
        public static String NEXT_ACTION = "com.ex.droidlist.action.next";
        public static String STARTFOREGROUND_ACTION = "com.ex.droidlist.action.startforeground";
        public static String STOPFOREGROUND_ACTION = "com.ex.droidlist.action.stopforeground";
    }

    public interface NOTIFICATION_ID {
        public static int FOREGROUND_SERVICE = 101;
    }
}