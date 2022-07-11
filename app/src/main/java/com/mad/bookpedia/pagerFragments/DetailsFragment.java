package com.mad.bookpedia.pagerFragments;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mad.bookpedia.R;
import com.mad.bookpedia.models.Book;
import com.mad.bookpedia.utils.pConstants;

public class DetailsFragment extends Fragment {

    private View mRoot;
    private Book currentBook=null;
    private TextView mDescription,mPublisher,mPublishedDate;
    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRoot = inflater.inflate(R.layout.fragment_details_paged, container, false);

        Bundle args = getArguments();
        currentBook = args.getParcelable(pConstants.BOOK_FRAGMENT_KEY);

        if(currentBook!=null){
            initData();
        }

        return mRoot;
    }

    private void initData() {
        mDescription=(TextView)mRoot.findViewById(R.id.tvDescription_pagerDetail);
        mPublisher=(TextView)mRoot.findViewById(R.id.tvDescription_publisher);
        mPublishedDate=(TextView)mRoot.findViewById(R.id.tvDescription_publishedDate);

        mDescription.setText(currentBook.getDescription());;

        if(currentBook.getPublishedDate()!=null){
            mPublishedDate.setText(currentBook.getPublishedDate());
        }

        if(currentBook.getPublisher()!=null){
            mPublisher.setText(currentBook.getPublisher());
        }

    }


}
