package com.refactoring.noteorganizerproject.entity.data_base.impl;

import com.refactoring.noteorganizerproject.BasePresenter;
import com.refactoring.noteorganizerproject.entity.AppConfig;
import com.refactoring.noteorganizerproject.entity.data_base.dao.NoteDAO;
import com.refactoring.noteorganizerproject.entity.data_base.interract.INoteDao;
import com.refactoring.noteorganizerproject.notes.model.Note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NoteDaoImpl implements INoteDao {
    private final AppConfig appConfig = AppConfig.getInstance();
    private final NoteDAO noteDAO = appConfig.getDatabase().getNoteDao();
    private Disposable disposable = null;

    private int NO_MESSAGE = 0;

    // class vars
    private ArrayList<Note> notesList = new ArrayList<>();
    private List<Note> selectedNotes = new ArrayList<>();
    private Note note = new Note();

    @Override
    public Note getNote() { return note; }

    @Override
    public Note getNoteByPosition(int position) {
        return notesList == null ? new Note() : notesList.get(position);
    }

    @Override
    public Integer size() {
        return notesList == null ? 0 : notesList.size();
    }

    @Override
    public boolean wasSelected(Note note) {
        return selectedNotes.contains(note);
    }

    @Override
    public void selectNote(Note note) {
        if (wasSelected(note))
            selectedNotes.remove(note);
        else
            selectedNotes.add(note);
    }

    @Override
    public void sortNotes(BasePresenter presenter, Comparator comparator) {
        Collections.sort(notesList, comparator);
        presenter.notifyDatasetChanged(NO_MESSAGE);
    }

    @Override
    public void saveNote(Note note) {
        disposable = Completable.fromAction(() -> noteDAO.insert(note))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(() -> System.out.println("NOTE SAVED"),
                        Throwable::printStackTrace);
    }


}
