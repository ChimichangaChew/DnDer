package com.chimichangachew.dnder;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM profiles WHERE uid LIKE :uid")
    Profile getProfileId(long uid);

    @Query("SELECT * FROM profiles WHERE username LIKE :username")
    Profile getProfileName(String username);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertProfile(Profile profile);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProfiles(List<Profile> profileList);

    @Update
    void updateProfile(Profile profile);

    @Delete
    void deleteProfile(Profile profile);
}