package me.farhanarnob.widgetview;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 * for widget learning
 */

public class WidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        int realAppWidgetIds[] = AppWidgetManager.getInstance(context).getAppWidgetIds(
                new ComponentName(context, WidgetProvider.class));

        for (int id : realAppWidgetIds) {
            RemoteViews remoteView = new RemoteViews(context.getPackageName(), R.layout.widget);

            Intent serviceIntent = new Intent(context, WidgetService.class);
            remoteView.setRemoteAdapter(R.id.widget_list_view, serviceIntent);

            int r = (int) (Math.random() * 0xff);
            int g = (int) (Math.random() * 0xff);
            int b = (int) (Math.random() * 0xff);
            int color = (0xff << 24) + (r << 16) + (g << 8) + b;

            remoteView.setInt(R.id.frame_layout, "setBackgroundColor", color);

            Intent intent = new Intent(context, WidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, realAppWidgetIds);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    context,
                    0,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT
            );

            remoteView.setOnClickPendingIntent(R.id.frame_layout, pendingIntent);
            appWidgetManager.updateAppWidget(id, remoteView);
        }
    }
}
