package br.edu.ifsuldeminas.mch.sd.rmi;

import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;
import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class client {

    public static void main(String[] args) {
        try {
            Operations calc = (Operations) Naming
                    .lookup("rmi://localhost/CalculatorService");

            System.out.println("• Operações Básicas");
            System.out.println("  - Soma: " + calc.sum(100, 5));
            System.out.println("  - Subtração: " + calc.sub(1040, 5));
            System.out.println("  - Multiplicação: " + calc.mul(10, 200));
            System.out.println("  - Divisão: " + calc.div(10.5, 0.1));

            System.out.println("\n• Raízes (quadrada, cúbica, etc.)");
            System.out.println("  - Raiz Quadrada de 16: " + calc.sqrt(16));
            System.out.println("  - Raiz Cúbica de 27: " + calc.cbrt(27));
            System.out.println("  - Raiz Quarta de 81: " + calc.root4(81)); // Nova operação de raiz quarta

            System.out.println("\n• Potências (de 2, 3, etc.)");
            System.out.println("  - Potência de 2 de 5: " + calc.pow2(5));
            System.out.println("  - Potência de 3 de 2: " + calc.pow3(2));
            System.out.println("  - Potência de 4 de 3: " + calc.pow4(3));

            System.out.println("\n• Porcentagem");
            System.out.println("  - 10% de 50: " + calc.percentage(50, 10));

            System.out.println("\n• Módulo");
            System.out.println("  - 10 mod 3: " + calc.mod(10, 3));

            System.out.println("\n• Fatorial");
            System.out.println("  - Fatorial de 5: " + calc.factorial(5));

        } catch (MalformedURLException murle) {
            System.out.println("Erro na URL de acesso ao servico.");
        } catch (NotBoundException nbe) {
            System.out.println(
                    "Erro ao se ligar ao stub remoto. Nome de servico invalido.");
        } catch (ConnectException re) {
            System.out.println("Erro ao se conectar. Servidor nao iniciado.");
        } catch (RemoteException re) {
            System.out.println("Erro na chamada remota.");
            re.printStackTrace();
        }
    }
}
