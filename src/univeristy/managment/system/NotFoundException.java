/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univeristy.managment.system;

/**
 *
 * @author Compu City
 */
public class NotFoundException extends RuntimeException {

    /**
     * Creates a new instance of <code>IsEmptyException</code> without detail
     * message.
     */
    public NotFoundException() {
    }

    /**
     * Constructs an instance of <code>IsEmptyException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotFoundException(String msg) {
        super(msg);

    }
}
