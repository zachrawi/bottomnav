package com.zachrawi.bottomnav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    private static final String KEY_COLOR = "color";
    private static final String KEY_TEXT = "text";

    public static MyFragment newInstance(int color, String text) {
        MyFragment myFragment = new MyFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_COLOR, color);
        bundle.putString(KEY_TEXT, text);

        myFragment.setArguments(bundle);

        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            int color = bundle.getInt(KEY_COLOR);
            String text = bundle.getString(KEY_TEXT);

            RelativeLayout relativeLayout = view.findViewById(R.id.relativeLayout);
            TextView textView = view.findViewById(R.id.textView);

            relativeLayout.setBackgroundColor(getActivity().getResources().getColor(color));
            textView.setText(text);
        }

        return view;
    }
}
