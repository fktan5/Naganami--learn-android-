package net.fktan5.hoge001;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecycleViewAdapter extends RecyclerView.Adapter {

    private LayoutInflater mLayoutInflater;

    public RecycleViewAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecycleViewHolder(
                mLayoutInflater.inflate(R.layout.item_recycleview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecycleViewHolder)holder).mTextName.setText(String.valueOf(position));
        ((RecycleViewHolder)holder).mTextType.setText(String.valueOf(position));
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    private static class RecycleViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextName;
        public TextView mTextType;
        public RecycleViewHolder(View itemView) {
            super(itemView);
            mTextName = (TextView) itemView.findViewById(R.id.item_text_head);
            mTextType = (TextView) itemView.findViewById(R.id.item_text_type);
        }
    }
}
