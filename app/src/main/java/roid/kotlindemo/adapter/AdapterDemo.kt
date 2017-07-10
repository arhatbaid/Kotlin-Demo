package roid.kotlindemo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import roid.kotlindemo.R

/**
 * Created by abc on 6/30/2017.
 */


class AdapterDemo(context: Context, arrData: ArrayList<String>, onItemClickListener: OnItemClickListener) : RecyclerView.Adapter<AdapterDemo.ViewHolder>() {

    private var arrayData: ArrayList<String>? = ArrayList()
    var mContext: Context? = null
    private var layoutInflator: LayoutInflater? = null
    private var onItemClickListener: OnItemClickListener? = null

    init {
        this.arrayData = arrData;
        this.mContext = context;
        this.onItemClickListener = onItemClickListener;
        layoutInflator = LayoutInflater.from(context)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder == null) return

        holder.lblTitle?.text = "Cell Position is " + position
        holder.btnSubmit?.tag = (position)
        holder.itemView?.tag = (position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        var view = layoutInflator?.inflate(R.layout.cell_demo, parent, false)
        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int = arrayData!!.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var lblTitle: TextView? = null
        var btnSubmit: Button? = null

        init {
            lblTitle = itemView.findViewById(R.id.lblTitle) as TextView
            btnSubmit = itemView.findViewById(R.id.btnSubmit) as Button

            btnSubmit!!.setOnClickListener(this)
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = v?.tag
            if (v == itemView) {
                onItemClickListener?.onItemClick(position as Int)

            } else if (v == btnSubmit) {
                onItemClickListener?.onButtonClick(position as Int)

            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onButtonClick(position: Int)
    }
}
