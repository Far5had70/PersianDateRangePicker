// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.waspar.persiandatepicker.wheel;

import android.view.MotionEvent;

//

/**
 * Referenced classes of package com.qingchifan.view:
 * LoopView
 */
public class LoopViewGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {

    private final LoopView loopView;

    LoopViewGestureListener(LoopView loopview) {
        super();
        loopView = loopview;
    }

    public final boolean onDown(MotionEvent motionevent) {
        if (loopView.timer != null) {
            loopView.timer.cancel();
        }
        return true;
    }

    public final boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1) {
        loopView.b(f1);
        return true;
    }
}
