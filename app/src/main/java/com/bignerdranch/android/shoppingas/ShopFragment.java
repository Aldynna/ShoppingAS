package com.bignerdranch.android.shoppingas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import android.widget.CompoundButton;
import android.widget.EditText;

/**
 *
 */
/**CrimeFragment is a controller that interacts with model and view objects.
 * Its job is to present the details of a specific crime and update those details
 * as the user changes them.**/
public class ShopFragment extends Fragment {
    private Shop mShop;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
/**Fragment.onCreate(Bundle) is a public method, whereas Activity.
 * onCreate(Bundle) is protected. Fragment.onCreate(Bundle) and other Fragment lifecycle methods must be public,
 * because they will be called by whatever activity is hosting the fragment.**/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mShop = new Shop();
    }


    /**This method is where you inflate the layout for the fragment’s view and return
     * the inflated View to the hosting activity.
     * The Bundle will contain data that this method can use to re-create the view from a saved state.
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_shop, container, false);
        mTitleField = (EditText) v.findViewById(R.id.shop_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mShop.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
/**Disabling the button ensures that it will not respond in any way to the user pressing it.
 * It also changes its appearance to advertise its disabled state.**/
        mDateButton = (Button) v.findViewById(R.id.shop_date);
        mDateButton.setText(mShop.getDate().toString());
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.shop_new);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                mShop.setSolved(isChecked);
            }
        });
        return v;
    }






}
