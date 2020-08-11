package com.refactoring.noteorganizerproject.notes.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Note {
    public long id;
    public String title;
    public String body;
    public int cardImageUri;
    public long dataTime;
    public int noteColor = 0;

    @NonNull
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", cardImageUri=" + cardImageUri +
                ", dataTime=" + dataTime +
                ", noteColor=" + noteColor +
                '}';
    }

    public boolean isEmpty() {
        return (this.body == null || this.body.length() == 0)
                && (this.title == null || this.title.length() == 0);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        Note other = (Note) obj;
        if (obj == null) return false;
        return this.title.equals(other.title) && this.body.equals(other.body) && dataTime == other.dataTime;
    }


}
