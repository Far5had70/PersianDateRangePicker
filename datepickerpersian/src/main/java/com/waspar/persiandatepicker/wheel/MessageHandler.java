// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.waspar.persiandatepicker.wheel;

import android.os.Handler;
import android.os.Message;

/**
 * Referenced classes of package com.qingchifan.view:
 * LoopView
 */
public class MessageHandler extends Handler {

    private final LoopView a;

    MessageHandler(LoopView loopview) {
        super();
        a = loopview;
    }

    public final void handleMessage(Message paramMessage) {
        if (paramMessage.what == 1000)
            this.a.invalidate();
        while (true) {
            if (paramMessage.what == 2000)
                LoopView.b(a);
            else if (paramMessage.what == 3000)
                this.a.c();
            super.handleMessage(paramMessage);
            return;
        }
    }

}
