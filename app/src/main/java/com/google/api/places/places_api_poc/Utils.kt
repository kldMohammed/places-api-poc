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

import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.google.android.material.snackbar.Snackbar

// Simple interface to perform a task that requires a permission.
interface PermissionDependentTask {
    fun getRequiredPermission(): String
    fun onPermissionGranted()
    fun onPermissionRevoked()
}

// Snackbar syntactic sugar.
fun showSnackbar(containerView: View,
                 message: CharSequence,
                 duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(containerView, message, duration).show()
}

//
// Extension functions.
//

fun String.log() = Log.i("places-api-poc", this)

fun String.snack(view: View) = showSnackbar(view, this)

fun <T : View> FragmentActivity.find(id: Int): T = this.findViewById(id)

fun FragmentActivity.snack(id: Int, message: String) {
    showSnackbar(this.find(id), message)
}