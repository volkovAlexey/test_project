package ua.repository.basic;

public interface BasicRepository<ID, ENTITY> {

    ENTITY getOne(ID id);

    void delete(ID id);

    ENTITY update(ID id, ENTITY type);
}
