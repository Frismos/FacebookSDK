package com.facebook.android;

import android.content.Intent;

public interface FbActionsListener {

	public void onActionsFinishWithResultOK(final int resultCode, final Intent intent);
}
