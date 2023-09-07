package com.example.metflix.image

import com.example.metflix.R
import com.example.metflix.scroll.scroll

class ImageSource {
    fun getAll() : List<scroll>{
        return listOf(
            scroll( R.drawable.tom),
            scroll( R.drawable.andrew),
            scroll( R.drawable.tobey),
            scroll( R.drawable.aunt),
            scroll( R.drawable.gob),
            scroll( R.drawable.electro),
            scroll( R.drawable.tom)
        )
    }
}