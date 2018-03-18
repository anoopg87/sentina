package au.com.sentina.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import au.com.sentina.data.Data
import au.com.sentina.data.Properties
import au.com.sentina.repository.PropertyRepository
import au.com.sentina.webservice.APICallBacks


class PropertyViewModel: ViewModel() {
    private var properties:MutableLiveData<Properties>?=null
    private var selectedProperty:MutableLiveData<Data> =MutableLiveData()
    private fun loadProperties(){
        PropertyRepository(object :APICallBacks<Properties>{
            override fun setError(message: String) {
            }
            override fun setResult(t: Properties) {
                android.util.Log.e(PropertyViewModel::class.simpleName,t.toString())
                properties?.value=t
            }}).getProperties()
    }

    fun select(data: Data){
        selectedProperty.value=data
    }

    fun getProperties():MutableLiveData<Properties>?{
        if(null==properties){
            properties= MutableLiveData()
            loadProperties()
        }
        return properties
    }

    fun getSelectedProperty(): MutableLiveData<Data>?{
        return selectedProperty
    }


}