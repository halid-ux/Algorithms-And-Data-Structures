package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrvaBukvaGolema {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DLL<String> list1 = new DLL<String>();
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String[] niza = line.split(" ");
        for (int i = 0; i < N; i++) {
            list1.insertLast(niza[i]);
        }
        method(list1);

    }

    public static void method(DLL<String> lista) {
        DLLNode<String> tmp = lista.getFirst();
            String str= "";
        while (tmp!= null){
                str= tmp.element;
                char prvaBukva= str.charAt(0);
                char prvaGolema= Character.toUpperCase(prvaBukva);
                String novoIme= prvaGolema + str.substring(1, str.length());
                lista.insertBefore(novoIme, tmp);
                lista.delete(tmp);
                tmp=tmp.succ;
            }
        System.out.println(lista);


    }
}

