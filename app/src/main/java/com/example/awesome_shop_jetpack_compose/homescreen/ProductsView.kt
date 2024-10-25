package com.example.awesome_shop_jetpack_compose.homescreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.awesome_shop_jetpack_compose.models.product.ProductsResponseItem

@Composable
fun ProductItem(product: ProductsResponseItem, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .width(170.dp)
            .wrapContentSize()
            .clickable {onClick()},
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val image = product.image
            AsyncImage(
                model = image,
                contentDescription = product.title,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )

            Text(
                text = product.title,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .height(80.dp)
            )
        }
    }
}

