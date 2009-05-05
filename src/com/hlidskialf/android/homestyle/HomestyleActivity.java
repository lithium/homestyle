package com.hlidskialf.android.homestyle;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

public class HomestyleActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      Cursor c = Homestyle.queryAllFavorites(getContentResolver());

      while (c.moveToNext()) {
        Homestyle.Favorite fav = new Homestyle.Favorite(c);
        android.util.Log.v("homestyle", fav.toXml());
      }
      c.close();
    }
}
