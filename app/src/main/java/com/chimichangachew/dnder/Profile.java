package com.chimichangachew.dnder;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Profiles")
public class Profile {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private long mUid;

    @ColumnInfo(name = "username")
    private String mUsername;

    @ColumnInfo(name = "age")
    private String mAge;

    @ColumnInfo(name = "bio")
    private String mBio;

//   @ColumnInfo(name = "character")
//   private CharacterSheet mCharacter;
}
