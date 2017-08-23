package com.example.a206170.order_system.UserUI.Business_menu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.a206170.order_system.R;
import com.example.a206170.order_system.UserUI.Business_menu.wiget.FakeAddImageView;
import com.example.a206170.order_system.UserUI.Business_menu.wiget.PointFTypeEvaluator;
import com.example.a206170.order_system.UserUI.Business_menu.wiget.ShopCartDialog;

import java.util.ArrayList;

public class BusinessMenuActivity extends AppCompatActivity implements FoodTypeAdapter.onItemSelectedListener,ShopCartImp,ShopCartDialog.ShopCartDialogImp {
    private TabHost tabhost;//标签栏
    private RecyclerView leftMenu;//左侧菜单栏
    private RecyclerView rightMenu;//右侧菜单栏
    private TextView headerView;
    private LinearLayout headerLayout;//右侧菜单栏最上面的菜单
    private LinearLayout bottomLayout;
    private Food_Type_domain Food_Type;
    private FoodTypeAdapter foodTypeAdapter;
    private FoodAdapter foodAdapter;
    private ArrayList<Food_Type_domain> dishMenuList;//数据源
    private boolean leftClickType = false;//左侧菜单点击引发的右侧联动
    private ShopCart shopCart;
    //    private FakeAddImageView fakeAddImageView;
    private ImageView shoppingCartView;
    private FrameLayout shopingCartLayout;
    private TextView totalPriceTextView;
    private TextView totalPriceNumTextView;
    private RelativeLayout mainLayout;
    private final static String TAG = "BusinessMenuActivity";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //去除标题栏阴影
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_business_menu);

        initData();
        initView();
        initAdapter();

        //返回按钮
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        //声明tabhost

        //得到TabHost对象实例
        tabhost =(TabHost) findViewById(R.id.mytab);
        //调用 TabHost.setup()
        tabhost.setup();
        //创建Tab标签
        tabhost.addTab(tabhost.newTabSpec("one").setIndicator("商品").setContent(R.id._business_menu));
        tabhost.addTab(tabhost.newTabSpec("two").setIndicator("评价").setContent(R.id.widget_layout_yellow));

    }
    //监听标题栏
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initView(){
        mainLayout = (RelativeLayout)findViewById(R.id._business_menu);
        leftMenu = (RecyclerView)findViewById(R.id.left_menu);
        rightMenu = (RecyclerView)findViewById(R.id.right_menu);
        headerView = (TextView)findViewById(R.id.right_menu_tv);
        headerLayout = (LinearLayout)findViewById(R.id.right_menu_item);
//        fakeAddImageView = (FakeAddImageView)findViewById(R.id.right_dish_fake_add);
        bottomLayout = (LinearLayout)findViewById(R.id.shopping_cart_bottom);
        shoppingCartView = (ImageView) findViewById(R.id.shopping_cart);
        shopingCartLayout = (FrameLayout) findViewById(R.id.shopping_cart_layout);
        totalPriceTextView = (TextView)findViewById(R.id.shopping_cart_total_tv);
        totalPriceNumTextView = (TextView)findViewById(R.id.shopping_cart_total_num);

        leftMenu.setLayoutManager(new LinearLayoutManager(this));
        rightMenu.setLayoutManager(new LinearLayoutManager(this));

        rightMenu.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if( recyclerView.canScrollVertically(1)==false) {//无法下滑
                    //显示类别名
                    showHeadView();
                    return;
                }
                View underView = null;
                if(dy>0)
                    underView = rightMenu.findChildViewUnder(headerLayout.getX(),headerLayout.getMeasuredHeight()+1);
                else
                    underView = rightMenu.findChildViewUnder(headerLayout.getX(),0);
                if(underView!=null && underView.getContentDescription()!=null ){
                    int position = Integer.parseInt(underView.getContentDescription().toString());
                    Food_Type_domain type = foodAdapter.getTypeOfTypeByPosition(position);

                    if(leftClickType || !type.getF_type().equals(Food_Type.getF_type())) {
                        if (dy> 0 && headerLayout.getTranslationY()<=1 && headerLayout.getTranslationY()>= -1 * headerLayout.getMeasuredHeight()*4/5 && !leftClickType) {// underView.getTop()>9
                            int dealtY = underView.getTop() - headerLayout.getMeasuredHeight();
                            headerLayout.setTranslationY(dealtY);
//                            Log.e(TAG, "onScrolled: "+headerLayout.getTranslationY()+"   "+headerLayout.getBottom()+"  -  "+headerLayout.getMeasuredHeight() );
                        }
                        else if(dy<0 && headerLayout.getTranslationY()<=0 && !leftClickType) {
                            headerView.setText(type.getF_type());
                            int dealtY = underView.getBottom() - headerLayout.getMeasuredHeight();
                            headerLayout.setTranslationY(dealtY);
//                            Log.e(TAG, "onScrolled: "+headerLayout.getTranslationY()+"   "+headerLayout.getBottom()+"  -  "+headerLayout.getMeasuredHeight() );
                        }
                        else{
                            headerLayout.setTranslationY(0);
                            Food_Type = type;
                            headerView.setText(Food_Type.getF_type());
                            for (int i = 0; i < dishMenuList.size(); i++) {
                                if (dishMenuList.get(i) ==Food_Type) {
                                    FoodTypeAdapter.setSelectedNum(i);
                                    break;
                                }
                            }
                            if(leftClickType)leftClickType=false;
                            Log.e(TAG, "onScrolled: "+type.getF_type() );
                        }
                    }
                }
            }
        });

        shopingCartLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCart(view);
            }
        });
    }
    //声明适配器
    private void initAdapter(){
        foodTypeAdapter=new FoodTypeAdapter(this,dishMenuList);
        foodAdapter = new FoodAdapter(this,dishMenuList,shopCart);
        rightMenu.setAdapter(foodAdapter);
        leftMenu.setAdapter(foodTypeAdapter);
        foodTypeAdapter.addItemSelectedListener(this);
        foodAdapter.setShopCartImp(this);
        initHeadView();
    }

    //
    private void initHeadView(){
        Food_Type = FoodAdapter.getTypeOfTypeByPosition(0);
        headerLayout.setContentDescription("0");
        headerView.setText(Food_Type.getF_type());
    }

    private void showHeadView(){
        headerLayout.setTranslationY(0);
        View underView = rightMenu.findChildViewUnder(headerView.getX(),0);
        if(underView!=null && underView.getContentDescription()!=null){
            int position = Integer.parseInt(underView.getContentDescription().toString());
            Food_Type_domain type = foodAdapter.getTypeOfTypeByPosition(position+1);
            Food_Type = type;
            headerView.setText(Food_Type.getF_type());
            for (int i = 0; i < dishMenuList.size(); i++) {
                if (dishMenuList.get(i) == Food_Type) {
                    FoodTypeAdapter.setSelectedNum(i);
                    break;
                }
            }
        }
    }

    //弹出购物车
    private void showCart(View view) {
        if(shopCart!=null&&shopCart.getShoppingAccount()>0){
            ShopCartDialog dialog=new ShopCartDialog(this,shopCart,R.style.cartdialog);
            Window window=dialog.getWindow();
            dialog.setShopCartDialogImp(this);
            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);
            dialog.show();
            WindowManager.LayoutParams params=window.getAttributes();
            params.width = WindowManager.LayoutParams.MATCH_PARENT;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.gravity = Gravity.BOTTOM;
            params.dimAmount =0.5f;
            window.setAttributes(params);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        foodTypeAdapter.removeItemSelectedListener(this);
    }

    //隐藏购物车
    @Override
    public void dialogDismiss() {
        showTotalPrice();
        foodAdapter.notifyDataSetChanged();
    }

    //计算总价
    private void showTotalPrice(){
        if(shopCart!=null && shopCart.getShoppingTotalPrice()>0){
            totalPriceTextView.setVisibility(View.VISIBLE);
            totalPriceTextView.setText("￥ "+shopCart.getShoppingTotalPrice());
            totalPriceNumTextView.setVisibility(View.VISIBLE);
            totalPriceNumTextView.setText(""+shopCart.getShoppingAccount());
        }
        else{
            totalPriceTextView.setVisibility(View.GONE);
            totalPriceNumTextView.setVisibility(View.GONE);
        }
    }


    //添加菜品至购物车
    @Override
    public void add(View view, int postion) {
        int[] addLocation = new int[2];
        int[] cartLocation = new int[2];
        int[] recycleLocation = new int[2];
        view.getLocationInWindow(addLocation);
        shoppingCartView.getLocationInWindow(cartLocation);
        rightMenu.getLocationInWindow(recycleLocation);

        PointF startP = new PointF();
        PointF endP = new PointF();
        PointF controlP = new PointF();

        startP.x = addLocation[0];
        startP.y = addLocation[1]-recycleLocation[1];
        endP.x = cartLocation[0];
        endP.y = cartLocation[1]-recycleLocation[1];
        controlP.x = endP.x;
        controlP.y = startP.y;

        final FakeAddImageView fakeAddImageView = new FakeAddImageView(this);
        mainLayout.addView(fakeAddImageView);
        fakeAddImageView.setImageResource(R.drawable.ic_add_circle_blue_700_36dp);
        fakeAddImageView.getLayoutParams().width = getResources().getDimensionPixelSize(R.dimen.item_dish_circle_size);
        fakeAddImageView.getLayoutParams().height = getResources().getDimensionPixelSize(R.dimen.item_dish_circle_size);
        fakeAddImageView.setVisibility(View.VISIBLE);
        ObjectAnimator addAnimator = ObjectAnimator.ofObject(fakeAddImageView, "mPointF",
                new PointFTypeEvaluator(controlP), startP, endP);
        addAnimator.setInterpolator(new AccelerateInterpolator());
        addAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {
                fakeAddImageView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animator) {
                fakeAddImageView.setVisibility(View.GONE);
                mainLayout.removeView(fakeAddImageView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        ObjectAnimator scaleAnimatorX = new ObjectAnimator().ofFloat(shoppingCartView,"scaleX", 0.6f, 1.0f);
        ObjectAnimator scaleAnimatorY = new ObjectAnimator().ofFloat(shoppingCartView,"scaleY", 0.6f, 1.0f);
        scaleAnimatorX.setInterpolator(new AccelerateInterpolator());
        scaleAnimatorY.setInterpolator(new AccelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(scaleAnimatorX).with(scaleAnimatorY).after(addAnimator);
        animatorSet.setDuration(800);
        animatorSet.start();

        showTotalPrice();
    }

    @Override
    public void remove(View view, int postion) {
        showTotalPrice();
    }

    @Override
    public void onLeftItemSelected(int position, Food_Type_domain type) {
        int sum=0;
        for(int i = 0;i<position;i++){
            sum+=dishMenuList.get(i).getFood_list().size()+1;
        }
        LinearLayoutManager layoutManager = (LinearLayoutManager) rightMenu.getLayoutManager();
        layoutManager.scrollToPositionWithOffset(sum,0);
        leftClickType = true;

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void initData(){
        shopCart=new ShopCart();
        dishMenuList=new ArrayList<>();
    }
}
