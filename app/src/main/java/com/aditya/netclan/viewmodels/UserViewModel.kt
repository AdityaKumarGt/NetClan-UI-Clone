package com.aditya.netclan.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aditya.netclan.model.User
import com.aditya.netclan.repository.UsersRepository

class UserViewModel(repository: UsersRepository) : ViewModel()  {
    private val _userList = MutableLiveData<ArrayList<User>>()

    init {
        // Initialize user list in the ViewModel by calling the repository
        _userList.value = repository.getUserList()
    }
    // Expose LiveData to the outside
    val userList: LiveData<ArrayList<User>> get() = _userList


}

class ProvideUsersViewModelFactory(
    private val repository : UsersRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}