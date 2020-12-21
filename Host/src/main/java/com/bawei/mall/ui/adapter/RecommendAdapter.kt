package com.bawei.mall.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bawei.base.ui.adapter.BaseRecyclerViewAdapter
import com.bawei.goods.data.protocol.Goods
import com.bawei.mall.R

/**
 *@author:zhangyue
 *@date:2020/12/2
 */
class RecommendAdapter(context: Context):BaseRecyclerViewAdapter<Goods,RecommendAdapter.ViewHolder>(context) {
    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        var goodsIconIv:ImageView
        var goodsDescTv:TextView
        var goodsPriceTv:TextView
        var goodsSalesStockTv:TextView
        init {
            goodsIconIv=view.findViewById(R.id.mGoodsIconIv)
            goodsDescTv=view.findViewById(R.id.mGoodsDescTv)
            goodsPriceTv=view.findViewById(R.id.mGoodsPriceTv)
            goodsSalesStockTv=view.findViewById(R.id.mGoodsSalesStockTv)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val goods = dataList.get(position)
        Glide.with(mContext).load(goods.goodsDefaultIcon).into(holder.goodsIconIv)
        holder.goodsDescTv.text=goods.goodsDesc
        holder.goodsPriceTv.text=goods.goodsDefaultPrice.toString()
        holder.goodsSalesStockTv.text=goods.goodsStockCount.toString()

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_goods_item, parent, false)
        return ViewHolder(inflate)
    }
}