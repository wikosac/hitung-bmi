package org.d3if4401.hitungbmi.ui.histori

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.d3if4401.hitungbmi.databinding.FragmentHistoriBinding
import org.d3if4401.hitungbmi.db.BmiDb

class HistoriFragment : Fragment() {

    private val viewModel: HistoriViewModel by lazy {
        val db = BmiDb.getInstance(requireContext())
        val factory = HistoriViewModelFactory(db.dao)
        ViewModelProvider(this, factory)[HistoriViewModel::class.java]
    }

    private lateinit var binding: FragmentHistoriBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHistoriBinding.inflate(layoutInflater,
            container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.data.observe(viewLifecycleOwner, {
            Log.d("HistoriFragment", "Jumlah data: ${it.size}")
        })
    }
}