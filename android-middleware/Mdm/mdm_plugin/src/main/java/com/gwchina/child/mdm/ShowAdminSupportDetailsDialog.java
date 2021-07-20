package com.gwchina.child.mdm;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class ShowAdminSupportDetailsDialog extends Activity implements DialogInterface.OnDismissListener {
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!"android.settings.SHOW_ADMIN_SUPPORT_DETAILS".equals(getIntent().getAction())) {
            finish();
            return;
        }

        if (null == getIntent().getSourceBounds()) {
            finish();
            return;
        }

        mDialog = new Dialog(this, R.style.mydialog);
        View mDialogView = LayoutInflater.from(mDialog.getContext()).inflate(
                R.layout.admin_support_details_dialog, null);

        mDialog.setOnDismissListener(this);
        mDialog.setContentView(mDialogView);
        mDialog.show();
    }

    public void onClick(View v) {
        int viewId = v.getId();

        switch (viewId) {
            case R.id.text_exit: {
                finish();
            }
            return;

            case R.id.text_go: {
//                StartPackage(this, getPackageName(), new Intent(this, GreenAppLockActivity.class));
                finish();
            }
            return;
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        finish();
    }

    public static void StartPackage(Context context, String StrPackageName, Intent intent) {
        if (null == context) return;
        if (null == StrPackageName) return;
        if (null == intent) return;

        Intent l_intent = intent;
        l_intent.setPackage(StrPackageName);

        try {
            context.startActivity(l_intent);
        } catch (ActivityNotFoundException ex) {
        }
    }
}
