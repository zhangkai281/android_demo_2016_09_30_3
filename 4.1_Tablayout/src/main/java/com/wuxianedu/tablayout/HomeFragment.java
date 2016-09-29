package com.wuxianedu.tablayout;

import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by caibing.zhang on 2016/8/26.
 */
public class HomeFragment extends BaseTabViewpageFragment {

    @Override
    protected void initViewpagerFragmentList(List<Fragment> viewpagerFragmentList, List<String> mTitles) {
        mTitles.add("新闻");
        viewpagerFragmentList.add(new NewsFragment());

        mTitles.add("体育");
        viewpagerFragmentList.add(new SportsFragment());

        mTitles.add("娱乐");
        viewpagerFragmentList.add(new Funfragment());

//        mTitles.add("新闻2");
//        viewpagerFragmentList.add(new NewsFragment());
//
//        mTitles.add("体育2");
//        viewpagerFragmentList.add(new SportsFragment());
//
//        mTitles.add("娱乐2");
//        viewpagerFragmentList.add(new Funfragment());
//
//        mTitles.add("新闻3");
//        viewpagerFragmentList.add(new NewsFragment());
//
//        mTitles.add("体育3");
//        viewpagerFragmentList.add(new SportsFragment());
//
//        mTitles.add("娱乐3");
//        viewpagerFragmentList.add(new Funfragment());
    }
}
