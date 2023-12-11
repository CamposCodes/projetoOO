package aula.lojaoculos.persistence;

import aula.lojaoculos.model.Desconto;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class DescontoPersistence implements Persistence<Desconto> {

    private static final String PATH = DIRECTORY + File.separator +"descontos.json";
    @Override
    public void save(List<Desconto> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Desconto> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Desconto> descontos = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Desconto>>() {
            }.getType();
            descontos = gson.fromJson(json, tipoLista);

            if (descontos == null)
                descontos = new ArrayList<>();
        }

        return descontos;
    }


}
