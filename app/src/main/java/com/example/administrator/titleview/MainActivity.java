package com.example.administrator.titleview;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jarek.library.PopMenuMore;
import com.jarek.library.PopMenuMoreItem;
import com.jarek.library.TitleView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TitleView titleView;
    private ImageView  setting;

    private static final int OPTION = 0;
    private static final int SETTING = 1;

    private PopMenuMore mMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleView = (TitleView) findViewById(R.id.title);
        TextView back=titleView.getLeftBackTextTv();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"我是返回！",Toast.LENGTH_LONG).show();
            }
        });
        initMenu();
        setting = titleView.getRightImageIv();
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMenu.showAsDropDown(setting,0,-50);
            }
        });
    }

    private void initMenu() {
        mMenu = new PopMenuMore(this);
        // mMenu.setCorner(R.mipmap.demand_icon_location);
        // mMenu.setBackgroundColor(Color.parseColor("#ff8800"));
        ArrayList<PopMenuMoreItem> items = new ArrayList<>();
        items.add(new PopMenuMoreItem(OPTION, "选项"));
        items.add(new PopMenuMoreItem(SETTING, "设置"));


        mMenu.addItems(items);
        mMenu.setOnItemSelectedListener(new PopMenuMore.OnItemSelectedListener() {
            @Override
            public void selected(View view, PopMenuMoreItem item, int position) {
                switch (item.id) {
                    case OPTION:
                        Toast.makeText(MainActivity.this,"我是选项！",Toast.LENGTH_LONG).show();
                        break;

                    case SETTING:
                        Toast.makeText(MainActivity.this,"我是设置！",Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }
}
