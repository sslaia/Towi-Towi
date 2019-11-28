package com.blogspot.sslaia.towitowi.ui.create;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.blogspot.sslaia.towitowi.R;
import com.blogspot.sslaia.towitowi.databinding.TowiCreateBinding;
import com.blogspot.sslaia.towitowi.db.Towi;
import com.blogspot.sslaia.towitowi.viewmodel.TowiViewModel;
import com.google.android.material.snackbar.Snackbar;

public class CreateFragment extends Fragment {

    private TowiCreateBinding binding;
    private TowiViewModel model;
    private Towi towi;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        binding.saveStory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveTowi();
            }
        });

        model = ViewModelProviders.of(getActivity()).get(TowiViewModel.class);
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                saveTowi();
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveTowi() {

        String title = binding.createTitle.getText().toString();
        String label = binding.createLabel.getText().toString();
        String body = binding.createBody.getText().toString();

        towi = new Towi(title, label, body);

        if (title.trim().isEmpty() || label.trim().isEmpty() || body.trim().isEmpty()) {
            Snackbar.make(getView(), "Please enter a title, label and body.", Snackbar.LENGTH_LONG);
            return;
        } else {
            model.insert(towi);
        }
    }

}