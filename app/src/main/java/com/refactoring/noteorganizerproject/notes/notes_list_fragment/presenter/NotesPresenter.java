package com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter;

public class NotesPresenter implements INotesPresenter, INotesSortingPresenter {
    private String CLASS_TAG = "RecyclerViewPresenter";
    private final int NEW_NOTE = -1;
    private final int NO_MESSAGE = 0;

    private final INoteDao noteDao = new NoteDaoImpl();



}
