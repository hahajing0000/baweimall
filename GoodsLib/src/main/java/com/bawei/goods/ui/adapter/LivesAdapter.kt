package com.bawei.goods.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bawei.base.ui.adapter.BaseRecyclerViewAdapter
import com.bawei.goods.R
import com.bawei.goods.data.protocol.LiveRealInfo
import kotlinx.android.synthetic.main.item_livelist.view.*

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class LivesAdapter(context:Context) : BaseRecyclerViewAdapter<LiveRealInfo, LivesAdapter.ViewHolder>(context) {

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){


        init {

        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val model:LiveRealInfo=dataList[position]
        Glide.with(mContext).load(model.imgpath).into(holder.itemView.mLiveListItemIv)
        holder.itemView.mLiveListItemTv.text=model.livedesc
        holder.itemView.mLiveListCountTv.text= (0..10000).random().toString()+" 人正在观看"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.item_livelist, parent, false)
        return ViewHolder(inflate)
    }
}