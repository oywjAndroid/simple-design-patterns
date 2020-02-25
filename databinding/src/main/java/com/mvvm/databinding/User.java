package com.mvvm.databinding;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * @author allen
 * @description:
 * @date :2020-02-21 16:50
 */
public class User {

    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> password = new ObservableField<>();
    public final ObservableField<String> imageUrl = new ObservableField<>();
    public final ObservableInt errorDrawableId = new ObservableInt();

    public final ObservableInt paddingLeft = new ObservableInt();



//    private ObservableField<String> name;
//    private String password;
//
//    public User(String name, String password) {
//        this.name = name;
//        this.password = password;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
