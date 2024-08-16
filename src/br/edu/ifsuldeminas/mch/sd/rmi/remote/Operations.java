package br.edu.ifsuldeminas.mch.sd.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Operations extends Remote {

    // Outros métodos...
    Number sum(Number x, Number y) throws RemoteException;

    Number sub(Number x, Number y) throws RemoteException;

    Number mul(Number x, Number y) throws RemoteException;

    Number div(Number x, Number y) throws RemoteException;

    Number sqrt(Number x) throws RemoteException;  // Raiz quadrada

    Number cbrt(Number x) throws RemoteException;  // Raiz cúbica

    Number root4(Number x) throws RemoteException; // Raiz quarta (nova operação)

    Number pow2(Number x) throws RemoteException;  // Potência de 2

    Number pow3(Number x) throws RemoteException;  // Potência de 3

    Number pow4(Number x) throws RemoteException;  // Potência de 4

    Number percentage(Number x, Number y) throws RemoteException;  // Porcentagem

    Number mod(Number x, Number y) throws RemoteException;  // Módulo

    Number factorial(Number x) throws RemoteException;  // Fatorial

    List<String> lastOperations(int howMany) throws RemoteException;

    List<String> lastOperations() throws RemoteException;
}
