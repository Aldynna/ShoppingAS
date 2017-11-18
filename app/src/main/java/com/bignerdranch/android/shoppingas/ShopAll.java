package com.bignerdranch.android.shoppingas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
/**A singleton is a class that allows only one instance of itself to be created.
 * the s prefix on the sShopAll variable is to make it clear that sShopAll is a static variable.**/
public class ShopAll {

    private static ShopAll sShopAll;
    /**shorthand notation < > tells the compiler to infer the type of items the List will
     * contain based on the generic argument passed in the variable declaration.**/
    private List<Shop> mShops;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ShopAll get(Context context) {
        if (sShopAll == null) {
            sShopAll = new ShopAll(context);
        }
        return sShopAll;
    }
/**List<E> is an interface that supports an ordered list of objects of a given type.
 * It defines methods for retrieving, adding, and deleting elements.**/

    private ShopAll(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new BaseHelper(mContext).getWritableDatabase();
        mShops = new ArrayList<>();
        //dodajemo artikle
        for (int i = 0; i < 100; i++) {
            Shop shop = new Shop();
            shop.setTitle("Item #" + i);
            shop.setSolved(i % 2 == 0); // svaka druga
            mShops.add(shop);
        }
    }


    public List<Shop> getShops() {
        return mShops;
    }

    public Shop getCrime(UUID id) {
        for (Shop shop : mShops) {
            if (shop.getId().equals(id)) {
                return shop;
            }
        }
        return null;
    }

}
