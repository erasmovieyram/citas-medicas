import java.time.LocalDateTime;

public class Cita {
    private String id;
    private LocalDateTime fechaHora;
    private String motivo;
    private String idDoctor;
    private String idPaciente;

    public Cita(String id, LocalDateTime fechaHora, String motivo, String idDoctor, String idPaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    @Override
    public String toString() {
        return "Cita{id='" + id + "', fechaHora=" + fechaHora + ", motivo='" + motivo + "', idDoctor='" + idDoctor + "', idPaciente='" + idPaciente + "'}";
    }
}