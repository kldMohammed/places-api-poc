/*
 * Copyright 2018 Nazmul Idris. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.api.places.places_api_poc

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import com.google.android.gms.location.places.GeoDataClient
import com.google.android.gms.location.places.PlaceDetectionClient
import com.google.android.gms.location.places.Places
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast

class PlacesAPIClients(val appContext: Context) : LifecycleObserver, AnkoLogger {
    lateinit var geoDataClient: GeoDataClient
    lateinit var placeDetectionClient: PlaceDetectionClient

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun connect() {
        info {
            "PlacesAPIClients.connect()"
        }
        geoDataClient = Places.getGeoDataClient(appContext)
        placeDetectionClient = Places.getPlaceDetectionClient(appContext)
        appContext.toast("connect() - got GetoDataClient and PlaceDetectionClient")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun cleanup() {
        appContext.toast("cleanup()")
        info {
            "PlacesAPIClients.cleanup()"
        }
    }
}