package com.bignerdranch.android.shoppingas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by korisnik
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
/**This code creates and commits a fragment transaction.
 * The FragmentManager.beginTransaction() method creates and returns an instance of FragmentTransaction.
 * So the code highlighted above says,
 * “Create a new fragment transaction, include one add operation in it, and then commit it.”**/
    /**It has two parameters: a container view ID and the newly created ShopFragment.
     * The container view ID should look familiar.
     * It is the resource ID of the FrameLayout that you defined in activity_shop.xml.**/
    /**A container view ID serves two purposes:
     It tells the FragmentManager where in the activity’s view the fragment’s view should appear.
     It is used as a unique identifier for a fragment in the FragmentManager’s list.**/

    /**First, you ask the FragmentManager for the fragment with a container view ID of R.id.fragment_container.
     * If this fragment is already in the list, the FragmentManager will return it.
     * The call to ShopActivity.onCreate(Bundle) could be in response to ShopActivity being re-created after being destroyed on rotation or to reclaim memory.
     * When an activity is destroyed, its FragmentManager saves out its list of fragments.
     * When the activity is re-created, the new FragmentManager
     * retrieves the list and re-creates the listed fragments to make everything as it was before.
     * if there is no fragment with the given container view ID, then fragment will be null. In this case,
     * you create a new ShopFragment and a new fragment transaction that adds the fragment to the list.**/


}
