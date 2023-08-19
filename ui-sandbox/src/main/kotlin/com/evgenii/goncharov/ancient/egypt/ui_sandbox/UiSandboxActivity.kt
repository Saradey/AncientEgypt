package com.evgenii.goncharov.ancient.egypt.ui_sandbox

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.evgenii.goncharov.ancient.egypt.ui_sandbox.databinding.ActivityUiSandboxBinding

class UiSandboxActivity : AppCompatActivity() {

    private val binding: ActivityUiSandboxBinding by viewBinding(
        ActivityUiSandboxBinding::bind
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_sandbox)
        binding.txvSample.setOnClickListener {}
        binding.txvSkip.setOnClickListener {}
    }
}