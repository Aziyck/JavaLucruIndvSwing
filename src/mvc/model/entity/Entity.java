package mvc.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Entity implements Serializable, Cloneable {
    public abstract ArrayList<String> toStringArr();
}
