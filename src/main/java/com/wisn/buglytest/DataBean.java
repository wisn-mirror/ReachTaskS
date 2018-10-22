package com.wisn.buglytest;

import java.util.List;

public class DataBean {

    public int status;
    public String msg;
    public RetBean ret;

    public static class RetBean {
        /**
         * data : [{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180923","type":"crash","crashNum":389,"crashUser":279,"accessNum":1946350,"accessUser":34242},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180924","type":"crash","crashNum":385,"crashUser":253,"accessNum":1953749,"accessUser":33373},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180925","type":"crash","crashNum":365,"crashUser":249,"accessNum":2008956,"accessUser":32391},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180926","type":"crash","crashNum":426,"crashUser":262,"accessNum":2182443,"accessUser":32992},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180927","type":"crash","crashNum":450,"crashUser":287,"accessNum":2116909,"accessUser":32967},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180928","type":"crash","crashNum":395,"crashUser":289,"accessNum":2084095,"accessUser":32990},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180929","type":"crash","crashNum":333,"crashUser":259,"accessNum":2063910,"accessUser":32755},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20180930","type":"crash","crashNum":443,"crashUser":290,"accessNum":1986572,"accessUser":32661},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20181001","type":"crash","crashNum":383,"crashUser":292,"accessNum":1892563,"accessUser":32499},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20181002","type":"crash","crashNum":327,"crashUser":256,"accessNum":1765669,"accessUser":30462},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20181003","type":"crash","crashNum":345,"crashUser":268,"accessNum":1712746,"accessUser":29450},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20181004","type":"crash","crashNum":365,"crashUser":221,"accessNum":1735771,"accessUser":29190},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20181005","type":"crash","crashNum":242,"crashUser":196,"accessNum":1770835,"accessUser":29520},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20181006","type":"crash","crashNum":300,"crashUser":243,"accessNum":1760833,"accessUser":29523},{"appId":"834971cd4b","platformId":1,"version":"-1","date":"20181007","type":"crash","crashNum":372,"crashUser":259,"accessNum":1784141,"accessUser":29599}]
         * code : 200
         */

        public int code;
        public List<Data1Bean> data;

        public static class Data1Bean {
            /**
             * appId : 834971cd4b
             * platformId : 1
             * version : -1
             * date : 20180923
             * type : crash
             * crashNum : 389
             * crashUser : 279
             * accessNum : 1946350
             * accessUser : 34242
             */

            public String appId;
            public int platformId;
            public String version;
            public String date;
            public String type;
            public double crashNum;
            public double crashUser;
            public double accessNum;
            public double accessUser;
        }
    }
}
