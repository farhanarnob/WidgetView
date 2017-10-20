package me.farhanarnob.widgetview;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.widget.RemoteViews;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 * for widget learning
 */

public class WidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int id : appWidgetIds) {
            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget);
            appWidgetManager.updateAppWidget(id, remoteView);
        }
    }
}
