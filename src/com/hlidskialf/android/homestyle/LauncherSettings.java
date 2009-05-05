package com.hlidskialf.android.homestyle;

import android.provider.BaseColumns;
import android.net.Uri;

public class LauncherSettings
{
  static final String AUTHORITY = "com.android.launcher.settings";
  static final String TABLE_FAVORITES = "favorites";
  static final String PARAMETER_NOTIFY = "notify";

  static final class Favorites implements BaseColumns {
        /**
         * The content:// style URL for this table
         */
        static final Uri CONTENT_URI = Uri.parse("content://" +
                LauncherSettings.AUTHORITY + "/" + LauncherSettings.TABLE_FAVORITES +
                "?" + LauncherSettings.PARAMETER_NOTIFY + "=true");

        /**
         * The content:// style URL for this table. When this Uri is used, no notification is
         * sent if the content changes.
         */
        static final Uri CONTENT_URI_NO_NOTIFICATION = Uri.parse("content://" +
                LauncherSettings.AUTHORITY + "/" + LauncherSettings.TABLE_FAVORITES +
                "?" + LauncherSettings.PARAMETER_NOTIFY + "=false");

        /**
         * The content:// style URL for a given row, identified by its id.
         *
         * @param id The row id.
         * @param notify True to send a notification is the content changes.
         *
         * @return The unique content URL for the specified row.
         */
        static Uri getContentUri(long id, boolean notify) {
            return Uri.parse("content://" + LauncherSettings.AUTHORITY +
                    "/" + LauncherSettings.TABLE_FAVORITES + "/" + id + "?" +
                    LauncherSettings.PARAMETER_NOTIFY + "=" + notify);
        }

        static final String ID = "_id";
        static final String TITLE = "title";
        static final String INTENT = "intent";
        static final String CONTAINER = "container";
        static final int CONTAINER_DESKTOP = -100;
        static final String SCREEN = "screen";
        static final String CELLX = "cellX";
        static final String CELLY = "cellY";
        static final String SPANX = "spanX";
        static final String SPANY = "spanY";
        static final String ITEM_TYPE = "itemType";
        static final int ITEM_TYPE_APPLICATION = 0;
        static final int ITEM_TYPE_SHORTCUT = 1;
        static final int ITEM_TYPE_USER_FOLDER = 2;
        static final int ITEM_TYPE_LIVE_FOLDER = 3;
        static final int ITEM_TYPE_APPWIDGET = 4;
        static final int ITEM_TYPE_WIDGET_CLOCK = 1000;
        static final int ITEM_TYPE_WIDGET_SEARCH = 1001;
        static final int ITEM_TYPE_WIDGET_PHOTO_FRAME = 1002;
        static final String APPWIDGET_ID = "appWidgetId";
        static final String IS_SHORTCUT = "isShortcut";
        static final String ICON_TYPE = "iconType";
        static final int ICON_TYPE_RESOURCE = 0;
        static final int ICON_TYPE_BITMAP = 1;
        static final String ICON_PACKAGE = "iconPackage";
        static final String ICON_RESOURCE = "iconResource";
        static final String ICON = "icon";
        static final String URI = "uri";
        static final String DISPLAY_MODE = "displayMode";
  }
};
