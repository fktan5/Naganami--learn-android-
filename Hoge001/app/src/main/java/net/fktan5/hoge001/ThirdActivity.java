package net.fktan5.hoge001;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThirdActivity extends AppCompatActivity {
    private String[] strings;
    private DrawerLayout drawerLayout;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        strings = getResources().getStringArray(R.array.kongou_ships);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);

        listView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, strings));
    }
}
