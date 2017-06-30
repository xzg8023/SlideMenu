package xzg.slidemenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzg
 * @time 2017/6/21  17:38
 */
public class Fragment1 extends Fragment {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private int i = 0;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bt = (Button) view.findViewById(R.id.bt);
        Button bts = (Button) view.findViewById(R.id.bts);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity mainActivity = (MainActivity) getActivity();
                FragmentMenu fragmentMenu = mainActivity.getFragmentMenu();
                String menu = "item" + i;
                i++;
                fragmentMenu.refreshMenu(menu);
            }
        });
        MainActivity mainActivity = (MainActivity) getActivity();
        final FragmentMenu fragmentMenu = mainActivity.getFragmentMenu();
        fragmentMenu.refreshMenus(getdatas(15));
        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                List<String> getdatas = getdatas(5);
                fragmentMenu.refreshMenus(getdatas);
            }
        });
    }

    private int a = 0;
    private int conunt = 0;

    private List<String> getdatas(int size) {
        List<String> list = new ArrayList<>();
        conunt = conunt + size;
        for (int j = a; j < conunt; j++) {
            a++;
            list.add("item--" + j);
        }
        return list;
    }
}
