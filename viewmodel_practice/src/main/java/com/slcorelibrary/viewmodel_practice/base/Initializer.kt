package com.slcorelibrary.viewmodel_practice.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding
import java.lang.Exception
import java.lang.reflect.ParameterizedType

class Initializer<VB : ViewBinding, VM : ViewModel>(private val any: Any) {
    private lateinit var classOfViewModel: Class<VM>
    private lateinit var classOfViewBinding: Class<VB>

    init {
        getParameterizedTypeList().forEach { parameterizedType ->
            parameterizedType.actualTypeArguments.forEach {
                try {
                    if (it is Class<*>) {
                        if (ViewModel::class.java.isAssignableFrom(it)) {
                            classOfViewModel = (it as Class<VM>)
                        } else if (ViewBinding::class.java.isAssignableFrom(it)) {
                            classOfViewBinding = (it as Class<VB>)
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun initViewModel(owner: ViewModelStoreOwner): VM {
        return ViewModelProvider(owner)[classOfViewModel]
    }

    fun initViewBinding(inflater: LayoutInflater): VB {
        var method = classOfViewBinding.getMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null, inflater) as VB
    }

    fun initViewBinding(inflater: LayoutInflater, parent: ViewGroup?, attachToParent: Boolean): VB {
        var method = classOfViewBinding.getMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null, inflater, parent, attachToParent) as VB
    }

    private fun getParameterizedTypeList(): MutableList<ParameterizedType> {
        var genericParameterizedType = mutableListOf<ParameterizedType>()
        var genericSuperclass = any.javaClass.genericSuperclass
        var superClass = any.javaClass.superclass
        while (superClass != null) {
            if (genericSuperclass is ParameterizedType) {
                genericParameterizedType.add(genericSuperclass)
            }
            genericSuperclass = superClass.genericSuperclass
            superClass = superClass.superclass
        }
        return genericParameterizedType
    }
}