package FramesAndIframes;

public class TypesOfFrames
{
    /**
     * We have few types of frames like
     * 1.frames inside frames(nested frames).
     * 2.sibling frames(multiple frames inside a parent frame).
     *
     * To handle nested frames we have to switch driver context to parent frame and, then we have to switch nested
     * frame.
     *
     * To handle multiple frames inside a single parent frame we have to switch to parent frame and, then we have to
     * switch them using frame attributes or indexes, to switch from one frame to another we have to switch driver
     * context to parent frame by using 'driver.switchTo().parentFrame(); method.
     */
}
