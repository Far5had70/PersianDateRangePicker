// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.waspar.persiandatepicker.wheel;

/**
 * Referenced classes of package com.qingchifan.view:
 * LoopView, LoopListener
 */
public class LoopRunnable implements Runnable {

    public interface LoopListener {
        void onItemSelect(int item);
    }

    private final LoopView mLoopView;

    LoopRunnable(LoopView loopview) {
        super();
        mLoopView = loopview;
    }

    public final void run() {
        LoopListener listener = mLoopView.loopListener;
        int i = LoopView.getSelectItem(mLoopView);
        listener.onItemSelect(i);
    }
}
