package aula.lojaoculos.persistence;

import aula.lojaoculos.model.OculosEscuros;
import aula.lojaoculos.model.OculosGrau;
import aula.lojaoculos.model.OculosGrauEscuro;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
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

        String json = Arquivo.le(PATH);

        List<Oculos> oculos = new ArrayList<>();

        JsonElement elemento = JsonParser.parseString(json);
        if(!elemento.isJsonNull()){
            JsonArray array = elemento.getAsJsonArray();
            for (JsonElement item : array){
                oculos.add(retornaObjetoOculos(item));
            }
        }

        return oculos;
    }

    private Oculos retornaObjetoOculos(JsonElement objeto){

        String objetoEmString = objeto.toString();
        Type tipoOculos;

        Gson gson = new Gson();

        if(objetoEmString.contains("corDaLente") && objetoEmString.contains("grauEsquerda")){ // CASO SEJA ESCURO E GRAU
            tipoOculos = new TypeToken<OculosGrauEscuro>() {}.getType();
            return gson.fromJson(objeto, tipoOculos);

        } else if (!objetoEmString.contains("corDaLente") && objetoEmString.contains("grauEsquerda")) { // CASO SEJA SO GRAU
            tipoOculos = new TypeToken<OculosGrau>() {}.getType();
            return gson.fromJson(objeto, tipoOculos);

        } else if (objetoEmString.contains("corDaLente") && !objetoEmString.contains("grauEsquerda")) { // CASO SEJA SO ESCURO
            tipoOculos = new TypeToken<OculosEscuros>() {}.getType();
            return gson.fromJson(objeto, tipoOculos);
        }

        return null;
    }


}
