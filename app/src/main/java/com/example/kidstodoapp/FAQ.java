package com.example.kidstodoapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FAQ extends Fragment implements View.OnClickListener {
    private TextView[] faqText = new TextView[10];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_faq, container, false);

        KeyboardUtility.hideKeyboard(requireActivity());

        for(int i=0; i<=9; i++) {
            String textId = "faq_entry_" + i + "_text";
            int viewId = getResources().getIdentifier(textId, "id", requireContext().getPackageName());
            faqText[i] = view.findViewById(viewId);
            faqText[i].setVisibility(View.GONE);
        }
        return view;
    }

    @Override
    public void onClick(View view){
        toggleVisibility(view);
    }

    public void toggleVisibility(View view) {
        for(int i=0; i<=9; i++) {
            String textId = "faq_entry_" + i + "_title";
            int viewId = getResources().getIdentifier(textId, "id", requireContext().getPackageName());
            if(view.getId() == viewId) {
                AnimationsUtility.toggleEntryVisibility(faqText[i], getContext());
                break;
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity) requireActivity()).setCheckedItem(R.id.FAQ);
    }
}
