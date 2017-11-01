package com.example.admin.basic.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.admin.basic.R;


/**
 * Created by admin on 2017/11/1.
 */

public class BottomNavigationView extends LinearLayout {

    private ImageView currentIv;

    public BottomNavigationView(Context context) {
        super(context);
        init(context, null);
    }

    public BottomNavigationView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }


    public BottomNavigationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setOrientation(HORIZONTAL);
        setBackgroundResource(R.color.color_white);
        setPadding((int) context.getResources().getDimension(R.dimen.dp_10), (int) context.getResources().getDimension(R.dimen.dp_5), (int) context.getResources().getDimension(R.dimen.dp_10), (int) context.getResources().getDimension(R.dimen.dp_5));
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomNavigationView);
        Drawable one_seletor = typedArray.getDrawable(R.styleable.BottomNavigationView_one_selector);
        Drawable all_seletor = typedArray.getDrawable(R.styleable.BottomNavigationView_all_selector);
        Drawable me_seletor = typedArray.getDrawable(R.styleable.BottomNavigationView_me_selector);
        typedArray.recycle();
        for (int i = 0; i < 3; i++) {
            final ImageView imageView = new ImageView(context);
            LayoutParams params = new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.weight = 1;
            params.gravity = Gravity.CENTER_HORIZONTAL;
            imageView.setLayoutParams(params);
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            if (i == 0) {
                imageView.setSelected(true);
                currentIv = imageView;
            }
            switch (i) {
                case 0:
                    imageView.setImageDrawable(one_seletor);
                    imageView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (currentIv != null) {
                                currentIv.setSelected(false);
                                currentIv = imageView;
                            }
                            imageView.setSelected(true);
                            if (onBottonNavigationClickListener != null) {
                                onBottonNavigationClickListener.onClick(0);
                            }
                        }
                    });
                    break;
                case 1:
                    imageView.setImageDrawable(all_seletor);
                    imageView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (currentIv != null) {
                                currentIv.setSelected(false);
                                currentIv = imageView;
                            }
                            imageView.setSelected(true);
                            if (onBottonNavigationClickListener != null) {
                                onBottonNavigationClickListener.onClick(1);
                            }
                        }
                    });

                    break;
                case 2:
                    imageView.setImageDrawable(me_seletor);
                    imageView.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (currentIv != null) {
                                currentIv.setSelected(false);
                                currentIv = imageView;
                            }
                            imageView.setSelected(true);
                            if (onBottonNavigationClickListener != null) {
                                onBottonNavigationClickListener.onClick(2);
                            }
                        }
                    });

                    break;
            }
            addView(imageView);
        }
    }


    public interface OnBottonNavigationClickListener {
        void onClick(int position);
    }

    private OnBottonNavigationClickListener onBottonNavigationClickListener;

    public void setOnBottonNavigationClickListener(OnBottonNavigationClickListener onBottonNavigationClickListener) {
        this.onBottonNavigationClickListener = onBottonNavigationClickListener;
    }
}
