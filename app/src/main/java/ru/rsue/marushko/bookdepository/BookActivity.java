package ru.rsue.marushko.bookdepository;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;


public class BookActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if (fragment == null) {
            fragment = new BookFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }

    public static Intent newIntent(Context context, UUID id) {
        Intent intent = new Intent(context, BookActivity.class);
        intent.putExtra(EXTRA_BOOK_ID, id); // EXTRA_BOOK_ID - это константа, которую следует определить в классе BookActivity
        return intent;
    }

    protected static final String EXTRA_BOOK_ID = "bookId";
}