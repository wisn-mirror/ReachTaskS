package com.wisn.buglytest;


import com.wisn.tools.TextUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lxs on 2016/12/2.
 */
public class AppHomePageBean implements Serializable   {
    public static final String AD_BANNER = "ad_banner";
    public static final String AD_HEADER = "ad_header";
    public static final String AD_CHANNEL = "ad_channel";
    public static final String AD_MALL = "mall_ad_code";
    public static final String SLIDER = "slider";
    public static final String H5_MULTIPIC = "h5_multipic";
    public static final String SECONDKILL = "secondKill";
    public static final String AD_ENTRANCE = "ad_entrance";
    public static final String RANK = "rank";
    public static final String GOODS = "goods";
    public static final String NEWS = "news";
    public static final String SLIDESHOW = "slideShow";
    public static final String AD_CATEGORY = "ad_category";
    public static final String SPACING = "spacing";
    public static final String PRODUCT = "product";
    public static final String INDEX_CUBE = "index_cube";
    public static final String CHANNEL = "channel";
    public static final String GOODS_R1C3 = "goods-r1c3";
    public static final String IMAGE_TEXT = "img_text";
    public boolean hasHead = true;
    public String headUrl = "http://wap.baidu.com";
    public List<HomeData> dataList;
    public PageInfo pageInfo;

    public boolean ifCache; //是否读取缓存数据

    public static class HomeData implements  Serializable {

        public static final int TYPE_HEAD = 1000;
        public static final int TYPE_CHANNEL = 1001;
        public static final int TYPE_ENTRANCE = 1002;
        public static final int TYPE_NEWS = 1003;
        public static final int TYPE_SECKILL = 1004;
        public static final int TYPE_H5 = 1005;
        public static final int TYPE_PAVILION = 1006;
        public static final int TYPE_RANK = 1007;
        public static final int TYPE_CATEGORY = 1008;
        public static final int TYPE_PRODUCT = 1009;
        public static final int TYPE_SLIDER = 1010;
        public static final int TYPE_SPACE = 1011;
        public static final int TYPE_GOODS = 1012;
        public static final int TYPE_MF = 1013;
        public static final int TYPE_CN = 1014;
        public static final int TYPE_SPEC_GOODS = 1015;
        public static final int TYPE_IMAGE_TEXT = 1016;

        public int dataType;
        public StaticData staticData;
        public String templateCode;
        public long moduleId;

        public ModuleData moduleData;

        public int itemType = TYPE_HEAD;

        public int getDataType() {
            return dataType;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public StaticData getStaticData() {
            return staticData;
        }

        public void setStaticData(StaticData staticData) {
            this.staticData = staticData;
        }

        public String getTemplateCode() {
            return templateCode;
        }

        public void setTemplateCode(String templateCode) {
            this.templateCode = templateCode;
        }

        public long getModuleId() {
            return moduleId;
        }

        public void setModuleId(long moduleId) {
            this.moduleId = moduleId;
        }

        public ModuleData getModuleData() {
            return moduleData;
        }

        public void setModuleData(ModuleData moduleData) {
            this.moduleData = moduleData;
        }

        public void setItemType(int itemType) {
            this.itemType = itemType;
        }

      

       
    }

    public static class StaticData implements  Serializable {

        public List<ImageText> artileLists;
        //秒杀
        public String image1;
        public String subTitle1;
        public Link link1;
        public String url1;

        public String image2;
        public String subTitle2;
        public Link link2;
        public String url2;

        public String image3;
        public String subTitle3;
        public Link link3;
        public String url3;

        public String image4;
        public String subTitle4;
        public Link link4;
        public String url4;

        //空白模板
        public String color;
        public double height;

        //多图间距
        public double margin;

        //小轮播图或者悬浮按钮
        public List<Image> images;

        //排行榜
        public String type;

        //特色主题馆
        public List<Item> items;

        public double imgWidth = 0;              //占屏幕宽度
        public double aspectRatio = 0;

        //商品
        public int displayNav;
        public int displayNum;
        public int displayBuyBtn;
        public int goodsTotal;

        //dataType
        public String ad_code;

        public String pageCode;
        //正常广告接口填充数据
//        public List<Ad> adList;
        //头条
//        public HeadLinesBean headLinesBean;


        public Link link;
//        public ModuleDataBean resultBean;

        public String layout;
        public CData cdata;

        public List<Tabs> tabs;


        public List<Channels> channels;


        public StyleObject styleObject;

        public double moduleHeight;
        public double moduleWidth;


        public static class StyleObject implements  Serializable {
            public String position;
            public String height;
            public String width;
            public String left;
            public String zindex;
            public String top;

           
        }


        public static class Tabs implements  Serializable {
            public String title;
            public Link link;
            public List<Object> modules;
 
        }

        public static class Channels implements  Serializable {
            public String text;
            public String src;
            public String url;
            public Link link;

            
        }
 
    }


    public static class AdData     {
        public String title;
        public String subTitle;
        public String url;
        public String image;

         
    }

    public static class SecondKill    {
        public List<AdData> imgList;

         
    }

    public static class ImageMap  {
        public String customName;
        public List<CreateMap> map_create;
        public String imgSrc;

       
    }

    public static class CreateMap {
        public String coord;
        public String name;
        public String type;
        public String recLink;

        
    }


    public static class H5Mult  {
        public String imgType;
        public double marginTop;
        public String customName;
        public double marginRight;
        public List<H5Image> imgList;
 
    }

    public static class H5Image     {
        public String desc;
        public String src;

       
    }

    public static class Image implements  Serializable {
        public String desc;
        public Link link;
        public String src;
        public double oriHeight;
        public double oriWidth;

       
    }

    public static class Item implements  Serializable {

        public String imgUrl;
        public Link link;
        public String name;

        
    }


    public static class ModuleData implements  Serializable {

 
    }


    public static class Link implements  Serializable {
        public boolean status;
        public String data;
        public String type;
        public String appData;
        public String appUrl;

         
    }

    public static class PageInfo implements  Serializable {
        public String bgImg;
        public String bgColor;

        public String id;

        public String pageCode;

        public String name;

        public String displayTitle;

        public int pageVer;

        public Long startDate;

        public Long endDate;

        public Long createTime;

        public String shareTitle;

        public String shareImg;

        public String shareDesc;

        public String previewUrl;

       
    }

    public static class CData implements  Serializable {
        public String width;
        public String appLayout;
        public List<Children> children;

       
    }

    public static class Children implements  Serializable {
        public String width;
        public Link link;
        public String imgUrl;
        public double appWidth;
        public double appHeight;
        //        @SerializedName("float")
        private String cssFloat;
        public List<Children> children;

        public int purchase;
        //下一场开始的时间
        public String startTime;
        //倒计时的时间
        public String countTime;

       
    }

    public static class ImageText implements  Serializable {
        public int showPageView;
        public int oriHeight;
        public String title;
        public String pageView;
        public String desc;
        public int check;
        public String thumbsUp;
        public Link link;
        public String src;
        public String url;
        public int oriWidth;
        private String pageId;

        public String getPageId() {
            if (TextUtils.isEmpty(url) || "empty".equals(pageId)) {
                return null;
            }
            if (!"empty".equals(pageId) && !TextUtils.isEmpty(pageId)) return pageId;
            int start = url.lastIndexOf("/") + 1;
            int end = url.lastIndexOf(".");
            if (end > start && url.length() > start && url.length() >= end) {
                pageId = url.substring(start, end);
                return pageId;
            } else {
                pageId = "empty";
                return null;
            }
        }
 
    }
 
}
