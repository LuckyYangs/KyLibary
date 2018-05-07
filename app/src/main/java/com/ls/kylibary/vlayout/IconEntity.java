package com.ls.kylibary.vlayout;

/**
 * /~~~~~\        /~~~~~\
 * |    (~'        ~~~)   |
 * \    \__________/    /
 * /~::::::::         ~\
 * /~~~~~~~-_| ::::::::             |_-~~~~~~~\
 * \ ======= /|  ::A::;      A     :|\ ====== /
 * ~-_____-~ |  _----------------_::| ~-____-~
 * |/~                  ~\|
 * /                      \
 * (        ()    ()        )
 * `\                   ./'
 * ~-_______________-~
 * /~~~~\
 * |      |
 * |      |
 * (________)
 * ()
 * -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）        |
 * -----------------------------------------------
 * | 时  间：| 2018/5/7                             |
 * -----------------------------------------------
 * | 包  名：| com.ls.kylibary.vlayout                     |
 * -----------------------------------------------
 * | 类  名：| $class$                             |
 * -----------------------------------------------
 * | 简  述: | <功能简述>                          |
 * -----------------------------------------------
 */

public class IconEntity {


    /**
     * title : 工具类
     * imageUrl : http://www.iconpng.com/png/winter_lollipop/phone.png
     */

    private String title;
    private String imageUrl;

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl == null ? "" : imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
