package com.refactoring.noteorganizerproject.notes.notes_list_fragment.presenter;

public class NotesListenersProvider {
    private INotesSortingPresenter presenter;

    public NotesListenersProvider(INotesSortingPresenter iNotesPresenter) {
        this.presenter = iNotesPresenter;
    }


}
