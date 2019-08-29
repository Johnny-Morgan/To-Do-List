package dev.johnmorgan.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final List<String> list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listView);
        final TextAdapter adapter = new TextAdapter();

        adapter.setData(list);
        listView.setAdapter(adapter);
        
    }

    class TextAdapter extends BaseAdapter {

        List<String> list = new ArrayList<>();

        void setData(List<String> mList) {
            list.clear();
            list.addAll(mList);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = (LayoutInflater)
                    MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.item, viewGroup, false);
            TextView textView = findViewById(R.id.task);
            textView.setText(list.get(i));
            return rowView;
        }
    }
}
