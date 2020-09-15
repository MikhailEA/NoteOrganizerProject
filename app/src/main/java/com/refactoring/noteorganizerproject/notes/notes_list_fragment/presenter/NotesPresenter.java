package com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter;

import com.refactoring.noteorganizerproject.entity.data_base.impl.NoteDaoImpl;
import com.refactoring.noteorganizerproject.entity.data_base.interract.INoteDao;
import com.refactoring.noteorganizerproject.entity.shared_prefs.SharedPreferencesManager;
import com.refactoring.noteorganizerproject.notes.model.Note;
import com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.NotesFragment;
import com.refactoring.noteorganizerproject.utils.SortListComparator;

import java.util.Comparator;

public class NotesPresenter implements INotesPresenter, INotesSortingPresenter {

    private String CLASS_TAG = "RecyclerViewPresenter";
    private final int NEW_NOTE = -1;
    private final int NO_MESSAGE = 0;

    private final INoteDao noteDao = new NoteDaoImpl();

    private NotesFragment fragmentView;
    private SharedPreferencesManager appSettings;
    private NotesListenersProvider listenersProvider;

    enum State { MULTI_SELECTION, SINGLE_SELECTION }
    private State state = State.SINGLE_SELECTION;

    private Comparator<Note> comparator = SortListComparator.getDateComparator();

    public NotesPresenter(NotesFragment view) {
        this.fragmentView = view;
        appSettings = noteDao.getAppSettings();
        listenersProvider = new NotesListenersProvider(this);
    }

    public void getNotes() {
        String searchText = fragmentView.getSearchText();
        if (searchText.equals(""))
            noteDao.getFromDB(this);
        else
            searchNotes(searchText);
    }

    @Override
    public void notifyDatasetChanged(int messageId) {
        if (messageId == NO_MESSAGE)
            fragmentView.notifyDataChaged();
        else
            fragmentView.showToast(messageId);
    }







}
