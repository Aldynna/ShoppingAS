package com.bignerdranch.android.shoppingas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 *
 */

public class ShopListFragment extends Fragment {
    private RecyclerView mShopRecyclerView;
    private ShopAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_list, container, false);

        mShopRecyclerView = (RecyclerView) view
                .findViewById(R.id.shop_recycler_view);
        mShopRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    private void updateUI() {
        ShopAll shopAll = ShopAll.get(getActivity());
        List<Shop> shops = shopAll.getShops();

        mAdapter = new ShopAdapter(shops);
        mShopRecyclerView.setAdapter(mAdapter);
    }
/**ViewHolder that will inflate and own your layout.**/
    private class ShopHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView mTitleTextView;
    private TextView mDateTextView;
    private Shop mShop;
        public ShopHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_shop, parent, false));
            mTitleTextView = (TextView) itemView.findViewById(R.id.shop_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.shop_date);

        }
    public void bind(Shop shop) {
        mShop = shop;
        mTitleTextView.setText(mShop.getTitle());
        mDateTextView.setText(mShop.getDate().toString());
    }
    @Override
    public void onClick(View view) {
        Toast.makeText(getActivity(),
                mShop.getTitle() + " clicked!", Toast.LENGTH_SHORT)
                .show();
    }

    }
/**When the RecyclerView needs to display a new ViewHolder or connect a Shopobject to an existing ViewHolder,
 * it will ask this adapter for help by calling a method on it. The RecyclerView
 * itself will not know anything about the Shop object, but the Adapter will know all of Crime’s intimate and personal details.**/
    private class ShopAdapter extends RecyclerView.Adapter<ShopHolder> {

        private List<Shop> mShops;

        public ShopAdapter(List<Shop> crimes) {
            mShops = crimes;
        }

    @Override
    public ShopHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

        return new ShopHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(ShopHolder holder, int position) {
        Shop shop = mShops.get(position);
        holder.bind(shop);
    }

    @Override
    public int getItemCount() {
        return mShops.size();
    }
    }

}
