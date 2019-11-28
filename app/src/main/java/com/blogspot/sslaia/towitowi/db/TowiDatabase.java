package com.blogspot.sslaia.towitowi.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Towi.class, version = 1, exportSchema = false)
public abstract class TowiDatabase extends RoomDatabase {

    private static TowiDatabase instance;

    public abstract TowiDao towiDao();

    public static synchronized TowiDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TowiDatabase.class, "entri_database")
                    .fallbackToDestructiveMigration()
//                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

//    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDbAsyncTask(instance).execute();
//        }
//    };
//
//    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
//        private EntriDao entriDao;
//
//        private PopulateDbAsyncTask(EntriDatabase db) {
//            entriDao = db.entriDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            entriDao.insert(new Entri("Judul 1", "label1, label2", "Inilah tulisan 1"));
//            entriDao.insert(new Entri("Judul 2", "label3, label4", "Inilah tulisan 2"));
//            entriDao.insert(new Entri("Judul 3", "label5, label6", "Inilah tulisan 3"));
//            entriDao.insert(new Entri("Judul 4", "label1, label2", "Inilah tulisan 4"));
//            entriDao.insert(new Entri("Judul 5", "label3, label4", "Inilah tulisan 5"));
//            return null;
//        }
//    }

}
