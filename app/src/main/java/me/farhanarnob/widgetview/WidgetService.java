package me.farhanarnob.widgetview;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by ${farhanarnob} on ${06-Oct-16}.
 */

public class WidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new WidgetAdapter(this);
    }
}
