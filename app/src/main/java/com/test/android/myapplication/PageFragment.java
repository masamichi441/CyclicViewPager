package com.test.android.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PageFragment extends Fragment {

    private static final String KEY_PAGE_NUMBER = "PagetNumber";
    private static final String KEY_ACTUAL_PAGE = "ActualPage";

    private int mPageNumber;
    private int mActualPage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = savedInstanceState;
        if (bundle == null) {
            bundle = getArguments();
        }

        if (bundle != null) {
            mPageNumber = bundle.getInt(KEY_PAGE_NUMBER);
            mActualPage = bundle.getInt(KEY_ACTUAL_PAGE);
        }

        View view = inflater.inflate(R.layout.page_layout, container, false);

        TextView pageNumberView = view.findViewById(R.id.page_number);
        pageNumberView.setText("Page " + mPageNumber);

        TextView actualPageNumberView = view.findViewById(R.id.actual_page_number);
        actualPageNumberView.setText("actual page=" + mActualPage);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_PAGE_NUMBER, mPageNumber);
        outState.putInt(KEY_ACTUAL_PAGE, mActualPage);
    }

    static Fragment createInstance(int pageNumber, int actualPageNumber) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_PAGE_NUMBER, pageNumber);
        bundle.putInt(KEY_ACTUAL_PAGE, actualPageNumber);

        Fragment fragment = new PageFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
}
