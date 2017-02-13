package com.kikyo.asplayground;

import com.kikyo.asplayground.retrofit_demo.RetrofitTest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.Method;

import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    private boolean b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tvHello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                testAnnotation();
                RetrofitTest.test();
            }
        });

    }

    private void testAnnotation() {
        try {
            Class cls = Class.forName("com.kikyo.asplayground.App");
            for (Method method : cls.getMethods()) {
                MethodInfo methodInfo = method.getAnnotation(
                        MethodInfo.class);
                if (methodInfo != null) {
                    System.out.println("method name:" + method.getName());
                    System.out.println("method author:" + methodInfo.author());
                    System.out.println("method version:" + methodInfo.version());
                    System.out.println("method date:" + methodInfo.date());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
