package com.catata.dialogfragmentexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.catata.dialogfragmentexample.databinding.FragmentLoginDialogBinding
import com.catata.dialogfragmentexample.model.Login


typealias DialogResult = (userData:Login)->Unit;

class LoginDialogFragment(val dialogResult: DialogResult) : DialogFragment() {
    private lateinit var binding: FragmentLoginDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentLoginDialogBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding.btnCancel.setOnClickListener{
            dismiss()
        }

        binding.btnLogin.setOnClickListener {
            dialogResult(Login(
                binding.etUser.text.toString(),
                binding.etPass.text.toString()))
            dismiss()
        }

        return binding.root


    }

    override fun onResume() {
        super.onResume()
        /*val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ConstraintLayout.LayoutParams.MATCH_PARENT
        params.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams*/
    }


}