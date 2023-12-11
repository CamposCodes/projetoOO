package aula.lojaoculos.persistence;

import com.google.gson.reflect.TypeToken;
import aula.lojaoculos.model.Oculos;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class OculosPersistence implements Persistence<Oculos> {

    private static final String PATH = DIRECTORY + File.separator +"oculos.json";
    @Override
    public void save(List<Oculos> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Oculos> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Oculos> oculos = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Oculos>>() {
            }.getType();
            oculos = gson.fromJson(json, tipoLista);

            if (oculos == null)
                oculos = new ArrayList<>();
        }

        return oculos;
    }


}
