package com.ls.kylibary.vlayout;

import java.util.ArrayList;
import java.util.List;

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

public class Common {

    private String code;
    private String msg;
    private List<IconEntity>icon;
    private List<IconEntity>shop;
    private List<IconEntity>news;

    public List<IconEntity> getNews() {
        if (news == null) {
            return new ArrayList<>();
        }
        return news;
    }

    public void setNews(List<IconEntity> news) {
        this.news = news;
    }

    public List<IconEntity> getIcon() {
        if (icon == null) {
            return new ArrayList<>();
        }
        return icon;
    }

    public void setIcon(List<IconEntity> icon) {
        this.icon = icon;
    }

    public List<IconEntity> getShop() {
        if (shop == null) {
            return new ArrayList<>();
        }
        return shop;
    }

    public void setShop(List<IconEntity> shop) {
        this.shop = shop;
    }

    public String getCode() {
        return code == null ? "" : code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<IconEntity> getIcom() {
        if (icon == null) {
            return new ArrayList<>();
        }
        return icon;
    }

    public void setIcom(List<IconEntity> icon) {
        this.icon = icon;
    }

}
