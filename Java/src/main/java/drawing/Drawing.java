package drawing;

import drawing.shapes.Line;
import drawing.shapes.Shape;
import drawing.writing.JPEGWriter;
import drawing.writing.PNGWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Refactor Task 3: (Mis-)Shaped
 *
 * @author Zishen Wen (F22), Deyuan Chen (S22)
 */
public class Drawing {

    private List<Shape> shapes;

    public Drawing(List<Shape> shapes) {
        this.shapes = shapes;
    }

    /**
     * Draw shapes to a file with given file format.
     *
     * @param format   file format
     * @param filename file name
     */
    public void draw(String format, String filename) {
        // TODO: Do you notice any issues here?
        if (format.equals("jpeg")) {
            try (Writer writer = new JPEGWriter(filename + ".jpeg")) {
                for (Shape shape : this.shapes) {
                    // TODO: What is the issue of the behavior here?
                    Line[] lines = shape.toLines();
                    shape.draw(writer, lines);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (format.equals("png")) {
            try (Writer writer = new PNGWriter(filename + ".png")) {
                for (Shape shape : this.shapes) {
                    Line[] lines = shape.toLines();
                    shape.draw(writer, lines);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

// It is not a good idea to re-write the same code for the two formats.
/**
 * We can have an interface for the writer, and then have two classes that implement the interface for the two formats.
 * This way, we can avoid re-writing the same code for the two formats.
 * Later when we want to add a new format, we can just create a new class that implements the interface.
 */

 /**
  * Also the Drawing class is exposing the encapsulated details of the shape by calling the toLines() method.
  * We can change this by adding a parameter to the toLines() method, which makes it take a writer,
  * and modifies the writer object inside the method rather than exposing the details to Drawing.
  */

