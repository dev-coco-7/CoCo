package com.bat.studio.model;

public class AD {

    public int code;
    public String message;
    public long timestamp;
    public ADInfo data;


    public static class ADInfo {
        public String shortImgPath;
        public String bindUrl;

        public String getShortImgPath() {
            return shortImgPath;
        }

        public void setShortImgPath(String shortImgPath) {
            this.shortImgPath = shortImgPath;
        }

        public String getBindUrl() {
            return bindUrl;
        }

        public void setBindUrl(String bindUrl) {
            this.bindUrl = bindUrl;
        }
    }
}
