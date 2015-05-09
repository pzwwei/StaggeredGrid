package com.etsy.android.sample;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.etsy.android.grid.StaggeredGridView;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.universalimageloader.core.DisplayImageOptions;
import com.universalimageloader.core.ImageLoader;
import com.universalimageloader.core.ImageLoaderConfiguration;
import com.universalimageloader.core.assist.QueueProcessingType;
import com.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.universalimageloader.core.download.BaseImageDownloader;

public class StaggeredGridImageActivity extends Activity {

	private StaggeredGridView mGridView;
	private GridImageAdapter mGridAdapter;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_staggeredgrid_image);

		initImageLoader(this);

		mGridView = (StaggeredGridView) findViewById(R.id.grid_view);
		mGridAdapter = new GridImageAdapter(this);

		mGridView.setAdapter(mGridAdapter);
	}

	private class GridImageAdapter extends BaseAdapter {

		private class GridImageItem {
			public String imgurl;
			public int width;
			public int height;
			public double radio;

			public GridImageItem(String url, double radio) {
				this.imgurl = url;
				this.radio = radio;

			}
		}

		private class GridImageHolder {
			public DynamicHeightImageView image;
		}

		private List<GridImageItem> mItems = new ArrayList<GridImageItem>();
		private Context mContext;
		private LayoutInflater mInflater;

		public GridImageAdapter(Context context) {

			mContext = context;
			mInflater = LayoutInflater.from(mContext);

			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/2cc9011e471311e481950dd4660b378d.jpg?imageView2/1/w/200/h/150/q/85",
					0.75));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/2cc9011e471311e481950dd4660b378d.jpg?imageView2/1/w/200/h/150/q/85",
					0.75));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/2cc9011e471311e481950dd4660b378d.jpg?imageView2/1/w/200/h/150/q/85",
					0.75));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/2cc9011e471311e481950dd4660b378d.jpg?imageView2/1/w/200/h/150/q/85",
					0.75));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/2cc9011e471311e481950dd4660b378d.jpg?imageView2/1/w/200/h/150/q/85",
					0.75));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/2cc9011e471311e481950dd4660b378d.jpg?imageView2/1/w/200/h/150/q/85",
					0.75));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/2cc9011e471311e481950dd4660b378d.jpg?imageView2/1/w/200/h/150/q/85",
					0.75));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/beabb5bd42eb11e4b7a7f39909c29e41.jpg?imageView2/1/w/200/h/200/q/85",
					1));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/ddcb096842e911e4bf057106b0520cad.jpg?imageView2/1/w/400/h/200/q/85",
					0.5));
			mItems.add(new GridImageItem(
					"http://d9chen.qiniudn.com/photowall/a416d3e14eb411e4add4fb94cca4cfcd.jpg?imageView2/1/w/200/h/350/q/85",
					1.5));
		}

		@Override
		public int getCount() {
			return mItems.size();
		}

		@Override
		public Object getItem(int position) {
			return mItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			GridImageHolder holder = null;
			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item_grid_image, null);

				holder = new GridImageHolder();

				holder.image = (DynamicHeightImageView) convertView.findViewById(R.id.dhiv_image);

				convertView.setTag(holder);
			} else {
				holder = (GridImageHolder) convertView.getTag();
			}
			GridImageItem item = mItems.get(position);

			holder.image.setHeightRatio(item.radio);
			ImageLoader.getInstance().displayImage(item.imgurl, holder.image);

			return convertView;
		}

	}

	public void initImageLoader(Context context) {
		// This configuration tuning is custom. You can tune every option, you
		// may tune some of them,
		// or you can create default configuration by
		// ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
		config.threadPriority(Thread.NORM_PRIORITY - 2);
		config.denyCacheImageMultipleSizesInMemory();
		config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
		config.diskCacheSize(16 * 1024 * 1024); // 20 MiB // sd卡 最大缓存大小
		config.tasksProcessingOrder(QueueProcessingType.LIFO);
		config.writeDebugLogs(); // Remove for release app
		// config.memoryCacheExtraOptions(720, 720); // 每个缓存文件最大长宽

		config.threadPoolSize(5); // 线程池数量
		// config.memoryCacheSize(5 * 1024 * 1024);

		// 自定义缓存路径
		String savePath = null;
		if (Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED)) {
			savePath = Environment.getExternalStorageDirectory().getAbsolutePath();
		} else {
			savePath = "/mnt/sdcard";
		}
		File folder = new File(savePath + "/molifes/caches");
		if (!folder.exists())
			folder.mkdirs();
		config.discCache(new UnlimitedDiskCache(folder));

		config.imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)); // connectTimeout(5s),
																						// readTimeout(30s)超时时间

		DisplayImageOptions UILoptions = new DisplayImageOptions.Builder().displayer(new FadeInBitmapDisplayer(400))
				.cacheInMemory(true).cacheOnDisc(true).showStubImage(R.drawable.ic_launcher).build();
		config.defaultDisplayImageOptions(UILoptions);

		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config.build());
	}
}
