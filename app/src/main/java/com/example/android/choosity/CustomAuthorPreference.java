package com.example.android.choosity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;

public class CustomAuthorPreference extends Preference implements View.OnClickListener {

    public CustomAuthorPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        View v = holder.itemView;
        // Make the icon clickable
        ImageView github = v.findViewById(R.id.mygit);
        github.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Vibrate and play sound using the common method in MainActivity
        Activity act = (Activity) getContext();
        Uri uri;
        if (v.getId() == R.id.mygit) {
            if (act instanceof MainActivity) ((MainActivity) act).vibrate();
            uri = Uri.parse(getContext().getString(R.string.dev_github));
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            getContext().startActivity(intent);
        }
    }
}

