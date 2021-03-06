package com.bignerdranch.android.shoppingas;
import java.util.Date;
import java.util.UUID;
/**
 * Created by korisnik on 23.05.2017..
 */

public class Shop {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public UUID getId() {
        return mId;
    }

    public void setId(UUID id) {
        mId = id;
    }


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }



    public Shop() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }
}
