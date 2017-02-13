package com.kikyo.textureview;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.ScaleAnimation;

import com.kikyo.helloopengles20.R;

import java.io.IOException;

import timber.log.Timber;


public class TextureCamera extends FragmentActivity implements TextureView.SurfaceTextureListener {
    private Camera mCamera;
    private TextureView mTextureView;
    private int mInitWidth, mInitHeight;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texture_camera);
        mTextureView = (TextureView) findViewById(R.id.mTxv);
        mTextureView.setSurfaceTextureListener(this);

        findViewById(R.id.mBtnOpenCamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera(mTextureView.getSurfaceTexture());
            }
        });

        findViewById(R.id.mBtnZoomIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup.LayoutParams layoutParams = mTextureView.getLayoutParams();
                layoutParams.width = mInitWidth;
                layoutParams.height = mInitHeight;
                mTextureView.setLayoutParams(layoutParams);
            }
        });

        findViewById(R.id.mBtnZoomOut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ViewGroup.LayoutParams layoutParams = mTextureView.getLayoutParams();
//                layoutParams.width = 400;
//                layoutParams.height = 400;
//                mTextureView.setLayoutParams(layoutParams);
                ScaleAnimation sa = new ScaleAnimation(1.0f, 0.5f, 1.0f, 0.5f);
                sa.setFillAfter(true);
                sa.setDuration(1000);
                mTextureView.startAnimation(sa);
//                mTextureView.startAnimation(AnimationUtils.loadAnimation(TextureCamera.this, R.anim.rotate_anim));
            }
        });

        mTextureView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mInitWidth = mTextureView.getWidth();
                mInitHeight = mTextureView.getHeight();
                mTextureView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
        Timber.d("onSurfaceTextureAvailable, width:%d, height:%d", width, height);
//        openCamera(surface);
    }

    private void openCamera(SurfaceTexture surface) {
        mCamera = Camera.open();

        try {
            mCamera.setPreviewTexture(surface);
            mCamera.startPreview();
        } catch (IOException ioe) {
            // Something bad happened
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
        Timber.d("onSurfaceTextureAvailable, width:%d, height:%d", width, height);
        // Ignored, Camera does all the work for us
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        // Invoked every time there's a new Camera preview frame
    }

}
