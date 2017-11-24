package io.github.heartinfei.slogger;

/**
 * 简介：配置信息
 *
 * @author 王强 on 2017/11/23 249346528@qq.com
 */
public class Configuration {
    private static final int DEFAULT_DEEP = Integer.MAX_VALUE;
    /**
     * 默认Tag
     */
    private String tag = "";
    /**
     * 堆栈深度
     */
    private int trackInfoDeep = DEFAULT_DEEP;

    /**
     * true 打印Tag
     */
    private boolean isPrintTag = true;

    /**
     * true 打印堆栈信息
     */
    private boolean isPrintTrackInfo = true;

    /**
     * true 打印行号
     */
    private boolean isPrintLineNo = true;

    /**
     * true 打印线程信息
     */
    private boolean showThreadInfo = true;

    private String pkgName;

    public Configuration(Builder builder) {
        this.tag = builder.tag;
        this.trackInfoDeep = builder.trackInfoDeep;
        this.isPrintTag = builder.isPrintTag;
        this.isPrintTrackInfo = builder.isPrintTrackInfo;
        this.isPrintLineNo = builder.isPrintLineNo;
        this.showThreadInfo = builder.showThreadInfo;
        this.pkgName = builder.pkgName;
    }

    public String getPkgName() {
        return pkgName;
    }

    public String getTag() {
        return isPrintTag ? tag : "";
    }

    public boolean isShowThreadInfo() {
        return showThreadInfo;
    }

    public void setShowThreadInfo(boolean showThreadInfo) {
        this.showThreadInfo = showThreadInfo;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTrackInfoDeep() {
        return trackInfoDeep;
    }

    public void setTrackInfoDeep(int trackInfoDeep) {
        this.trackInfoDeep = trackInfoDeep;
    }

    public boolean isPrintTag() {
        return isPrintTag;
    }

    public void setPrintTag(boolean printTag) {
        isPrintTag = printTag;
    }

    public boolean isPrintLineNo() {
        return isPrintLineNo;
    }

    public void setPrintLineNo(boolean printLineNo) {
        isPrintLineNo = printLineNo;
    }

    public boolean isPrintTrackInfo() {
        return isPrintTrackInfo;
    }

    public void setPrintTrackInfo(boolean printTrackInfo) {
        isPrintTrackInfo = printTrackInfo;
    }

    public static final class Builder {
        private String tag;
        private int trackInfoDeep = DEFAULT_DEEP;
        private boolean isPrintTrackInfo = false;
        private boolean isPrintTag = true;
        private boolean isPrintLineNo = true;
        private boolean showThreadInfo = true;
        private final String pkgName;

        public Builder(Class<?> cls) {
            this.tag = cls.getSimpleName();
            this.pkgName = cls.getPackage().getName();
        }

        public Builder(Class<?> cls,String tag) {
            this.pkgName = cls.getPackage().getName();
            this.tag = tag;
        }

        public Builder tag(String val) {
            tag = val;
            return this;
        }

        public Builder isPrintTrackInfo(boolean val) {
            this.isPrintTrackInfo = val;
            return this;
        }

        public Builder trackInfoDeep(int deep) {
            trackInfoDeep = deep;
            return this;
        }

        public Builder isPrintTag(boolean val) {
            isPrintTag = val;
            return this;
        }

        public Builder isPrintLineNo(boolean val) {
            isPrintLineNo = val;
            return this;
        }

        public Builder isShowThreadInfo(boolean show) {
            this.showThreadInfo = show;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }
}