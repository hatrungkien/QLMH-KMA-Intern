package com.dao;

import java.util.List;

public interface AssistantDao<T> extends DAO {
    List<T> uc_ListAll();
    void uc_ShowAll();
    void uc_Create(String name);
    void uc_UpdateName(String name);
    void uc_DeleteByID(int id);
}
