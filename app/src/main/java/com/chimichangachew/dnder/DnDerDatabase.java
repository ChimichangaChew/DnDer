package com.chimichangachew.dnder;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Profile.class}, version = 1)
public abstract class DnDerDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "study2.db";

    private static DnDerDatabase mDnDerDatabase;

    // Singleton
    public static DnDerDatabase getInstance(Context context) {
        if (mDnDerDatabase == null) {
            mDnDerDatabase = Room.databaseBuilder(context, DnDerDatabase.class,
                    DATABASE_NAME).allowMainThreadQueries().build();
        }
        return mDnDerDatabase;
    }

    public abstract ProfileDao ProfileDao();
}
