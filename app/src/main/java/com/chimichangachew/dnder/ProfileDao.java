package com.chimichangachew.dnder;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM Profiles WHERE uid LIKE :uid")
    public Profile getProfile(long uid);

    @Query("SELECT * FROM Profiles WHERE username LIKE :username")
    public Profile getProfiles(String username);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertProfile(Profile profile);

    @Update
    public void updateProfile(Profile profile);

    @Delete
    public void deleteProfile(Profile profile);
}