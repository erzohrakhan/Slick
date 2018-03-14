package com.mrezanasirloo.slick.sample.cutstomview.dagger;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mrezanasirloo.slick.OnDestroyListener;
import com.mrezanasirloo.slick.Presenter;
import com.mrezanasirloo.slick.sample.App;
import com.mrezanasirloo.slick.sample.R;

import javax.inject.Inject;
import javax.inject.Provider;

/**
 * @author : M.Reza.Nasirloo@gmail.com
 *         Created on: 2017-03-09
 */

public class DaggerCustomView extends LinearLayout implements ExampleView, OnDestroyListener {

    @Inject
    Provider<ViewPresenter> provider;
    @Presenter
    ViewPresenter presenter;

    public DaggerCustomView(Context context) {
        super(context);
    }

    public DaggerCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DaggerCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        System.out.println("DaggerCustomView.onAttachedToWindow");
        super.onAttachedToWindow();
        App.getDaggerComponent(getContext()).inject(this);
        ViewPresenter_Slick.bind(this);
        ViewPresenter_Slick.onAttach(this);

        final TextView textView = (TextView) findViewById(R.id.textView_custom_view);
        textView.setText(presenter.getData());
    }

    @Override
    protected void onDetachedFromWindow() {
        System.out.println("DaggerCustomView.onDetachedFromWindow");
        super.onDetachedFromWindow();
        ViewPresenter_Slick.onDetach(this);
    }

    @Override
    public void onDestroy() {
        System.out.println("DaggerCustomView.onDestroy");
        ViewPresenter_Slick.onDestroy(this);
    }
}