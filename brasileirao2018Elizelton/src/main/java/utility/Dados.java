package utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Jogo;
import model.Time;

public class Dados {
    
    private BufferedReader br = null;
    private String nomeArq;
    private Jogo jgLinha;
    List<Time> lstTimes = new ArrayList<>();
    
    public Dados(String nomeArq) {
        this.nomeArq = nomeArq;
    }
    
    public List<Time> ler() {
        String linha;
        
        try {
            br = new BufferedReader(new FileReader(nomeArq));
            while ((linha = br.readLine()) != null) {
                jgLinha = new Jogo(linha);
                analisa(jgLinha);
            }
            // Ordena
            byte i = 0;
            for ( Time t : lstTimes ){
                t.setClas(++i);
            }
            
        } catch (Exception e){
        } finally {
            try {
                if(br != null){
                   br.close();
            }
        } catch (IOException ex) {
        }    
    }
        
        return lstTimes;
    }    
    
    private Time achaTime(String nomeBusca){
        
        for (Time t : lstTimes) {
            if (t.getNome().equals(nomeBusca)){
                return t;
            }
        }
        // Criando novo time caso o mesmo não exista.
        Time timeNovo = new Time(nomeBusca);
        lstTimes.add(timeNovo);
        return(timeNovo);
    }
    
    
    private void analisa(Jogo jg) {
        Time posTimeA = achaTime(jg.getTimeA());
        Time posTimeB = achaTime(jg.getTimeB());        
    
        posTimeA.getJogos().add(jg);
        posTimeB.getJogos().add(jg);
        
        if (jg.getGolA() > jg.getGolB()){   // A ganhou.
            posTimeA.addVitorias();
            posTimeB.addDerrotas();
        } else if (jg.getGolA() < jg.getGolB()){    // B ganhou.
            posTimeB.addVitorias();
            posTimeA.addDerrotas();
        } else {    // Empate.
            posTimeA.addEmpates();
            posTimeB.addEmpates();
        }
        posTimeA.addGolPro(jg.getGolA());
        posTimeB.addGolPro(jg.getGolB());
        
        posTimeA.addGolContra(jg.getGolB());
        posTimeB.addGolContra(jg.getGolA());
    }
}