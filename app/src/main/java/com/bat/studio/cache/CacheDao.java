package com.bat.studio.cache;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CacheDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long save(Cache cache);

    @Delete
    int delete(Cache cache);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    int update(Cache cache);

    @Query("select *from cache where `key`=:key")
    Cache getCache(String key);
}
