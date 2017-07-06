package com.ex.droidlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        FragmentClickListener {

    private Toolbar mToolbar;
    ListView left_drawer;
    ArrayList<String> myArray;
    private ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout drawerLayout;
    public static WeakReference<MainActivity> sWeakActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        left_drawer = (ListView) findViewById(R.id.left_drawer);
        sWeakActivity = new WeakReference<>(MainActivity.this);

        myArray = new ArrayList<String>();

        myArray.add("ListView without ViewHolder");
        myArray.add("ListView with ViewHolder");
        myArray.add("ListView with ArrayAdapter");
        myArray.add("View Flipper");
        myArray.add("View Pager with FragmentPagerAdapter");
        myArray.add("Tab Layout");
        myArray.add("Tabs with PagerSlidingTabStrip");
        myArray.add("GridView with ArrayAdapter");
        myArray.add("View Pager with PagerAdapter");
        myArray.add("View Pager with AutoScroll");
        myArray.add("RecyclerView");
        myArray.add("Grid Layout");
        myArray.add("Table Layout");
        myArray.add("ListView with Images");
        myArray.add("AsyncTask Example");
        myArray.add("IntentService Example");
        myArray.add("Service Example");
        myArray.add("Foreground Service Example");
        myArray.add("ViewPager with PageTransformer");
        myArray.add("Custom ProgressBar");
        myArray.add("Bottom Sheet");
        myArray.add("Animation List");
        myArray.add("Vector Drawable");
        myArray.add("Native Data Binding Fragment");
        myArray.add("Native Data Binding Activity");
        myArray.add("ConstraintLayout");
        myArray.add("ObjectAnimator");
        myArray.add("Webview Browser");
        myArray.add("Lottie Animation");
        myArray.add("Camera API");
        myArray.add("Seconds Counter");
        myArray.add("Arrow Anlmation");
        myArray.add("Random Background");
//        StartActivityForResult

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        // getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_navigation);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
        // mToolbar,
        // R.string.drawer_open, R.string.drawer_close);

        if (mToolbar != null) {
            mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                    mToolbar, R.string.drawer_open, R.string.drawer_close);
            mDrawerToggle.syncState();
            drawerLayout.setDrawerListener(mDrawerToggle);
            getSupportFragmentManager().addOnBackStackChangedListener(
                    new FragmentManager.OnBackStackChangedListener() {
                        @Override
                        public void onBackStackChanged() {
                            if (getSupportFragmentManager()
                                    .getBackStackEntryCount() > 0) {
                                getSupportActionBar()
                                        .setDisplayHomeAsUpEnabled(true); // show
                                // back
                                // button
                                mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        onBackPressed();
                                    }
                                });
                            } else {
                                // show hamburger
                                getSupportActionBar()
                                        .setDisplayHomeAsUpEnabled(false);
                                mDrawerToggle.syncState();
                                mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        drawerLayout
                                                .openDrawer(GravityCompat.START);
                                    }
                                });
                            }
                        }
                    });
        }

        // drawerLayout.setDrawerListener(mDrawerToggle);
        // drawerLayout.post(new Runnable() {
        // @Override
        // public void run() {
        // mDrawerToggle.syncState();
        // }
        // });

        left_drawer.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myArray));

        left_drawer.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                switch (arg2) {
                    case 0:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyListview1Fragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 1:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyListView2Fragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;

                    case 2:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyListView3Fragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this,
                                MyViewFipperActivity.class));
                        drawerLayout.closeDrawers();
                        break;

                    case 4:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyViewPagerFrag())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;

                    case 5:
                        startActivity(new Intent(MainActivity.this,
                                MaterialTabActivity.class));
                        drawerLayout.closeDrawers();
                        break;

                    case 6:
                        startActivity(new Intent(MainActivity.this,
                                CustomTabsActivity.class));
                        drawerLayout.closeDrawers();
                        break;
                    case 7:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyGridViewFragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;

                    case 8:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyViewPager()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 9:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyViewPagerAuto())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 10:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new MyRecycelerViewFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 11:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyGridLayoutFragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 12:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main, new MyTableLayoutFragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 13:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyListImagesFragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 14:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.frm_main, new MyAsyncFragment())
                                .commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 15:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new MyIntentServiceFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 16:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new ExampleServiceFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 17:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new ForegroundServiceFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 18:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new MyPagerTransformer()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 19:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new MyCustomProgressBarFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 20:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new BottomSheetFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 21:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new AnimationListFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 22:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new VectorDrawableFragment()).commit();
                        drawerLayout.closeDrawers();
                    case 23:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new SimpleBindingFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 24:
                        startActivity(new Intent(MainActivity.this,
                                DataBindingActivity.class));
                        drawerLayout.closeDrawers();
                        break;
                    case 25:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new ConstraintLayoutFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 26:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new ObjectAnimatorFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 27:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new WebviewFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 28:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new LottieExampleFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 29:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new CameraFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 30:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new SecondsCounterFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 31:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new ArrowAnimationListFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                    case 32:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.frm_main,
                                        new BlinkingBackgroundFragment()).commit();
                        drawerLayout.closeDrawers();
                        break;
                }

            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frm_main, new MyListview1Fragment()).commit();

        // ATTENTION: This was auto-generated to handle app links.
        Intent appLinkIntent = getIntent();
        String appLinkAction = appLinkIntent.getAction();
        Uri appLinkData = appLinkIntent.getData();
        if (appLinkData != null) {
            Log.e("appLinkData", appLinkData.toString());
            Log.e("appLinkData Path", appLinkData.getPath());
            Log.e("appLinkData LastPath", appLinkData.getLastPathSegment());

        }

    }

    @Override
    public void onBackPressed() {

        int backStackEntryCount = getSupportFragmentManager()
                .getBackStackEntryCount();

        if (!(backStackEntryCount == 0)) {
            // Toast.makeText(MainActivity.this,
            // String.valueOf(backStackEntryCount), Toast.LENGTH_LONG)
            // .show();
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED,
                    left_drawer);
            super.onBackPressed();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks hmDrawerToggle = new
        // ActionBarDrawerToggle(

        int id = item.getItemId();

        switch (id) {
            case R.id.listView1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm_main, new MyListview1Fragment()).commit();
                return true;

            case R.id.listView2:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm_main, new MyListView2Fragment()).commit();
                return true;

            case R.id.listView3:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm_main, new MyListView3Fragment()).commit();
                return true;
            case R.id.viewfipper:
                startActivity(new Intent(MainActivity.this,
                        MyViewFipperActivity.class));
                return true;

            case R.id.viewpager:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frm_main, new MyViewPagerFrag()).commit();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void syncActionBarArrowState() {
        int backStackEntryCount = getSupportFragmentManager()
                .getBackStackEntryCount();
        mDrawerToggle.setDrawerIndicatorEnabled(backStackEntryCount == 0);
    }

    @Override
    public void onFragmentSelected(int position) {

//        MyViewPager nextFrag = new MyViewPager();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frm_main, MyViewPager.newInstance(MainActivity.this, "")).addToBackStack(null)
                .commit();

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED,
                left_drawer);
        // mDrawerToggle.setDrawerIndicatorEnabled(enable);

    }

    public void changeToolbarBackground(int color) {
        mToolbar.setBackgroundColor(color);
    }
}
