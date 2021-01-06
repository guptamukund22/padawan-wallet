/*
 * Copyright 2020 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package com.goldenraven.padawanwallet.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.goldenraven.padawanwallet.databinding.FragmentWalletBinding

class WalletFragment : Fragment() {

    private lateinit var binding: FragmentWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentWalletBinding.inflate(inflater, container, false)
        val view: View = binding.root
        return view
    }
}
