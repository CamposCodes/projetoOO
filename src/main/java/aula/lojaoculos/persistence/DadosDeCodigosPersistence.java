package aula.lojaoculos.persistence;
import aula.lojaoculos.model.DadosDeCodigos;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DadosDeCodigosPersistence {

    static String DIRECTORY = "data";
    private static final String PATH = DIRECTORY + File.separator +"dadosDeCodigos.json";

    public void save(DadosDeCodigos item) {
        Gson gson = new Gson();
        String json = gson.toJson(item);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        Arquivo.salva(PATH, json);
    }

    public DadosDeCodigos findAll() {
        Gson gson = new Gson();

        String json = Arquivo.le(PATH);

        DadosDeCodigos dados = new DadosDeCodigos();
        if(!json.trim().equals("")) {

            Type tipoDado = new TypeToken<DadosDeCodigos>() {
            }.getType();
            dados = gson.fromJson(json, tipoDado);

            if (dados == null)
                dados = new DadosDeCodigos();
        }

        return dados;
    }



}
