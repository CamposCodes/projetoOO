package aula.lojaoculos.persistence;

import com.google.gson.reflect.TypeToken;
import aula.lojaoculos.model.Venda;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class VendaPersistence implements Persistence<Venda> {

    private static final String PATH = DIRECTORY + File.separator +"vendas.json";
    @Override
    public void save(List<Venda> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    @Override
    public List<Venda> findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        List<Venda> vendas = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Venda>>() {
            }.getType();
            vendas = gson.fromJson(json, tipoLista);

            if (vendas == null)
                vendas = new ArrayList<>();
        }

        return vendas;
    }


}
