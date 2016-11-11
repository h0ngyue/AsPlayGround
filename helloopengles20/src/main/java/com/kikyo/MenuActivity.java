package com.kikyo;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.kikyo.helloopengles20.R;
import com.kikyo.textureview.TextureCamera;

import timber.log.Timber;


public class MenuActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Timber.plant(new Timber.DebugTree());
    }

    public void goTextureView(View v) {
        startActivity(new Intent(this, TextureCamera.class));
    }
}
