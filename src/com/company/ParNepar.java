package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParNepar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<Integer> lista1 = new DLL<Integer>();
        DLL<Integer> lista2 = new DLL<Integer>();

        String line = br.readLine(); //M N
        String[] pom = line.split(" ");
        int M = Integer.parseInt(pom[0]);
        int N = Integer.parseInt(pom[1]);

        line = br.readLine();//cita elementi od prvata lista ("5 4 3 2 1")
        String[] pom1 = line.split(" ");
        for (int i = 0; i < M; i++) {
            lista1.insertLast(Integer.parseInt(pom1[i]));
        }

        line = br.readLine();
        String[] pom2 = line.split(" ");
        for (int i = 0; i < N; i++) {
            lista2.insertLast(Integer.parseInt(pom2[i]));
        }
        metod(lista1, lista2);
        // System.out.println(lista1);
        // System.out.println(lista2);
    }

    public static void metod(DLL<Integer> lista1, DLL<Integer> lista2) {
        DLLNode<Integer> tmp1 = lista1.getLast();
        DLLNode<Integer> tmp2 = lista2.getLast();
        DLL<Integer> lista = new DLL<Integer>();

        while (tmp1 != null && tmp2 != null) {
            if (tmp1.element >= tmp2.element) {
                if (tmp1.element % 2 != 0) {
                    lista.insertLast(tmp1.element);
                }
                tmp1 = tmp1.pred;
            } else if (tmp2.element > tmp1.element) {
                if (tmp2.element % 2 == 0) {
                    lista.insertLast(tmp2.element);
                }
                tmp2 = tmp2.pred;
            }

        }
        while (tmp1 != null) {
            if (tmp1.element % 2 != 0) {
                lista.insertLast(tmp1.element);
            }
            tmp1 = tmp1.pred;
        }
        while (tmp2 != null) {
            if (tmp2.element % 2 == 0) {
                lista.insertLast(tmp2.element);
            }
        }
        System.out.println(lista);
    }
}