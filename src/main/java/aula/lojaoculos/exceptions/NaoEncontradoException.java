package aula.lojaoculos.exceptions;

public class NaoEncontradoException extends Exception{
    public NaoEncontradoException() {
    }

    public NaoEncontradoException(String message) {
        super(message);
    }
}
