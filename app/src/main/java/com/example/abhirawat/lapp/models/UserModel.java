package com.example.abhirawat.lapp.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Abhi Rawat on 16-01-2018.
 */

public class UserModel implements Parcelable {
    private String id;

    private String username;

    private String lname;

    private String email;

    private String createdon;

    private String success;

    private String password;

    private String fname;

    private String userType;

    private String mobile;

    private UserModel(Parcel in) {
        id = in.readString();
        username = in.readString();
        lname = in.readString();
        email = in.readString();
        createdon = in.readString();
        success = in.readString();
        password = in.readString();
        fname = in.readString();
        userType = in.readString();
        mobile = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getUsername ()
    {
        return username;
    }

    public void setUsername (String username)
    {
        this.username = username;
    }

    public String getLname ()
    {
        return lname;
    }

    public void setLname (String lname)
    {
        this.lname = lname;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    public String getCreatedon ()
    {
        return createdon;
    }

    public void setCreatedon (String createdon)
    {
        this.createdon = createdon;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getFname ()
    {
        return fname;
    }

    public void setFname (String fname)
    {
        this.fname = fname;
    }

    public String getUserType ()
    {
        return userType;
    }

    public void setUserType (String userType)
    {
        this.userType = userType;
    }

    public String getMobile ()
    {
        return mobile;
    }

    public void setMobile (String mobile)
    {
        this.mobile = mobile;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [id = "+id+", username = "+username+", lname = "+lname+", email = "+email+", createdon = "+createdon+", success = "+success+", password = "+password+", fname = "+fname+", userType = "+userType+", mobile = "+mobile+"]";
    }

    @Override
    public int describeContents() {
        return 1;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(username);
        parcel.writeString(lname);
        parcel.writeString(email);
        parcel.writeString(createdon);
        parcel.writeString(success);
        parcel.writeString(password);
        parcel.writeString(fname);
        parcel.writeString(userType);
        parcel.writeString(mobile);
    }
}
