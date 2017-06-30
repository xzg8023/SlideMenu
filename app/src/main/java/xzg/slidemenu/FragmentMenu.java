package xzg.slidemenu;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * @author xzg
 * @time 2017/6/21  17:52
 */
public class FragmentMenu extends Fragment implements SlideMenuAdapter.ItemOnClickListener<String> {

    private RecyclerView mRecycleview;

    private SlideMenuAdapter mAdapter;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity();
        mRecycleview = (RecyclerView) view.findViewById(R.id.recycleview);
        mAdapter = new SlideMenuAdapter(mContext);
        mRecycleview.setLayoutManager(new LinearLayoutManager(mContext));
        mRecycleview.setAdapter(mAdapter);
        mAdapter.setOnCliclListener(this);
    }

    public void refreshMenu(String menu) {

        mAdapter.setData(menu);
    }

    public void refreshMenus(List<String> menus) {

        mAdapter.setDatas(menus);
    }

    @Override
    public void itemOnClickListener(int position, String item) {
        Toast.makeText(mContext,"点击"+item,Toast.LENGTH_SHORT).show();
    }
}
