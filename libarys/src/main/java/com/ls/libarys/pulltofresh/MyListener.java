package com.ls.libarys.pulltofresh;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.ls.libarys.pulltofresh.PullToRefreshLayout.OnRefreshListener;

/**
* @ClassName: MyListener  
* @Description: 下拉刷新listener
*   
 */
public class MyListener implements OnRefreshListener
{
//	private ProtbzBiz pb=new ProtbzBiz();

	@Override
	public void onRefresh(final PullToRefreshLayout pullToRefreshLayout)
	{
		// 下拉刷新操作
		new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				// 千万别忘了告诉控件刷新完毕了哦！
				pullToRefreshLayout.refreshFinish(PullToRefreshLayout.SUCCEED);
				Log.i("刷新完毕", "刷新成功喽！");
			}
		}.sendEmptyMessageDelayed(0, 2000);
	}

	@Override
	public void onLoadMore(final PullToRefreshLayout pullToRefreshLayout)
	{
		// 加载操作
		new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				// 千万别忘了告诉控件加载完毕了哦！
				pullToRefreshLayout.loadmoreFinish(PullToRefreshLayout.SUCCEED);
				Log.i("加载完毕", "加载成功喽！");
//				pb=new ProtbzBiz();
//				pb.loadMorePro();
//				pb.loadAllPro();
			}
		}.sendEmptyMessageDelayed(0, 2000);
	}

}
