package com.bignerdranch.android.shoppingas;

import android.support.v4.app.Fragment;

/**
 * Created by korisnik on 24.05.2017..
 */

public class ShopListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ShopListFragment();
    }
}
