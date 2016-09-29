package com.wuxianedu.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public abstract class BaseTabViewpageFragment extends Fragment {

    private TabLayout tabLayout;

    private ViewPager viewPager;

    private List<Fragment> viewpagerFragmentList;
    private List<String> mTitles;

    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewpagerFragmentList = new ArrayList<>();
        mTitles = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(rootView==null){
            rootView = inflater.inflate(R.layout.fragment_tab, container, false);

            builderView(rootView);
        }else{
            ViewGroup p = (ViewGroup) rootView.getParent();
            if (p != null) {
                p.removeAllViewsInLayout();
            }
        }
        return rootView;
    }

    public void builderView(View rootView) {
        tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        viewPager = (ViewPager) rootView.findViewById(R.id.view_pager);

        initViewpagerFragmentList(viewpagerFragmentList, mTitles);

        ViewpagerAdapter adapter = new ViewpagerAdapter(
                getActivity().getSupportFragmentManager(), viewpagerFragmentList, mTitles);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    /**
     * 值为TabLayout.GRAVITY_FILL 或 TabLayout.GRAVITY_CENTER
     * @param gravity
     */
    protected void setTabGravity(int gravity){
        tabLayout.setTabGravity(gravity);
    }

    /**
     * TabLayout.MODE_FIXED 或TabLayout.MODE_SCROLLABLE
     * @param mode
     */
    protected void setTabMode(int mode){
        tabLayout.setTabMode(mode);
    }

    protected abstract void initViewpagerFragmentList(List<Fragment> viewpagerFragmentList, List<String> mTitles);
}
