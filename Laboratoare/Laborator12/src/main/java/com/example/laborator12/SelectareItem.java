package com.example.laborator12;
import java.util.List;
import java.util.Map;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
public class SelectareItem implements ChangeListener<String>{
    Map<?, List<Student>> map;

    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) { }
    public SelectareItem(Map<?,List<Student>> map){ this.map=map;}
}
