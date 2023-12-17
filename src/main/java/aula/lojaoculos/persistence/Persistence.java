/*Integrantes:
   - Gabriel Campos (202176005)
   - Álvaro Thees (202165003A)
*/
package aula.lojaoculos.persistence;

import java.util.List;

public interface Persistence<T> {

    String DIRECTORY = "data";
    public void save(List<T> itens);

    public List<T> findAll();

}
