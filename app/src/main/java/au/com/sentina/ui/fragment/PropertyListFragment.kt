package au.com.sentina.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.sentina.R
import au.com.sentina.data.Data
import au.com.sentina.data.Properties
import au.com.sentina.ui.adapter.OnClickListener
import au.com.sentina.ui.adapter.PropertyAdapter
import au.com.sentina.viewmodel.PropertyViewModel
import kotlinx.android.synthetic.main.fragment_property_list.*

class PropertyListFragment: Fragment() {

    private var propertyViewModel: PropertyViewModel?=null
    private var layoutSavedState: Parcelable?=null

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(LAYOUT_SAVED_STATE,propertyList?.layoutManager?.onSaveInstanceState())
        super.onSaveInstanceState(outState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        layoutSavedState=savedInstanceState?.getParcelable(LAYOUT_SAVED_STATE)
        super.onActivityCreated(savedInstanceState)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        propertyViewModel= activity?.let { ViewModelProviders.of(it).get(PropertyViewModel::class.java) }
        propertyViewModel?.getProperties()?.observe(this, Observer {
            setupPropertyList(it)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(LAYOUT,container,false)
    }

    private fun setupPropertyList(it: Properties?) {
        if(null!=it) {
            val adapter = PropertyAdapter(it.data)
            adapter.onClickListener= object : OnClickListener<Data> {
                override fun onClick(d: Data, pos: Int) {
                    propertyViewModel?.select(d)
                }
            }
            propertyList.layoutManager=LinearLayoutManager(this.activity)
            propertyList.setHasFixedSize(true)
            propertyList.setItemViewCacheSize(20)
            propertyList.isDrawingCacheEnabled = true
            propertyList.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

            propertyList.adapter=adapter
            if(null!=layoutSavedState) {
                propertyList.layoutManager.onRestoreInstanceState(layoutSavedState)
            }
        }
    }

    companion object {
        private const val LAYOUT:Int= R.layout.fragment_property_list
        private const val LAYOUT_SAVED_STATE="layoutSavedState"
    }
}
