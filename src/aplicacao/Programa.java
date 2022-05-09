package aplicacao;

import model.entidades.Reservas;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Número do quarto: ");
            int numero = sc.nextInt();
            System.out.print("Data do Checkin (dd/MM/yyyy): ");
            Date checkin = sdf.parse(sc.next());
            System.out.print("Data do CheckOut (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservas reservas = new Reservas(numero, checkin, checkOut);
            System.out.println("Reservas: " + reservas);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva: ");
            System.out.print("Data do Checkin (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next()); // as variaveis ja foram declaradas mais acima
            System.out.print("Data do CheckOut (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservas.atualizacaoData(checkin, checkOut);
            System.out.println("Reservas: " + reservas);
        } catch (ParseException e) {
            System.out.println("Formato da data inválido! ");
        }
        catch (DomainException e) {
            System.out.println("Erro na reservação: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado! ");
        }

        sc.close();
    }
}
