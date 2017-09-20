package gjf.com.ems_java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import gjf.com.ems_java.view.ShowAllEmpViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button bn_showAllEmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bn_showAllEmp =findViewById(R.id.bn_showAllEmp);

        bn_showAllEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShowAllEmpViewActivity.class);
                startActivity(intent);
            }
        });


    }
}
