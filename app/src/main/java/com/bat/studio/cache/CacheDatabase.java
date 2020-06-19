package com.bat.studio.cache;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.bat.studio.base.BaseApplication;


@Database(entities = {Cache.class}, version = 1, exportSchema = false)
public abstract class CacheDatabase extends RoomDatabase {
    private static final CacheDatabase database;

    static {
        database = Room.databaseBuilder(BaseApplication.getApplication(), CacheDatabase.class, "qihaodev_cache")
                .allowMainThreadQueries()
                .build();
    }

    public abstract CacheDao getDao();

    public static CacheDatabase get() {
        return database;
    }
}
