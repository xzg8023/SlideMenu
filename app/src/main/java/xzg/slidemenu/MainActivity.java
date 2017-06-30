package xzg.slidemenu;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout mCenterFrame;
    private View leftView;
    private FragmentMenu mFragmentMenu;
    private Fragment1 mFragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCenterFrame = (FrameLayout) findViewById(R.id.center_frame);

        if (leftView != null) {
            leftView.getLayoutParams().width = (int) (getResources().getDisplayMetrics().widthPixels * 0.8f);
        }
        initFragment();
    }

    private void initFragment() {
        FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
        mFragmentMenu = new FragmentMenu();
        mFragment1 = new Fragment1();
        t.replace(R.id.left_frame, mFragmentMenu);
        t.replace(R.id.center_frame, mFragment1);
        t.commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public FragmentMenu getFragmentMenu() {
        return mFragmentMenu;
    }
}
