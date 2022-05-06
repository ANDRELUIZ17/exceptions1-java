package model.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
    private Integer numeroDosQuartos;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservas(Integer numeroDosQuartos, Date checkIn, Date checkOut) {
        this.numeroDosQuartos = numeroDosQuartos;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumeroDosQuartos() {
        return numeroDosQuartos;
    }

    public Reservas setNumeroDosQuartos(Integer numeroDosQuartos) {
        this.numeroDosQuartos = numeroDosQuartos;
        return this;
    }

    public Date getCheckIn() {
        return checkIn; // foi tirado o setCheckOut e o setChekIn porque eu não
        // vou deixar que as datas sejam mudadas arbitrariamente
    }
    public Date getCheckOut() {
        return checkOut;
    }
    public long duracao() { // calculação em dias baseadas em datas
        long diff = checkOut.getTime() - checkIn.getTime(); // pego a diferenças de duas datas em milessegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void atualizacaoData (Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    @Override
    public String toString () {
        return  "Quarto "
            + numeroDosQuartos
            + ", check-in: "
            + sdf.format(checkIn)
            + ", check-out "
            + sdf.format(checkOut)
            + ", "
            + duracao()
            + " noites";


    }

}
