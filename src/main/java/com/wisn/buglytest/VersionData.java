package com.wisn.buglytest;

import java.util.List;

public class VersionData {
    List<Data> data;

    public static class Data {
        public Double version;
        public long value;


        @Override
        public String toString() {
            return "Data{" +
                    "version=" + version +
                    ", value=" + value +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VersionData{" +
                "data=" + data +
                '}';
    }
}
