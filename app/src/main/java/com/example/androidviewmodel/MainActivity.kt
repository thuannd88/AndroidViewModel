package com.example.androidviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var point: Int=0
    val viewModel: ScoreViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)


        val binding: ActivityMainBinding= DataBindingUtil.setContentView(this,
            R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner=this

        var btn = findViewById<Button>(R.id.btnIncrease)
        var txt = findViewById<TextView>(R.id.txtPoint)
//        viewModel.point.observe(this,{
//            txt.text = viewModel.point.toString()
//        })


//        btn.setOnClickListener {
//            point++
//            txt.text=point.toString()
//        }
        btn.setOnClickListener {
            viewModel.incrementScore()
 //           txt.text = viewModel.point.toString()
        }
    }
}
class ScoreViewModel : ViewModel() {
    var point = MutableLiveData<Int>(0)
    fun incrementScore() {
      point.value=point.value!!+1
    }
}
