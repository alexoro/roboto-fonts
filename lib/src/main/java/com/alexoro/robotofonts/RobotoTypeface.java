/*
 * Copyright (C) 2014 Alexander Sorokin (alexoro)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.alexoro.robotofonts;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by uas.sorokin@gmail.com
 */
public class RobotoTypeface {

    public static final int REGULAR = 0;
    public static final int THIN = 1;
    public static final int LIGHT = 2;
    public static final int MEDIUM = 3;
    public static final int BOLD = 4;

    private static final Object LOCK = new Object();

    private static final Typeface[] BASE = new Typeface[5];
    private static final Typeface[] ITALIC = new Typeface[5];

    public static Typeface getInstance(Context context, int type, boolean isItalic) {
        Typeface typeface = get(type, isItalic);
        if (typeface == null) {
            synchronized (LOCK) {
                typeface = get(type, isItalic);
                if (typeface == null) {
                    typeface = create(context, type, isItalic);
                    set(type, isItalic, typeface);
                }
            }
        }
        return typeface;
    }

    private static Typeface get(int type, boolean isItalic) {
        if (isItalic) {
            return ITALIC[type];
        } else {
            return BASE[type];
        }
    }

    private static void set(int type, boolean isItalic, Typeface typeface) {
        if (isItalic) {
            ITALIC[type] = typeface;
        } else {
            BASE[type] = typeface;
        }
    }

    private static Typeface create(Context context, int type, boolean isItalic) {
        final String fileName;
        if (type == THIN) {
            fileName = isItalic ? "alexoro_roboto_fonts/Roboto-ThinItalic.ttf" : "alexoro_roboto_fonts/Roboto-Thin.ttf";
        } else if (type == LIGHT) {
            fileName = isItalic ? "alexoro_roboto_fonts/Roboto-LightItalic.ttf" : "alexoro_roboto_fonts/Roboto-Light.ttf";
        } else if (type == MEDIUM) {
            fileName = isItalic ? "alexoro_roboto_fonts/Roboto-MediumItalic.ttf" : "alexoro_roboto_fonts/Roboto-Medium.ttf";
        } else if (type == BOLD) {
            fileName = isItalic ? "alexoro_roboto_fonts/Roboto-BoldItalic.ttf" : "alexoro_roboto_fonts/Roboto-Bold.ttf";
        } else {
            fileName = isItalic ? "alexoro_roboto_fonts/Roboto-Italic.ttf" : "alexoro_roboto_fonts/Roboto-Regular.ttf";
        }
        return Typeface.createFromAsset(context.getAssets(), fileName);
    }

}