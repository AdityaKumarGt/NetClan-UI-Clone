package com.aditya.netclan.ui.child_fragments.explore_fragments

import android.animation.ValueAnimator
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aditya.netclan.adapters.UsersAdapter
import com.aditya.netclan.databinding.FragmentPersonalBinding
import com.aditya.netclan.viewmodels.UserViewModel
import com.aditya.netclan.repository.UsersRepository
import androidx.lifecycle.Observer
import com.aditya.netclan.R
import com.aditya.netclan.utils.bottom_sheets.PersonalBottomSheetFragment
import com.aditya.netclan.viewmodels.ProvideUsersViewModelFactory


class PersonalFragment : Fragment() {
    private var _binding: FragmentPersonalBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserViewModel
    private lateinit var usersAdapter: UsersAdapter

    private lateinit var rootView: View

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_open_anim)}
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.rotate_close_anim)}
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.from_bottom_anim)}
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(requireContext(), R.anim.to_bottom_anim)}
    private var clicked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPersonalBinding.inflate(inflater, container, false)
        val root: View = binding.root



        // Initialize ViewModel with a UsersRepository instance
        val repository = UsersRepository()
        viewModel = ViewModelProvider(this, ProvideUsersViewModelFactory(repository)).get(
            UserViewModel::class.java)

        // Initialize RecyclerView and Adapter
        usersAdapter = UsersAdapter(requireContext(), viewModel.userList.value.orEmpty())

        // Observe changes in the userList from the ViewModel
        viewModel.userList.observe(viewLifecycleOwner, Observer { userList ->
            userList?.let {
                // Update the adapter when the userList changes
                usersAdapter.submitList(userList)
            }
        })
        // Set the adapter to the RecyclerView
        binding.userRecylerView.adapter = usersAdapter




        // Add TextWatcher to EditText
        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed for filtering
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Not needed for filtering
            }

            override fun afterTextChanged(s: Editable?) {
                binding.cut.visibility = if (s.isNullOrBlank()) View.GONE else View.VISIBLE
                usersAdapter.filter(s.toString())
            }
        })

        // Set initial visibility state based on the initial text
        binding.cut.visibility = if (binding.search.text.isNullOrBlank()) View.GONE else View.VISIBLE

        binding.cut.setOnClickListener {
            // Clear text and hide cut icon when clicked
            binding.search.setText("")
            binding.cut.visibility = View.GONE
        }

        binding.filter.setOnClickListener {
            val bottomSheetFragment = PersonalBottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, bottomSheetFragment.tag)
        }


        rootView = binding.parentLinearLayout
        binding.addIcon.setOnClickListener {
            onAddButtonClicked()
            toggleFade()
        }

        return root
    }


    private fun toggleFade() {
        val fadeDuration = 100L // Adjust the duration as needed

        val fadeAnimator = ValueAnimator.ofFloat(
            if (rootView.alpha == 1.0f) 1.0f else 0.1f,
            if (rootView.alpha == 1.0f) 0.1f else 1.0f
        )
        fadeAnimator.duration = fadeDuration
        fadeAnimator.addUpdateListener { valueAnimator ->
            rootView.alpha = valueAnimator.animatedValue as Float
        }
        fadeAnimator.start()
    }


    private fun onAddButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setVisibility(clicked: Boolean) {
        if(!clicked){
            binding.datingIcon.visibility = View.VISIBLE
            binding.datingTv.visibility = View.VISIBLE

            binding.matrimonyIcon.visibility = View.VISIBLE
            binding.matrimonyTv.visibility = View.VISIBLE

            binding.buySellRentIcon.visibility = View.VISIBLE
            binding.buySellRentTv.visibility = View.VISIBLE

            binding.businessCardsIcon.visibility = View.VISIBLE
            binding.businessCardTv.visibility = View.VISIBLE

            binding.groupsIcon.visibility = View.VISIBLE
            binding.groupsTv.visibility = View.VISIBLE

            binding.jobsIcon.visibility = View.VISIBLE
            binding.jobsTv.visibility = View.VISIBLE

            binding.notesIcon.visibility = View.VISIBLE
            binding.notesTv.visibility = View.VISIBLE


        }else{
            binding.datingIcon.visibility = View.INVISIBLE
            binding.datingTv.visibility = View.INVISIBLE

            binding.matrimonyIcon.visibility = View.INVISIBLE
            binding.matrimonyTv.visibility = View.INVISIBLE

            binding.buySellRentIcon.visibility = View.INVISIBLE
            binding.buySellRentTv.visibility = View.INVISIBLE

            binding.businessCardsIcon.visibility = View.INVISIBLE
            binding.businessCardTv.visibility = View.INVISIBLE

            binding.groupsIcon.visibility = View.INVISIBLE
            binding.groupsTv.visibility = View.INVISIBLE

            binding.jobsIcon.visibility = View.INVISIBLE
            binding.jobsTv.visibility = View.INVISIBLE

            binding.notesIcon.visibility = View.INVISIBLE
            binding.notesTv.visibility = View.INVISIBLE
        }
    }

    private fun setAnimation(clicked: Boolean) {
        if(!clicked){
            binding.addIcon.startAnimation(rotateOpen)

            binding.datingIcon.startAnimation(fromBottom)
            binding.datingTv.startAnimation(fromBottom)

            binding.matrimonyIcon.startAnimation(fromBottom)
            binding.matrimonyTv.startAnimation(fromBottom)

            binding.buySellRentIcon.startAnimation(fromBottom)
            binding.buySellRentTv.startAnimation(fromBottom)

            binding.businessCardsIcon.startAnimation(fromBottom)
            binding.businessCardTv.startAnimation(fromBottom)

            binding.groupsIcon.startAnimation(fromBottom)
            binding.groupsTv.startAnimation(fromBottom)

            binding.jobsIcon.startAnimation(fromBottom)
            binding.jobsTv.startAnimation(fromBottom)

            binding.notesIcon.startAnimation(fromBottom)
            binding.notesTv.startAnimation(fromBottom)

        }else{
            binding.addIcon.startAnimation(rotateClose)

            binding.datingIcon.startAnimation(toBottom)
            binding.datingTv.startAnimation(toBottom)

            binding.matrimonyIcon.startAnimation(toBottom)
            binding.matrimonyTv.startAnimation(toBottom)

            binding.buySellRentIcon.startAnimation(toBottom)
            binding.buySellRentTv.startAnimation(toBottom)

            binding.businessCardsIcon.startAnimation(toBottom)
            binding.businessCardTv.startAnimation(toBottom)

            binding.groupsIcon.startAnimation(toBottom)
            binding.groupsTv.startAnimation(toBottom)

            binding.jobsIcon.startAnimation(toBottom)
            binding.jobsTv.startAnimation(toBottom)

            binding.notesIcon.startAnimation(toBottom)
            binding.notesTv.startAnimation(toBottom)
        }
    }


}