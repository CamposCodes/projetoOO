/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.exceptions;

public class NaoEncontradoException extends Exception{
    public NaoEncontradoException() {
    }

    public NaoEncontradoException(String message) {
        super(message);
    }
}
