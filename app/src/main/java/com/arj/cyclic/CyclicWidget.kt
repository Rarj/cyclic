package com.arj.cyclic

import android.content.Context
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.padding
import androidx.glance.text.Text
import java.util.Locale

class CyclicWidget : GlanceAppWidget() {
	override suspend fun provideGlance(context: Context, id: GlanceId) {
		provideContent {
			GlanceTheme {
				Column(
					modifier = GlanceModifier
						.fillMaxWidth()
						.padding(16.dp)
						.background(Color.LightGray),
				) {
					val modifier = GlanceModifier.defaultWeight()
					val minutes = remember { mutableStateOf(0) }
					val seconds = remember { mutableStateOf(0) }
					val formattedTime = remember {
						derivedStateOf {
							String.format(
								Locale.getDefault(), "%02d:%02d", minutes.value, seconds.value
							)
						}
					}
					Column(
						modifier = modifier.fillMaxSize(),
						verticalAlignment = Alignment.CenterVertically,
						horizontalAlignment = Alignment.CenterHorizontally,
					) {
						Text(text = formattedTime.value)
						Button(
							text = "Start",
							onClick = {

							},
						)
					}
				}
			}
		}
	}
}