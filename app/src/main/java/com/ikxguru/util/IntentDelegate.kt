package com.ikxguru.util

import android.app.Activity
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class IntentDelegate<T : Any>(
    private val key: String,
    private val defaultValue: T
) : ReadOnlyProperty<Activity, T> {

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return thisRef.intent.extras?.get(key) as? T ?: defaultValue
    }
}