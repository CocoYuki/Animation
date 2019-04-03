package com.yirong.androidanimation.fragment

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import me.yokeyword.fragmentation.SupportFragment
import com.yirong.androidanimation.R
import kotlinx.android.synthetic.main.fragment_tween.*


class TweenFragment :SupportFragment(){
    private var animationDrawable= AnimationDrawable()
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initLoopTween()
        initGroupTween()

    }

    private fun initGroupTween() {

        btn_group.setOnClickListener{
            iv_tween.setBackgroundResource(R.mipmap.strawberry)
            val anim = AnimationUtils.loadAnimation(context,R.anim.tween)
            iv_tween.startAnimation(anim)
        }
    }

    private fun initLoopTween() {
        val lists = arrayOf(R.mipmap.shuzi0,R.mipmap.shuzi1,R.mipmap.shuzi2,R.mipmap.shuzi3)
        for (i in 1..lists.size) {
            val id = lists[i - 1]
            val drawable = resources.getDrawable(id)
            animationDrawable.addFrame(drawable, 1000)
        }
        animationDrawable.isOneShot = false

        btn_tween.tag = true

        btn_tween.setOnClickListener{
            var flag = btn_tween.tag as Boolean
            if(flag){
                btn_tween.text = "停止"
                btn_tween.tag = false
                iv_tween.background = animationDrawable
                animationDrawable.start()
            }else {
                btn_tween.text = "循环补间动画"
                btn_tween.tag = true
                animationDrawable.stop()
            }
        }

        btn_tween_xml.setOnClickListener {
            iv_tween.background = null;

            iv_tween.setBackgroundResource(R.drawable.tween_anim);
            animationDrawable = iv_tween.background as AnimationDrawable;
            animationDrawable.start();

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tween, container, false)
    }
}