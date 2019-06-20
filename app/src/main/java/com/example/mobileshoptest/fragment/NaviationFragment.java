package com.example.mobileshoptest.fragment;

import android.os.Build;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobileshoptest.R;

public class NaviationFragment extends Fragment implements View.OnClickListener {
    private LinearLayout SYlayout,WDlayout,GWlayout,FLlayout;
    private ImageView SYimage,WDimage,GWimage,FLimage;
    private TextView SYtext,WDtext,GWtext,FLtext;
    private Fragment homeFragment,categoryFragment,cartFragment,persionFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation,container,false);
        initView(view);
        setTabSelection(R.id.sy_layout);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void initView(View view){

        //初始化Fragment
        homeFragment = new HomeFragment();
        categoryFragment = new CategoryFragment();
        cartFragment = new CartFargment();
        persionFragment = new PersionFragment();

        //四个线性布局
        SYlayout = view.findViewById(R.id.sy_layout);
        WDlayout = view.findViewById(R.id.wd_layout);
        GWlayout = view.findViewById(R.id.gw_layout);
        FLlayout = view.findViewById(R.id.fl_layout);
        //四个 image
        SYimage = view.findViewById(R.id.sy_image);
        WDimage = view.findViewById(R.id.wd_image);
        GWimage = view.findViewById(R.id.gw_image);
        FLimage= view.findViewById(R.id.fl_image);
        //四个text
        SYtext = view.findViewById(R.id.sy_text);
        WDtext = view.findViewById(R.id.wd_text);
        GWtext = view.findViewById(R.id.gw_text);
        FLtext = view.findViewById(R.id.fl_text);
        //点击事件的监听
        SYlayout.setOnClickListener(this);
        WDlayout.setOnClickListener(this);
        GWlayout.setOnClickListener(this);
        FLlayout.setOnClickListener(this);

        //默认状态
        SYimage.setImageResource(R.drawable.ic_r_sy);
        SYtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
        FLimage.setImageResource(R.drawable.ic_w_fl);
        FLtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
        GWimage.setImageResource(R.drawable.ic_w_gw);
        GWtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
        WDimage.setImageResource(R.drawable.ic_w_wd);
        WDtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
        //获取fragment管理类
        fragmentManager = getActivity().getSupportFragmentManager();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private void clean(){
        SYimage.setImageResource(R.drawable.ic_w_sy);
        SYtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
        FLimage.setImageResource(R.drawable.ic_w_fl);
        FLtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
        GWimage.setImageResource(R.drawable.ic_w_gw);
        GWtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
        WDimage.setImageResource(R.drawable.ic_w_wd);
        WDtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));

    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setTabSelection(int id){
        clean();
        fragmentTransaction = fragmentManager.beginTransaction();
        //隐藏所有Fragment
//        if (homeFragment != null){
//            fragmentTransaction.hide(homeFragment);
//        }
//        if (cartFragment != null){
//            fragmentTransaction.hide(cartFragment);
//        }
//        if (categoryFragment != null){
//            fragmentTransaction.hide(categoryFragment);
//        }
//        if (persionFragment != null){
//            fragmentTransaction.hide(persionFragment);
//        }
        switch (id){
            case R.id.sy_layout:
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content,homeFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,homeFragment);
                }
                SYimage.setImageResource(R.drawable.ic_r_sy);
                SYtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;
            case R.id.fl_layout:
                if (categoryFragment == null){
                    categoryFragment = new CategoryFragment();
                    fragmentTransaction.replace(R.id.content,categoryFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,categoryFragment);
                }
                FLimage.setImageResource(R.drawable.ic_r_fl);
                FLtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;
            case R.id.gw_layout:
                if (cartFragment == null){
                    cartFragment = new CartFargment();
                    fragmentTransaction.replace(R.id.content,cartFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,cartFragment);
                }
                GWimage.setImageResource(R.drawable.ic_r_gw);
                GWtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;
            case R.id.wd_layout:
                if (persionFragment == null){
                    persionFragment = new PersionFragment();
                    fragmentTransaction.replace(R.id.content,persionFragment);
                }else {
                    fragmentTransaction.replace(R.id.content,persionFragment);
                }
                WDimage.setImageResource(R.drawable.ic_r_wd);
                WDtext.setTextColor(ContextCompat.getColor(getActivity(),R.color.red));
                break;
        }
        fragmentTransaction.commit();
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View v) {
        setTabSelection(v.getId());
    }
}
