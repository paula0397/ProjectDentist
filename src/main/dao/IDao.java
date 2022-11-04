package main.dao;

public interface IDao <T> {

    T save(T t);

    void remove(Integer id);
    T search(Integer id);


}
