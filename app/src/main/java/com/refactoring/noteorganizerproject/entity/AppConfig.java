package com.refactoring.noteorganizerproject.entity;



import android.app.Application;
import android.os.Environment;


import androidx.room.Room;

import com.refactoring.noteorganizerproject.entity.data_base.DataBase;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.todos.notifications.Alarm;

import java.io.File;


public class AppConfig extends Application {
   private static AppConfig instance;
   private DataBase database;
   private SharedPreferencesManager appSettings;
   private Alarm alarm;

   @Override
   public void onCreate() {
       super.onCreate();
       instance = this;

       database = Room.databaseBuilder(this, DataBase.class, "database")
               .fallbackToDestructiveMigration()
               .build();

       appSettings = new SharedPreferencesManager(this);
       createDirectory();

       alarm = new Alarm(this);
   }

   public static AppConfig getInstance() { return instance; }
   public SharedPreferencesManager getAppSettings() {return appSettings; }

    public DataBase getDatabase() {
        return database;
    }

   private void createDirectory() {
       System.out.println("CREATING DIR");
       File storageDir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
       File myDirectory = new File(storageDir, "com.refactoring.noteorganizerproject");
       appSettings.setAppDataDirectory(myDirectory.getAbsolutePath());

       if(!myDirectory.exists()) {
           myDirectory.mkdir();
       }

   }

   public Alarm getAlarm() { return alarm; }

}
