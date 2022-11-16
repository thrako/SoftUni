package lesson04_interfaces.exercise.n06_military.interfaces;

import lesson04_interfaces.exercise.n06_military.entities.PrivateImpl;

import java.util.List;

public interface LieutenantGeneral {

    void addPrivate(PrivateImpl priv);

    List<PrivateImpl> getPrivates();
}
