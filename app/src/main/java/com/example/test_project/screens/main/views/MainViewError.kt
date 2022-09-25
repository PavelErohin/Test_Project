package com.example.test_project.screens.main.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.test_project.theme.RstTheme


@Composable
fun MainViewError(
  onReloadClick: () -> Unit //todo
) {
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = RstTheme.colors.primaryBackground
  ) {
    Box(modifier = Modifier.fillMaxSize()) {
      Column(
        modifier = Modifier
          .padding(16.dp)
          .align(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Icon(
          modifier = Modifier.size(96.dp),
          imageVector = Icons.Filled.Warning,
          tint = RstTheme.colors.controlColor,
          contentDescription = "Error loading items"
        )

        Text(
          modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
          text = stringResource(id = com.example.namespace.R.string.main_error_loading),
          style = RstTheme.typography.body,
          color = RstTheme.colors.primaryText,
          textAlign = TextAlign.Center
        )
      }
    }
  }
}