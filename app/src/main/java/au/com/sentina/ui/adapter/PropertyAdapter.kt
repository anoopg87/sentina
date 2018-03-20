package au.com.sentina.ui.adapter

import android.view.View
import au.com.sentina.BR
import au.com.sentina.R
import au.com.sentina.data.Data


class PropertyAdapter(properties: List<Data>) : BindingRecyclerViewAdapter<Data, PropertyAdapterViewModel>(properties) {
    override val layoutId: Int
        get() = R.layout.property_item

    override fun createViewHolder(view: View?): PropertyAdapterViewModel = PropertyAdapterViewModel(view!!)

    override val variable: Int
        get() = BR.viewModel
}