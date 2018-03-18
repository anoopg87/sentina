package au.com.sentina.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import au.com.sentina.R
import au.com.sentina.databinding.FragmentPropertyDetailsBinding
import au.com.sentina.viewmodel.PropertyViewModel

class PropertyDetailsFragment:Fragment() {

    private var propertyDetailsBinding: FragmentPropertyDetailsBinding?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val propertyViewModel:PropertyViewModel?= activity?.let { ViewModelProviders.of(it).get(PropertyViewModel::class.java) }
        propertyViewModel?.getSelectedProperty()?.observe(this, Observer {
             propertyDetailsBinding?.viewModel=it
            propertyDetailsBinding?.executePendingBindings()
        })
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        propertyDetailsBinding=DataBindingUtil.inflate(inflater, LAYOUT,container,false)
        return propertyDetailsBinding?.root
    }
    companion object {
        private const val LAYOUT:Int= R.layout.fragment_property_details
    }
}