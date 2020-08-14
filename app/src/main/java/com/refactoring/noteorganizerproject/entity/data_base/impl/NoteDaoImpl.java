package com.refactoring.noteorganizerproject.entity.data_base.impl;

import com.refactoring.noteorganizerproject.entity.AppConfig;
import com.refactoring.noteorganizerproject.entity.data_base.interract.INoteDao;

public class NoteDaoImpl implements INoteDao {
    private final AppConfig appConfig = AppConfig.getInstance();
}
