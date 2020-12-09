package com.gunawan.multipleimages.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gunawan.multipleimages.R
import com.gunawan.multipleimages.databinding.ActivityMainBinding
import com.gunawan.multipleimages.ui.adapter.MainAdapter
import com.gunawan.multipleimages.viewmodel.MultipleImagesViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter
    private val multipleImagesViewModel by viewModel<MultipleImagesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding                                         = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        multipleImagesViewModel.ldRespMultipleImages    = MutableLiveData()
        multipleImagesViewModel.ldMsg                   = MutableLiveData()
        binding.pbMain.visibility                       = View.VISIBLE
        binding.rvMain.visibility                       = View.GONE

        multipleImagesViewModel.getMultipleImages()
        getListData()
        getMsg()

        binding.btnAdd.setOnClickListener {
            var intent = Intent(this, AddMultipleImagesActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListData() {
        multipleImagesViewModel.ldRespMultipleImages.observe(this, Observer {
            binding.pbMain.visibility = View.GONE
            binding.rvMain.visibility = View.VISIBLE
            if (!it.isNullOrEmpty()) {
                binding.rvMain.setHasFixedSize(true)
                binding.rvMain.layoutManager = LinearLayoutManager(this)
                adapter = MainAdapter(it)
                adapter.notifyDataSetChanged()
                binding.rvMain.adapter = adapter
            }

        })
    }

    @SuppressLint("ShowToast")
    private fun getMsg() {
        multipleImagesViewModel.ldMsg.observe(this, Observer {
            binding.pbMain.visibility = View.GONE
            binding.rvMain.visibility = View.GONE
            if (!it.isNullOrBlank()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT)
            }
        })
    }

    override fun onRestart() {
        super.onRestart()
        multipleImagesViewModel.ldRespMultipleImages    = MutableLiveData()
        multipleImagesViewModel.ldMsg                   = MutableLiveData()
        binding.pbMain.visibility                       = View.VISIBLE
        binding.rvMain.visibility                       = View.GONE
        multipleImagesViewModel.getMultipleImages()
        getListData()
        getMsg()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i = Intent(Intent.ACTION_MAIN)
        i.addCategory(Intent.CATEGORY_HOME)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(i)
        finish()
    }

}