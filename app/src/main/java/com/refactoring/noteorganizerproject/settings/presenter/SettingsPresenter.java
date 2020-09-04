package com.refactoring.noteorganizerproject.settings.presenter;

import com.refactoring.noteorganizerproject.BasePresenter;
import com.refactoring.noteorganizerproject.ParameterizedAction;
import com.refactoring.noteorganizerproject.R;
import com.refactoring.noteorganizerproject.entity.data_base.impl.NoteDaoImpl;
import com.refactoring.noteorganizerproject.entity.data_base.impl.TodoDaoImpl;
import com.refactoring.noteorganizerproject.entity.data_base.interract.INoteDao;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.settings.view.ISettingsView;

import java.io.File;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SettingsPresenter implements BasePresenter {
    private final String CLASS_TAG = "SettingsPresenter";
    private SharedPreferencesManager appSettings;
    private ISettingsView view;
    private TodoDaoImpl todoDao;
    private final INoteDao noteDao = new NoteDaoImpl();

    private int lastCheckedId = 0;
    private int APP_THEME;

    private ParameterizedAction todosCacheSizeListener = new ParameterizedAction() {
        @Override
        public void doAction(String s) {
            view.setTodosCacheSize(s);
        }
    };

    public SettingsPresenter(ISettingsView view) {
        todoDao = new TodoDaoImpl();
        appSettings = todoDao.getAppSettings();
        this.view = view;
        this.APP_THEME = appSettings.getAppTheme();
    }

    public int getThemeId() {
        if (APP_THEME == R.style.AppTheme)
            lastCheckedId = R.id.light_mode_theme_selection;
        else
            lastCheckedId = R.id.dark_mode_theme_selection;

        return lastCheckedId;
    }

    public String getNotesCacheSize() {
        File f = new File(appSettings.getAppDataDirectory());
        File[] allFiles = f.listFiles();
        long space = 0;
        for (File tmp : allFiles)
            space += tmp.length();

        if (space == 0)
            return "0 bytes";

        if (space / 1024 == 0)
            return String.format("%.0f bytes", space / 1.0);

        if (space / 1024 / 1024 == 0) {
            return String.format("%.3f kb", space / 1024.0);
        }

        return String.format("%.3f mb", space / 1024.0 / 1024.0);
    }

    public void getTodosCacheSize() {
        Disposable disposable = Completable.fromAction( () -> todoDao.getCacheSize(todosCacheSizeListener) )
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        () -> {
                            System.out.println("SET");
                            view.setTodosCacheSize(todoDao.size().toString());
                        },
                        Throwable::printStackTrace
                );
    }
}
