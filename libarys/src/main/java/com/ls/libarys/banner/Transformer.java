package com.ls.libarys.banner;

import android.support.v4.view.ViewPager.PageTransformer;

import com.ls.libarys.viewpagertransforms.AccordionTransformer;
import com.ls.libarys.viewpagertransforms.BackgroundToForegroundTransformer;
import com.ls.libarys.viewpagertransforms.CubeInTransformer;
import com.ls.libarys.viewpagertransforms.CubeOutTransformer;
import com.ls.libarys.viewpagertransforms.DefaultTransformer;
import com.ls.libarys.viewpagertransforms.DepthPageTransformer;
import com.ls.libarys.viewpagertransforms.DrawerTransformer;
import com.ls.libarys.viewpagertransforms.FlipHorizontalTransformer;
import com.ls.libarys.viewpagertransforms.FlipVerticalTransformer;
import com.ls.libarys.viewpagertransforms.ForegroundToBackgroundTransformer;
import com.ls.libarys.viewpagertransforms.RotateDownTransformer;
import com.ls.libarys.viewpagertransforms.RotateUpTransformer;
import com.ls.libarys.viewpagertransforms.ScaleInOutTransformer;
import com.ls.libarys.viewpagertransforms.StackTransformer;
import com.ls.libarys.viewpagertransforms.TabletTransformer;
import com.ls.libarys.viewpagertransforms.ZoomInTransformer;
import com.ls.libarys.viewpagertransforms.ZoomOutSlideTransformer;
import com.ls.libarys.viewpagertransforms.ZoomOutTranformer;


public class Transformer {
    public static Class<? extends PageTransformer> Default = DefaultTransformer.class;
    public static Class<? extends PageTransformer> Accordion = AccordionTransformer.class;
    public static Class<? extends PageTransformer> BackgroundToForeground = BackgroundToForegroundTransformer.class;
    public static Class<? extends PageTransformer> ForegroundToBackground = ForegroundToBackgroundTransformer.class;
    public static Class<? extends PageTransformer> CubeIn = CubeInTransformer.class;
    public static Class<? extends PageTransformer> CubeOut = CubeOutTransformer.class;
    public static Class<? extends PageTransformer> DepthPage = DepthPageTransformer.class;
    public static Class<? extends PageTransformer> FlipHorizontal = FlipHorizontalTransformer.class;
    public static Class<? extends PageTransformer> FlipVertical = FlipVerticalTransformer.class;
    public static Class<? extends PageTransformer> RotateDown = RotateDownTransformer.class;
    public static Class<? extends PageTransformer> RotateUp = RotateUpTransformer.class;
    public static Class<? extends PageTransformer> ScaleInOut = ScaleInOutTransformer.class;
    public static Class<? extends PageTransformer> Stack = StackTransformer.class;
    public static Class<? extends PageTransformer> Tablet = TabletTransformer.class;
    public static Class<? extends PageTransformer> ZoomIn = ZoomInTransformer.class;
    public static Class<? extends PageTransformer> ZoomOut = ZoomOutTranformer.class;
    public static Class<? extends PageTransformer> ZoomOutSlide = ZoomOutSlideTransformer.class;
    public static Class<? extends PageTransformer> Drawer = DrawerTransformer.class;
}
