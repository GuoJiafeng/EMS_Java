package gjf.com.ems_java.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import gjf.com.ems_java.R;
import gjf.com.ems_java.adapter.ShowAllEmpViewAdapter;
import gjf.com.ems_java.entity.Emp;

/**
 * Created by BlackBeard丶 on 2017/9/18.
 */

public class ShowAllEmpViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Emp> empList;
    private ShowAllEmpViewAdapter empViewAdapter;
    private String result = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showallemp_view);
        new getAllEmp().start();
        recyclerView = findViewById(R.id.recycleview_showallemp);
    }
    //显示列表
    public void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        empViewAdapter = new ShowAllEmpViewAdapter(getApplicationContext(), empList);
        recyclerView.setAdapter(empViewAdapter);
    }
    //开启子线程进行网络操作
    public class getAllEmp extends Thread {
        @Override
        public void run() {
            //获取网址
            String path = "http://192.168.43.122:8989/ShowAllEmpAction?pageNum=1";
            try {
                //声明访问的路径
                URL url = new URL(path);
                //通过路径和获得一个连接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //获取从服务返回的状态信息

                int code = conn.getResponseCode();
                if (code == 200) {
                    InputStream in = conn.getInputStream();
                    InputStreamReader is = new InputStreamReader(in, "UTF-8");
                    int tmp;
                    while ((tmp = is.read()) != -1) {
                        result += (char) tmp;
                    }
                    System.out.println(result);
                    Log.d("ggg", result);
                    Message msg = new Message();
                    msg.what = 0x123;
                    handler.sendMessage(msg);
                } else {
                    // Toast.makeText(getApplicationContext(),"请求失败",Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //使用gson将服务端收到的json转换成对象
    public List<Emp> fromJsontoObject(String json) {
        Gson gson = new Gson();
        List<Emp> emps;
        emps = gson.fromJson(json, new TypeToken<List<Emp>>() {
        }.getType());
        return emps;
    }
    //使用handler
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x123) {
                empList = new ArrayList<>();
                empList.clear();
                empList.addAll(fromJsontoObject(result));
                init();
            }
        }
    };

}
