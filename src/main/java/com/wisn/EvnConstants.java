package com.wisn;

/**
 * Created by Wisn on 2018/9/27 上午10:43.
 */
public class EvnConstants {

    public static String _edu = "edu环境";
    public static String _test = "test环境";
    public static String _stg = "stg环境";
    public static String _release = "线上";

    /**
     * 切换指定的环境
     *
     * @param evn
     */
    public static void updateEvn(String evn) {
        CurrentEvn currentEvn = null;
        if (_edu.equals(evn)) {
            currentEvn = new edu();
        } else if (_test.equals(evn)) {
            currentEvn = new test();
        } else if (_stg.equals(evn)) {
            currentEvn = new stg();
        } else if (_release.equals(evn)) {
            currentEvn = new release();
        }
        currentEvn.updateEvn();
    }

    /**
     * 运行中的环境
     */
    public static abstract class CurrentEvn {
        public static String BASEURL = "http://api.laiyifen.com";
        public static String H5URL = "http://m.laiyifen.com";
        public static String IMUrl = "http://api.laiyifen.com";
        public static String BUGLYID = "516e65f343";
        public static String xiaomiAppid = "2882303761517502883";
        public static String xiaomiAppkey = "5671750254883";
        public static String im_appKey = "9d2723f5e643cf0333e900f18c6e05a9";
        public static String im_appSecret = "b8ab95a431cf";

        abstract void updateEvn();
    }

    private static class test extends CurrentEvn {
        @Override
        void updateEvn() {
            BASEURL = "http://api.test.laiyifen.com";
            H5URL = "http://m.test.laiyifen.com";
            IMUrl = "http://api.test.laiyifen.com";
            BUGLYID = "96788bed2905";
            xiaomiAppid = "2882303761517502883";
            xiaomiAppkey = "5671750254883";
            im_appKey = "9d2723f5e643cf0333e900f18c6e05a9";
            im_appSecret = "b8ab95a431cf";
        }
    }

    private static class edu extends CurrentEvn {
        @Override
        void updateEvn() {
            BASEURL = "http://api.lyf.edu.laiyifen.com";
            H5URL = "http://m.lyf.edu.laiyifen.com";
            IMUrl = "http://m.lyf.dev.laiyifen.com";
            BUGLYID = "96788bed2905";
            xiaomiAppid = "2882303761517502883";
            xiaomiAppkey = "5671750254883";
            im_appKey = "c27ff274a5ed7acf4948fb550eb08e93";
            im_appSecret = "96788bed2905";
        }
    }

    private static class stg extends CurrentEvn {
        @Override
        void updateEvn() {
            BASEURL = "http://api.stg.laiyifen.com";
            H5URL = "http://m.stg.laiyifen.com";
            IMUrl = "http://api.stg.laiyifen.com";
            BUGLYID = "96788bed2905";
            xiaomiAppid = "2882303761517502883";
            xiaomiAppkey = "5671750254883";
            im_appKey = "9d2723f5e643cf0333e900f18c6e05a9";
            im_appSecret = "b8ab95a431cf";
        }


    }

    private static class release extends CurrentEvn {
        @Override
        void updateEvn() {
            BASEURL = "http://api.laiyifen.com";
            H5URL = "http://m.laiyifen.com";
            IMUrl = "http://api.laiyifen.com";
            BUGLYID = "516e65f343";
            xiaomiAppid = "2882303761517502883";
            xiaomiAppkey = "5671750254883";
            im_appKey = "9d2723f5e643cf0333e900f18c6e05a9";
            im_appSecret = "b8ab95a431cf";
        }
    }
}
