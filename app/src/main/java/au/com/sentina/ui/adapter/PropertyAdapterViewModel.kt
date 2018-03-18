package au.com.sentina.ui.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.view.View
import au.com.sentina.data.Data


class PropertyAdapterViewModel(itemView: View): BindingViewHolder<Data>(itemView) {
    override fun bind(item: Data, variable: Int, onClickListener: OnClickListener<Data>?) {
        val dataBinding: ViewDataBinding?= DataBindingUtil.bind(itemView)
        dataBinding?.setVariable(variable,item)
        dataBinding?.root?.setOnClickListener({ onClickListener?.onClick(item,adapterPosition) })

    }
}