package com.refactoring.noteorganizerproject.settings.view;

public interface ISettingsView {
    void reloadActivity();
    void setNotesCacheSize(String size);
    void setTodosCacheSize(String size);
    void showHint(int messageId);
    void setLastSyncDate(String date);
}
