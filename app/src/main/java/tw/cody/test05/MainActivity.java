package tw.cody.test05;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private ListView item;
    private SimpleAdapter adapter;
    private LinkedList<HashMap<String,String>> list;
    private String[] from = {"title","message","detail"};
    private int[] to = {R.id.title,R.id.message,R.id.detail};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        item = findViewById(R.id.item);

        function();

    }


    public void add(View view) {
        HashMap<String,String> data = new HashMap<>();
        int rand = ((int)(Math.random()*49+100));
        Log.v("cody","rand:" + rand);
        data.put(from[0],"title" + rand);
        data.put(from[1],"message" + rand);
        data.put("detail","detail" + rand);
        list.add(data);

        adapter.notifyDataSetChanged();
    }



    private  void function() {

        list = new LinkedList<>();
        for (int i=0; i<10; i++) {
            HashMap<String,String> data = new HashMap<>();
            int rand = ((int)(Math.random()*49+1));
            Log.v("cody","rand:" + rand);
            data.put(from[0],"title" + rand);
            data.put(from[1],"message" + rand);
            data.put("detail","detail" + rand);
            list.add(data);
        }

        adapter = new SimpleAdapter(this,list,R.layout.activity_item,from,to);
        item.setAdapter(adapter);


        item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StringBuffer sb = new StringBuffer();
                sb.append("Title:" + list.get(position).get("title") + "\n");
                sb.append("Message:" + list.get(position).get("message") + "\n");
                sb.append("Detail:"+list.get(position).get("detail") + "\n");
                diaLog(sb.toString());
            }
        });

    }


    private void diaLog(String mesg) {
        new AlertDialog.Builder(this)
                .setMessage(mesg)
                .create()
                .show();
    }
}