package utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Professor;
import org.json.JSONException;
import org.json.JSONObject;

public class Json {

    private BufferedReader br = null;
    private String nomeArq;
//    private Jogo jgLinha;
//    List<Time> lstTimes = new ArrayList<>();

    public Json(String nomeArq) {
        this.nomeArq = nomeArq;
    }

    public String getNomeArq() {
        return nomeArq;
    }

    public void ExportarJsonProfessor(List<Professor> professores) {
        try {
            File file = new File(getNomeArq());
            file.createNewFile();
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                JSONObject eJSON = new JSONObject();
                for (Professor p : professores) {
                    eJSON.put("nome", p.getNome());
                    eJSON.put("email", p.getEmail());
                    eJSON.put("cpf", p.getCpf());
                    bw.write(eJSON.toString() + "\n");
                    System.out.println(eJSON);
                }
            }
        } catch (IOException | JSONException e) {

        }
    }

    public List<Professor> ImportarJsonProfessor() {
        List<Professor> impProf = new ArrayList<>();
        Professor pessoaTmp;
        String linha;
        try {
            br = new BufferedReader(new FileReader(getNomeArq()));
            while ((linha = br.readLine()) != null) {
                JSONObject eJSON = new JSONObject(linha);
                pessoaTmp = new Professor();
                pessoaTmp.setNome(eJSON.getString("nome"));
                pessoaTmp.setEmail(eJSON.getString("email"));
                pessoaTmp.setCpf(eJSON.getString("cpf"));

                impProf.add(pessoaTmp);
            }
        } catch (IOException | JSONException e) {
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
            }
        }
        return impProf;
    }

}
