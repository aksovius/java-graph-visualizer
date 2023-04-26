package visualizer;

public enum Mode {
    NONE("None"),
    ADD_VERTEX("Add a Vertex"),
    ADD_EDGE ("Add an Edge"),
    REMOVE_VERTEX("Remove a Vertex"),
    REMOVE_EDGE("Remove an Edge") ;
    private final String labelName;
    private Mode(String labelName) {
        this.labelName = labelName;
    }
    public String toString(){
        return this.labelName;
    }
    public String getLabelName() {
        return "Current Mode -> " + this.labelName;
    }
}