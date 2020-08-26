package com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter;

import com.refactoring.noteorganizerproject.entity.data_base.impl.NoteDaoImpl;
import com.refactoring.noteorganizerproject.entity.data_base.interract.INoteDao;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.NotesFragment;

public class NotesPresenter implements INotesPresenter, INotesSortingPresenter {
    private String CLASS_TAG = "RecyclerViewPresenter";
    private final int NEW_NOTE = -1;
    private final int NO_MESSAGE = 0;

    private final INoteDao noteDao = new NoteDaoImpl();

    private NotesFragment fragmentView;
    private SharedPreferencesManager appSettings;
    private NotesListenerProvider listenerProvider;

    



}
