package aplicacao;

import model.entidades.Reservas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int numero = sc.nextInt();
        System.out.print("Data do Checkin (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("Data do CheckOut (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        if (! checkOut.after(checkin)) { // after testa se uma data é depois a outra
            System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");
        }
        else {
            Reservas reservas = new Reservas(numero, checkin, checkOut);
            System.out.println("Reservas: " + reservas);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva: ");
            System.out.print("Data do Checkin (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next()); // as variaveis ja foram declaradas mais acima
            System.out.print("Data do CheckOut (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkin.before(now)|| checkOut.before(now)) {
                System.out.println("Erro na reserva: as datas de reserva para atualização devem ser datas futuras");
            }
            else if(!checkOut.after(checkin)){
                System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in");
            }
            else {
                reservas.atualizacaoData(checkin, checkOut);
                System.out.println("Resrvas: " + reservas);
            }

        }

        sc.close();
    }
}
