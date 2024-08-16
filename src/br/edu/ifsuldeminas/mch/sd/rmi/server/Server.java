package br.edu.ifsuldeminas.mch.sd.rmi.server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Server {

    private static final int RMI_DEFAULT_PORT = 1099;
    private static Registry registry;

    public Server() {
        try {
            Calculator calculator = new Calculator();

            registry = LocateRegistry.createRegistry(RMI_DEFAULT_PORT);

            Operations stub = (Operations) UnicastRemoteObject.exportObject(
                    calculator, RMI_DEFAULT_PORT);
 
            registry.rebind("CalculatorService", stub);
            System.out.println("Servico da calculadora rodando...");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao inicializar o servidor.");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Server();
    }
}
