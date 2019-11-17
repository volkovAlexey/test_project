package ua.service.basic;

import java.util.List;

public interface BasicService<ID, ENTITY> {

    List<ENTITY> getAll();

    ENTITY getOne(ID id);

    ENTITY update(ID id, ENTITY entity);

    void delete(ID id);
}
