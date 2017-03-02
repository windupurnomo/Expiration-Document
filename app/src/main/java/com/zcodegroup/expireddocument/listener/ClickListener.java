package com.zcodegroup.expireddocument.listener;

import android.view.View;

/**
 * Created by windupurnomo on 3/2/17.
 */
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}