package hw.d20072021.data.container;

import hw.d20072021.data.capsula.Developer;

@Developer
public final class Container extends AbstractContainer {
    private Object owner;
    private Container child;

    public Container() { }

    public void init(Object owner){
        this.owner = owner;
        child = new Container();

    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

    public Object getOwner() {
        return owner;
    }

    public Object[] getParents() {
        return getArrayRef();
    }

    public Object getParentRef(int index) {
        return getRef(index);
    }
    public Object[] getChildren() {
        return child.getArrayRef();
    }

    public void addChild(Object obj){
        child.add(obj);
    }
}
