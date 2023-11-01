package com.ipsmeet.retrofitwithcompose.ecommerce.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ipsmeet.retrofitwithcompose.R
import com.ipsmeet.retrofitwithcompose.e_commerce_app.EcommerceViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(ecommerceViewModel: EcommerceViewModel = viewModel()) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            )
        }
    ) {
        NestedScrolling(it, ecommerceViewModel)
    }
}

@Composable
private fun NestedScrolling(
    it: PaddingValues,
    ecommerceViewModel: EcommerceViewModel,
) {
    LazyColumn(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(it)
            .fillMaxSize()
    ) {
        item {
            CategoryList(categories = ecommerceViewModel.categories.value)
        }
            productList(products = ecommerceViewModel.products.value)
    }
}