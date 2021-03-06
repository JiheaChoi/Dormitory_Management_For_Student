package com.example.cjproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cjproject.CWriteActivity;
import com.example.cjproject.CleanDetailActivity;
import com.example.cjproject.R;
import com.example.cjproject.bean.CleanBean;

import org.w3c.dom.Text;

import java.util.List;

public class CleanAdapter extends BaseAdapter {

    private Context mContext;
    private List<CleanBean> mList;

    public CleanAdapter(Context context, List<CleanBean> list){
        mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.view_clean, null);

        View layTopRow = convertView.findViewById(R.id.layTopRow);
        TextView txtTitle = convertView.findViewById(R.id.txtTitle);

        if (position == 0 ) {
            layTopRow.setVisibility(View.VISIBLE);
        } else {
            layTopRow.setVisibility(View.GONE);
        }

        final CleanBean bean = mList.get(position);

        txtTitle.setText(bean.title);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, CleanDetailActivity.class);
                i.putExtra(CleanBean.class.getName(), bean);

                mContext.startActivity(i);
            }
        });

        return convertView;
    }
}
