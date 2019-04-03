package com.yirong.androidanimation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.yirong.androidanimation.fragment.PropertyFragment
import com.yirong.androidanimation.fragment.TweenFragment
import kotlinx.android.synthetic.main.activity_second.*
import me.yokeyword.fragmentation.ISupportFragment
import me.yokeyword.fragmentation.SupportActivity


@SuppressLint("RestrictedApi")
class SecondActivity : SupportActivity() {
    var classLists = arrayOf(TweenFragment::class.java, PropertyFragment::class.java)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        initData()

    }


    private fun initData() {
        val intent = intent
        val position = intent.getIntExtra("tag",0)
        val title = intent.getStringExtra("title")
        Log.i("extra",position.toString()+title)
        tv_title.text = title

        loadFragment(classLists[position])



    }

    private fun <T : ISupportFragment> loadFragment(fragmentClass: Class<T> ){
        var manager = fragmentManager
        if(findFragment(fragmentClass)==null){
            loadRootFragment(R.id.fragment,fragmentClass.newInstance())
        }
    }

}
