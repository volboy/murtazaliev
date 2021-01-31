package com.murtazaliev.labtinkoff.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.murtazaliev.labtinkoff.R
import com.murtazaliev.labtinkoff.`interface`.RetrofitServieces
import com.murtazaliev.labtinkoff.common.Common
import com.murtazaliev.labtinkoff.model.Article
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    lateinit var mService: RetrofitServieces
    lateinit var imageView: ImageView
    lateinit var btnLoad: Button
    lateinit var description: TextView
    lateinit var tabNumber: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        imageView = root.findViewById(R.id.imageView)
        btnLoad = root.findViewById(R.id.btnLoad)
        description = root.findViewById(R.id.txtDescription)
        tabNumber=root.findViewById(R.id.tabNumber)
        btnLoad.setOnClickListener {
            getArticle(this)
        }

        mService = Common.retrofitService
        pageViewModel.text.observe(this, Observer<String> {
            tabNumber.text=it
            var i=it.toInt()
            if (i == 1) {
                //как то передать адрес раздела LATEST
            } else if (i == 2) {
                //как то передать адрес раздела HOT
            } else {
                //как то передать адрес раздела TOP
            }
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArticle(this)

    }

    private fun getArticle(context: PlaceholderFragment) {
        mService.getArticleList().enqueue(object : Callback<Article> {
            override fun onFailure(call: Call<Article>, t: Throwable) {
                Log.i("onFailure", t.message.toString())
            }

            override fun onResponse(call: Call<Article>, response: Response<Article>) {
                description.text = response.body()?.description
                // Загружаем картинку
                Glide
                    .with(context)
                    .load(response.body()?.gifURL)
                    .into(imageView);
            }
        })
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}