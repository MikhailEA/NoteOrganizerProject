package com.refactoring.noteorganizerproject.notes.notes_list_fragment.view.recycler;

public interface INotesSortingPresenter {
    void enableSort();
    void disableSort();

    void sortByDate();
    void sortByTitle();
}
