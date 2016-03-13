package net.fktan5.hoge001;

import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KanListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setVisibility(View.GONE);
        setSupportActionBar(toolbar);

        List<SampleModel> listSampleModel = new ArrayList<>();
        listSampleModel.add(new SampleModel("金剛", "戦艦"));
        listSampleModel.add(new SampleModel("霧島", "戦艦"));
        listSampleModel.add(new SampleModel("比叡", "戦艦"));
        listSampleModel.add(new SampleModel("榛名", "戦艦"));
        listSampleModel.add(new SampleModel("古鷹", "重巡"));
        listSampleModel.add(new SampleModel("加古", "重巡"));
        listSampleModel.add(new SampleModel("阿武隈", "軽巡"));
        MyAdapter adapter1 = new MyAdapter(this, R.layout.item_recycleview, listSampleModel);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ToneGenerator toneGenerator
                        = new ToneGenerator(AudioManager.STREAM_SYSTEM, ToneGenerator.MAX_VOLUME);
                toneGenerator.startTone(ToneGenerator.TONE_PROP_BEEP);

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "ひええええ", Toast.LENGTH_LONG).show();
                return false;
            }
        });
        listView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "にゃしぃ", Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    public class MyAdapter extends ArrayAdapter<SampleModel> {
        private LayoutInflater mLayoutInflater;
        private List<SampleModel> modelList;
        private int mResId;

        public MyAdapter(Context context, int resource, List<SampleModel> objects) {
            super(context, resource, objects);
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            modelList = objects;
            mResId = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view ;
            if (convertView != null){
                view = convertView;
            } else {
                view = mLayoutInflater.inflate(mResId, null);
            }

            SampleModel model = modelList.get(position);
            ((TextView)view.findViewById(R.id.item_text_type)).setText(model.getType());
            ((TextView)view.findViewById(R.id.item_text_head)).setText(model.getName());

            return view;
        }
    }
}
