package com.hlidskialf.android.homestyle;

import android.content.ContentResolver;
import android.database.Cursor;
import android.content.Intent;
import android.net.Uri;
import java.lang.StringBuilder;

public class Homestyle
{

  public static class Favorite {
    public String title = null;
    public String shortcutString;
    public String uriString;
    public int itemType = -1;
    public int container;
    public int screen;
    public int cellX,cellY;
    public int spanX,spanY;
    public Intent shortcut = null;
    public Uri uri = null;

    public Favorite() {}
    public Favorite(Cursor c) { initFromCursor(c); }

    public void initFromCursor(Cursor c) {
      int idx_item_type = c.getColumnIndexOrThrow(LauncherSettings.Favorites.ITEM_TYPE);
      int idx_title = c.getColumnIndexOrThrow(LauncherSettings.Favorites.TITLE);
      int idx_intent = c.getColumnIndexOrThrow(LauncherSettings.Favorites.INTENT);
      int idx_container = c.getColumnIndexOrThrow(LauncherSettings.Favorites.CONTAINER);
      int idx_screen = c.getColumnIndexOrThrow(LauncherSettings.Favorites.SCREEN);
      int idx_cellx = c.getColumnIndexOrThrow(LauncherSettings.Favorites.CELLX);
      int idx_celly = c.getColumnIndexOrThrow(LauncherSettings.Favorites.CELLY);
      int idx_spanx = c.getColumnIndexOrThrow(LauncherSettings.Favorites.SPANX);
      int idx_spany = c.getColumnIndexOrThrow(LauncherSettings.Favorites.SPANY);
      int idx_uri = c.getColumnIndexOrThrow(LauncherSettings.Favorites.URI);

      shortcutString = c.getString(idx_intent);
      if (shortcutString != null) {
        try {
          shortcut = Intent.getIntent(shortcutString);
        } catch (java.net.URISyntaxException ex) { }
      }

      title = c.getString(idx_title);
      itemType = c.getInt(idx_item_type);
      container = c.getInt(idx_container);
      screen = c.getInt(idx_screen);
      cellX = c.getInt(idx_cellx);
      cellY = c.getInt(idx_celly);
      spanX = c.getInt(idx_spanx);
      spanY = c.getInt(idx_spany);
      uriString = c.getString(idx_uri);
      if (uriString != null)
        uri = Uri.parse(uriString);
    }
    public String toXml()
    {
      if (itemType == -1) return null;
      StringBuilder sb = new StringBuilder();

      if (itemType == LauncherSettings.Favorites.ITEM_TYPE_APPLICATION) {
        sb.append("<application\n");
        if (title != null)
          sb.append("  homestyle:title=\"").append(title).append("\"\n");
        if (shortcutString != null)
          sb.append("  homestyle:shortcut=\"").append(shortcutString).append("\"\n");
        if (uri != null)
          sb.append("  homestyle:uri=\"").append(uri.toString()).append("\"\n");
        sb.append("  homestyle:container=\"").append(String.valueOf(container)).append("\"\n");
        sb.append("  homestyle:screen=\"").append(String.valueOf(screen)).append("\"\n");
        sb.append("  homestyle:cellX=\"").append(String.valueOf(cellX)).append("\"\n");
        sb.append("  homestyle:cellY=\"").append(String.valueOf(cellY)).append("\"\n");
        sb.append("  homestyle:spanX=\"").append(String.valueOf(spanX)).append("\"\n");
        sb.append("  homestyle:spanY=\"").append(String.valueOf(spanY)).append("\"\n");
        sb.append("/>");
      }
      return sb.toString();
    }
  }
  public static Cursor queryAllFavorites(ContentResolver resolver)
  {
    Cursor c = resolver.query(LauncherSettings.Favorites.CONTENT_URI, 
      new String[] {
        LauncherSettings.Favorites.ID,
        LauncherSettings.Favorites.TITLE,
        LauncherSettings.Favorites.INTENT,
        LauncherSettings.Favorites.ITEM_TYPE,
        LauncherSettings.Favorites.CONTAINER,
        LauncherSettings.Favorites.SCREEN,
        LauncherSettings.Favorites.CELLX,
        LauncherSettings.Favorites.CELLY,
        LauncherSettings.Favorites.SPANX,
        LauncherSettings.Favorites.SPANY,
        LauncherSettings.Favorites.URI
      }, null, null, null);
    return c;
  }
}
