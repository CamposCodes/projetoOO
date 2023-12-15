package aula.lojaoculos.persistence;

import aula.lojaoculos.model.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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

        String json = Arquivo.le(PATH);

        List<Desconto> descontos = new ArrayList<>();

        JsonElement elemento = JsonParser.parseString(json);
        if(!elemento.isJsonNull()){
            JsonArray array = elemento.getAsJsonArray();
            for (JsonElement item : array){
                descontos.add(retornaObjetoDesconto(item));
            }
        }

        return descontos;
    }

    private Desconto retornaObjetoDesconto(JsonElement objeto) {
        String objetoEmString = objeto.toString();
        Type tipoDesconto;

        Gson gson = new Gson();

        if(objetoEmString.contains("porcentagem")){ // CASO SEJA CASHBACK
            tipoDesconto = new TypeToken<Cashback>() {}.getType();
            return gson.fromJson(objeto, tipoDesconto);

        } else { // CASO SEJA CUPOM
            tipoDesconto = new TypeToken<Cupom>() {}.getType();
            return gson.fromJson(objeto, tipoDesconto);

        }
    }


}
