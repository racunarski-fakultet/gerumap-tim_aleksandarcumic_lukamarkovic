package main.java.dsw.gerumap.app.repository.composite;

import main.java.dsw.gerumap.app.Observer.Publisher;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.core.MapRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract  class MapNode implements Publisher {

    private String name;
    @ToString.Exclude
    private MapNode parent;
    protected List<Subscriber> subs;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
        this.subs = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MapNode) {
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }

    public void setName(String name) {
        this.name = name;
        notify();
    }
}
