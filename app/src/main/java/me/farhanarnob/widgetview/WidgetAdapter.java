package me.farhanarnob.widgetview;

import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import static me.farhanarnob.widgetview.WidgetProvider.KEY_ITEM;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class WidgetAdapter implements RemoteViewsService.RemoteViewsFactory {
    String[] list = {"Treehouse", "Android", "Java", "Kotlin", "Anko"};
    Context mContext;

    public WidgetAdapter(Context context) {
        mContext = context;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public RemoteViews getViewAt(int i) {
        RemoteViews remoteViews = new RemoteViews(mContext.getPackageName(), R.layout.list_item);
        remoteViews.setTextViewText(R.id.textView, list[i]);
        Intent newIntent = new Intent();
        newIntent.putExtra(KEY_ITEM, list[i]);
        remoteViews.setOnClickFillInIntent(R.id.child_list_item, newIntent);
        return remoteViews;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
}
