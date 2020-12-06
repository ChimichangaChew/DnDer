package com.chimichangachew.dnder;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "profiles")
public class Profile {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private long mUid;

    @ColumnInfo(name = "username")
    private String mUsername;

    @ColumnInfo(name = "age")
    private int mAge;

    @ColumnInfo(name = "bio")
    private String mBio;

//   @ColumnInfo(name = "character")
//   private CharacterSheet mCharacter;
    public String getUsername(){
        return mUsername;
    }
    public void setUsername(String username){mUsername = username;}
    public int getAge(){return mAge;}
    public void setAge(int age){mAge = age;}
    public String getBio(){return mBio;}
    public void setBio(String bio){mBio=bio;}
    public long getUid(){return mUid;}
    public void setUid(long uid){mUid = uid;}
}
