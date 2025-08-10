package com.arj.cyclic.ui

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.arj.cyclic.CyclicWidget

class CyclicWidgetReceiver() : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = CyclicWidget()
}