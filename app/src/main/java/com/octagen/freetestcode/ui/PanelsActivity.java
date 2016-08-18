package com.octagen.freetestcode.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.octagen.freetestcode.R;
import com.octagen.freetestcode.adapters.PanelAdapter;
import com.octagen.freetestcode.models.PanelItem;
import com.octagen.freetestcode.utils.decorations.GridSpacingItemDecoration;
import com.octagen.freetestcode.utils.decorations.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PanelsActivity extends ActionbarActivity {

    @Bind(R.id.topList)
    RecyclerView topList;
    @Bind(R.id.bottomList)
    RecyclerView bottomList;

    private List<PanelItem> mTopItems;
    private List<PanelItem> mBottomItems;
    private PanelAdapter mTopPanelAdapter;
    private PanelAdapter mBottomPanelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panels);
        ButterKnife.bind(this);

        setupActionBar();
        setupRecyclerView();
        populateRecyclerView();
    }

    @Override
    protected void setupActionBar() {
        super.setupActionBar();

        mActionBar.isHelpEnabled(true);
    }

    private void setupRecyclerView() {
        mTopItems = new ArrayList<>();
        topList.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false));
        topList.addItemDecoration(new SpacesItemDecoration(8));

        mBottomItems = new ArrayList<>();
        bottomList.setLayoutManager(new GridLayoutManager(this, 3));
        bottomList.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        bottomList.setItemAnimator(new DefaultItemAnimator());
    }

    private void populateRecyclerView() {
        mTopItems.add(new PanelItem(R.drawable.ahead));
        mTopItems.add(new PanelItem(R.drawable.bend));
        mTopItems.add(new PanelItem(R.drawable.death));
        mTopItems.add(new PanelItem(R.drawable.electricity));
        mTopItems.add(new PanelItem(R.drawable.ahead));
        mTopItems.add(new PanelItem(R.drawable.bend));
        mTopItems.add(new PanelItem(R.drawable.death));
        mTopItems.add(new PanelItem(R.drawable.electricity));
        mTopItems.add(new PanelItem(R.drawable.ahead));
        mTopItems.add(new PanelItem(R.drawable.bend));
        mTopItems.add(new PanelItem(R.drawable.death));
        mTopItems.add(new PanelItem(R.drawable.electricity));

        mBottomItems.add(new PanelItem(R.drawable.ahead));
        mBottomItems.add(new PanelItem(R.drawable.bend));
        mBottomItems.add(new PanelItem(R.drawable.death));
        mBottomItems.add(new PanelItem(R.drawable.electricity));
        mBottomItems.add(new PanelItem(R.drawable.ahead));
        mBottomItems.add(new PanelItem(R.drawable.bend));
        mBottomItems.add(new PanelItem(R.drawable.death));
        mBottomItems.add(new PanelItem(R.drawable.electricity));
        mBottomItems.add(new PanelItem(R.drawable.ahead));
        mBottomItems.add(new PanelItem(R.drawable.bend));
        mBottomItems.add(new PanelItem(R.drawable.death));
        mBottomItems.add(new PanelItem(R.drawable.electricity));

        if (mTopPanelAdapter == null) {
            mTopPanelAdapter = new PanelAdapter(this, mTopItems);
            topList.setAdapter(mTopPanelAdapter);
        } else
            mTopPanelAdapter.animateTo(mTopItems);

        if (mBottomPanelAdapter == null) {
            mBottomPanelAdapter = new PanelAdapter(this, mTopItems);
            bottomList.setAdapter(mBottomPanelAdapter);
        } else
            mBottomPanelAdapter.animateTo(mTopItems);
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
