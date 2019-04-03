package com.yirong.androidanimation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.yokeyword.fragmentation.SupportFragment
import android.graphics.drawable.AnimationDrawable
import com.yirong.androidanimation.R
import kotlinx.android.synthetic.main.fragment_tween.*


class PropertyFragment :SupportFragment(){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        iv_tween.setBackgroundResource(R.drawable.tween_anim);
        var animationDrawable:AnimationDrawable  = iv_tween.background as AnimationDrawable;
        animationDrawable.start();


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tween, container, false)

    }
}