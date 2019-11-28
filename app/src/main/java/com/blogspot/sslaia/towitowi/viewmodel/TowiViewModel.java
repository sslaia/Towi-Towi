package com.blogspot.sslaia.towitowi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.blogspot.sslaia.towitowi.db.Towi;
import com.blogspot.sslaia.towitowi.repository.TowiRepository;

import java.util.List;

public class TowiViewModel extends AndroidViewModel {

    private TowiRepository repository;
    private LiveData<List<Towi>> allTowies;

    public TowiViewModel(@NonNull Application application) {
        super(application);
        repository = new TowiRepository(application);
        allTowies = repository.getAllTowies();
    }

    public void insert(Towi entri) {
        repository.insert(entri);
    }

    public void update(Towi entri) {
        repository.update(entri);
    }

    public void delete(Towi entri) {
        repository.delete(entri);
    }

    public void deleteAllEntris() {
        repository.deleteAllTowies();
    }

    public LiveData<List<Towi>> getAllTowies() {
        return allTowies;
    }

}
