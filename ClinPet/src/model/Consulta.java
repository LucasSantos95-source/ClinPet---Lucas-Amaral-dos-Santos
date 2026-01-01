package model;

public class Consulta {

    private int idConsulta;
    private String nomeTutor;
    private String nomePet;
    private String nomeMedico;
    private String dataConsulta; // YYYY-MM-DD
    private String horaConsulta; // HH:MM
    private String observacoes;

    public Consulta() {
    }

    // ======================
    // GETTERS E SETTERS
    // ======================

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getNomePet() {
        return nomePet;
    }

    public void setNomePet(String nomePet) {
        this.nomePet = nomePet;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHoraConsulta() {
        return horaConsulta;
    }

    public void setHoraConsulta(String horaConsulta) {
        this.horaConsulta = horaConsulta;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    // ======================
    // COMPATIBILIDADE COM BANCO
    // ======================

    // Junta data + hora para salvar no banco
    public String getDataHora() {
        if (dataConsulta != null && horaConsulta != null) {
            return dataConsulta + " " + horaConsulta + ":00";
        }
        return null;
    }

    // Recebe dataHora do banco e separa
    public void setDataHora(String dataHora) {
        if (dataHora != null && dataHora.contains(" ")) {
            String[] partes = dataHora.split(" ");
            this.dataConsulta = partes[0];
            this.horaConsulta = partes[1].substring(0, 5);
        }
    }
}