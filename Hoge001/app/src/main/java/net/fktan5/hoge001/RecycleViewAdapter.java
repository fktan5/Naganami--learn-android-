package net.fktan5.hoge001;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter {

    private LayoutInflater mLayoutInflater;
    private List<SampleModel> mModels = new ArrayList<>();

    public RecycleViewAdapter(Context context){
        mLayoutInflater = LayoutInflater.from(context);
        for (int i = 0; i < 15; i++){
            SampleModel model = new SampleModel("にゃしぃ", "睦月型" + i + "番艦");
            mModels.add(model);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecycleViewHolder(
                mLayoutInflater.inflate(R.layout.item_recycleview, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RecycleViewHolder)holder).mTextName.setText(mModels.get(position).getName());
        ((RecycleViewHolder)holder).mTextType.setText(mModels.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return mModels.size();
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
