package annotation.be.apt.mirror.apt;

import java.io.Serializable;
import java.util.EventObject;

// https://docs.oracle.com/javase/7/docs/jdk/api/apt/mirror/com/sun/mirror/apt/RoundCompleteEvent.html
@LevelH(1)
public abstract class RoundCompleteEvent extends EventObject implements Serializable {
    private RoundState rs;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    protected RoundCompleteEvent(AnnotationProcessorEnvironment source,
                                 RoundState rs) {
        super(source);
        this.rs = rs;
    }

    public RoundState getRoundState() {
        return rs;
    }

    public AnnotationProcessorEnvironment getSource() {
        return (AnnotationProcessorEnvironment) super.source;
    }
}
