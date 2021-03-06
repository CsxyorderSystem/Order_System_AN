package com.example.a206170.order_system.UserUI;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.a206170.order_system.BusinessListAdapter;
import com.example.a206170.order_system.R;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView loaction_info,set_meal_time;
    private RollPagerView mRollViewPager;
    private OnFragmentInteractionListener mListener;
    private ListView Business_list;
    private  List<Map<String,Object>> business_item;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        mRollViewPager=(RollPagerView)view.findViewById(R.id.ad_roll_pager);
        Business_list=(ListView)view.findViewById(R.id.business_list);

        loaction_info=(TextView)view.findViewById(R.id.location_info);
        set_meal_time=(TextView)view.findViewById(R.id.set_meal_time);

        set_meal_time.setOnClickListener(onClickListener);


        rollpager();//推广轮播
        getList();//获取商家列表
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    //推广轮播
    private void rollpager(){


        //设置播放时间间隔
        mRollViewPager.setPlayDelay(1000);
        //设置透明度
        mRollViewPager.setAnimationDurtion(500);
        //设置适配器
        mRollViewPager.setAdapter(new TestNormalAdapter());

        //设置圆点指示器颜色
        mRollViewPager.setHintView(new ColorPointHintView(getContext(),Color.BLACK,Color.BLUE));

    }

    //推广轮播照片
    private class TestNormalAdapter extends StaticPagerAdapter {
                private int[] imgs = {
                R.drawable.adtest1,
                R.drawable.adtest2,
                R.drawable.adtest3,

               };
        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view=new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;

        }

        @Override
        public int getCount() {
            return imgs.length;
        }

    }
    public void getList(){
        BusinessListAdapter aa=new BusinessListAdapter();
        business_item=aa.getData();
        SimpleAdapter adapter=new SimpleAdapter(getActivity(),business_item,R.layout.business_item,
                new String[]{"business_logo","business_name","business_estimate","business_seal_num","business_price","business_open"},
                new int[]{R.id.business_logo,R.id.business_name,R.id.business_estimate,R.id.business_seal_num,R.id.business_price,R.id.business_open});
        Business_list.setAdapter(adapter);
    }

    //控件监听
    private View.OnClickListener onClickListener=new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.set_meal_time:
                    Intent setmealtime=new Intent(getActivity(),MealTimeActivity.class);
                    startActivity(setmealtime);
            }
        }
    };
}