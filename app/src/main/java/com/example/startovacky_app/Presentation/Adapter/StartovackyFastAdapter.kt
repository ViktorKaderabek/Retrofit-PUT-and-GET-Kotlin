package com.example.startovacky_app.Presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.startovacky_app.Data.Modules.StartovackyDataClassItem
import com.example.startovacky_app.R
import com.example.startovacky_app.databinding.ItemStartovackyBinding
import com.mikepenz.fastadapter.binding.AbstractBindingItem

class StartovackyFastAdapter(val startovackyItem: StartovackyDataClassItem) ://Adapter
    AbstractBindingItem<ItemStartovackyBinding>() {

    override val type: Int
        get() = R.id.startovacky_item

    override fun bindView(
        binding: ItemStartovackyBinding,
        payloads: List<Any>,
    ) {//prirazuje view s DataClassou
        binding.textNazevLokace.text = startovackyItem.name
    }

    override fun createBinding(
//Vytvari recyclerview
        inflater: LayoutInflater,
        parent: ViewGroup?,
    ): ItemStartovackyBinding {
        return ItemStartovackyBinding.inflate(
            inflater,
            parent,
            false
        )
    }

}