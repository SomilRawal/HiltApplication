package com.rawaldevs.hiltapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rawaldevs.hiltapplication.databinding.ActivityMainBinding
import com.rawaldevs.hiltapplication.util.NetworkResult
import com.rawaldevs.hiltapplication.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG: String by lazy { MainActivity::class.java.simpleName }
    private val binding: ActivityMainBinding? by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @Inject
    lateinit var viewModel: MainActivityViewModel

    private val adapter: UserAdapter? by lazy { UserAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding?.root)

        binding?.recyclerView?.adapter = adapter

        viewModel.userData.observe(this) {
            when (it) {
                is NetworkResult.Loading -> {
                    toast("Loading...")
                    Log.i(TAG, "User Data Loading...")
                }

                is NetworkResult.Success -> {
                    toast("Success Data fetched.")
                    Log.i(TAG, "User Data ${it.data}")
                    adapter?.asyncListDiffer?.submitList(it.data)
                }

                is NetworkResult.Failure -> {
                    toast("Failure fetching user data!")
                    Log.i(TAG, "Error fetching User Data ${it.throwable?.message}")
                }
            }
        }

        viewModel.getUserData()
    }

    private fun toast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }

}