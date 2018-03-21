package au.com.sentina.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import au.com.sentina.data.Data
import au.com.sentina.data.Properties
import au.com.sentina.repository.PropertyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class PropertyViewModel : ViewModel() {
    private var properties: MutableLiveData<Properties>? = null
    private var selectedProperty: MutableLiveData<Data> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private var propertyRepository: PropertyRepository = PropertyRepository()
    private fun loadProperties() {
        compositeDisposable.add(propertyRepository.getProperties()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(
                        {
                            properties?.value = it
                        },
                        {

                        }))
    }

    fun select(data: Data) {
        selectedProperty.value = data
    }

    fun getProperties(): MutableLiveData<Properties>? {
        if (null == properties) {
            properties = MutableLiveData()
            loadProperties()
        }
        return properties
    }

    fun getSelectedProperty(): MutableLiveData<Data>? {
        return selectedProperty
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }

}