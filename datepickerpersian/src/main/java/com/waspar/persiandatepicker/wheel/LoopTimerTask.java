// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.waspar.persiandatepicker.wheel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Referenced classes of package com.qingchifan.view:
 * LoopView
 */
public class LoopTimerTask extends TimerTask {

    private float a;
    private final float b;
    private final Timer mTimer;
    private final LoopView mLoopView;

    LoopTimerTask(LoopView loopview, float f, Timer timer) {
        super();
        mLoopView = loopview;
        b = f;
        this.mTimer = timer;
        a = 2.147484E+09F;
    }

    @Override
    public final void run() {
        if (a == 2.147484E+09F) {
            if (Math.abs(b) > 2000F) {
                if (b > 0.0F) {
                    a = 2000F;
                } else {
                    a = -2000F;
                }
            } else {
                a = b;
            }
        }
        if (Math.abs(a) >= 0.0F && Math.abs(a) <= 20F) {
            mTimer.cancel();
            mLoopView.handler.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((a * 10F) / 1000F);
        LoopView loopview = mLoopView;
        loopview.totalScrollY = loopview.totalScrollY - i;
        if (!mLoopView.isLoop) {
            if (mLoopView.totalScrollY <= (int) ((float) (-mLoopView.position) * (mLoopView.l * (float) mLoopView.h))) {
                a = 40F;
                mLoopView.totalScrollY = (int) ((float) (-mLoopView.position) * (mLoopView.l * (float) mLoopView.h));
            } else if (mLoopView.totalScrollY >= (int) ((float) (mLoopView.arrayList.size() - 1 - mLoopView.position) * (mLoopView.l * (float) mLoopView.h))) {
                mLoopView.totalScrollY = (int) ((float) (mLoopView.arrayList.size() - 1 - mLoopView.position) * (mLoopView.l * (float) mLoopView.h));
                a = -40F;
            }
        }
        if (a < 0.0F) {
            a = a + 20F;
        } else {
            a = a - 20F;
        }
        mLoopView.handler.sendEmptyMessage(1000);
    }
}
