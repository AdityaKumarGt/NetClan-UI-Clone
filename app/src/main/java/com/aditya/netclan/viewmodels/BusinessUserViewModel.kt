package com.aditya.netclan.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aditya.netclan.model.BusinessUser
import com.aditya.netclan.repository.BusinessUserRepository

class BusinessUserViewModel (repository: BusinessUserRepository) : ViewModel()  {
    private val _userList = MutableLiveData<ArrayList<BusinessUser>>()

    init {
        // Initialize user list in the ViewModel by calling the repository
        _userList.value = repository.getUserList()
    }
    // Expose LiveData to the outside
    val userList: LiveData<ArrayList<BusinessUser>> get() = _userList

}

class ProvideBusinessUserViewModelFactory(
    private val repository : BusinessUserRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BusinessUserViewModel(repository) as T
    }
}

