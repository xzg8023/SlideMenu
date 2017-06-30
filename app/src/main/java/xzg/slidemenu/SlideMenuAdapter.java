package xzg.slidemenu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xzg
 * @time 2017/6/29  9:06
 */
public class SlideMenuAdapter extends RecyclerView.Adapter<SlideMenuAdapter.SlideMenuViewHolder> {

    private List<String> datas = new ArrayList<>();

    private Context mContext;

    public SlideMenuAdapter(Context context) {
        mContext = context;
    }

    @Override
    public SlideMenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new SlideMenuViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_menu, null));
    }

    @Override
    public void onBindViewHolder(SlideMenuViewHolder holder, final int position) {
        final String name = datas.get(position);
        holder.mTv_menu.setText(name);
        holder.ll_item_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClickListener.itemOnClickListener(position, name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void setDatas(List<String> list) {
        datas.addAll(list);
        notifyDataSetChanged();
    }

    public void setData(String menu) {
        datas.add(menu);
        notifyDataSetChanged();
    }

    interface ItemOnClickListener<T> {
        void itemOnClickListener(int position, T item);
    }

    private ItemOnClickListener itemOnClickListener;

    public void setOnCliclListener(ItemOnClickListener itemOnClickListener) {
        this.itemOnClickListener = itemOnClickListener;
    }

    class SlideMenuViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTv_menu;
        private final RelativeLayout ll_item_content;

        public SlideMenuViewHolder(View itemView) {
            super(itemView);
            mTv_menu = (TextView) itemView.findViewById(R.id.tv_menu);
            ll_item_content = (RelativeLayout) itemView.findViewById(R.id.rl_item_content);
        }

    }
}
