package com.blogspot.sslaia.towitowi.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.blogspot.sslaia.towitowi.db.Towi;
import com.blogspot.sslaia.towitowi.db.TowiDao;
import com.blogspot.sslaia.towitowi.db.TowiDatabase;

import java.util.List;

public class TowiRepository {

    private TowiDao towiDao;
    private LiveData<List<Towi>> allTowies;

    public TowiRepository(Application application) {
        TowiDatabase database = TowiDatabase.getInstance(application);
        towiDao = database.towiDao();
        allTowies = towiDao.getAllTowies();
    }

    public void insert(Towi towi) {
        new InsertTowiAsyncTask(towiDao).execute(towi);
    }
    public void update(Towi towi) {
        new UpdateTowiAsyncTask(towiDao).execute(towi);
    }
    public void delete(Towi towi) {
        new DeleteTowiAsyncTask(towiDao).execute(towi);
    }
    public void deleteAllTowies() {
        new DeleteAllTowiesAsyncTask(towiDao).execute();
    }

    public LiveData<List<Towi>> getAllTowies() {
        return allTowies;
    }

    private static class InsertTowiAsyncTask extends AsyncTask<Towi, Void, Void> {
        private TowiDao towiDao;

        private InsertTowiAsyncTask(TowiDao towiDao) {
            this.towiDao = towiDao;
        }

        @Override
        protected Void doInBackground(Towi... towies) {
            towiDao.insert(towies[0]);
            return null;
        }
    }

    private static class UpdateTowiAsyncTask extends AsyncTask<Towi, Void, Void> {
        private TowiDao towiDao;

        private UpdateTowiAsyncTask(TowiDao towiDao) {
            this.towiDao = towiDao;
        }

        @Override
        protected Void doInBackground(Towi... towies) {
            towiDao.update(towies[0]);
            return null;
        }
    }

    private static class DeleteTowiAsyncTask extends AsyncTask<Towi, Void, Void> {
        private TowiDao towiDao;

        private DeleteTowiAsyncTask(TowiDao towiDao) {
            this.towiDao = towiDao;
        }

        @Override
        protected Void doInBackground(Towi... towies) {
            towiDao.delete(towies[0]);
            return null;
        }
    }

    private static class DeleteAllTowiesAsyncTask extends AsyncTask<Void, Void, Void> {
        private TowiDao towiDao;

        private DeleteAllTowiesAsyncTask(TowiDao towiDao) {
            this.towiDao = towiDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            towiDao.deleteAllTowies();
            return null;
        }
    }
}
