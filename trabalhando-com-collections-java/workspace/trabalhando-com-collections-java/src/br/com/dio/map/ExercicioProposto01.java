package br.com.dio.map;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ExercicioProposto01 {

	public static void main(String[] args) {
        System.out.println("Crie um dicion�rio que relacione os estados e suas respectivas popula��es: ");
        Map<String, Integer> popula��oEstadosNE = new HashMap<>();
        popula��oEstadosNE.put("PE", 9616621);
        popula��oEstadosNE.put("AL", 3351543);
        popula��oEstadosNE.put("CE", 9187103);
        popula��oEstadosNE.put("RN", 3534265);
        System.out.println(popula��oEstadosNE);

        System.out.println("Substitua a popula��o do estado RN por : 3.534.165");
        popula��oEstadosNE.put("RN", 3534165);
        System.out.println(popula��oEstadosNE);

        System.out.println("Confira se o estado da Para�ba (PB) tucson est� no dicion�rio, caso n�o, adicione " +
                "PB - 4.039.277: ");
        popula��oEstadosNE.put("PB", 4039277);
        System.out.println(popula��oEstadosNE);

        System.out.println("Exiba a popula��o do estado PE: " + popula��oEstadosNE.get("PE"));

        System.out.println("Exiba todos os estados e suas popula��os na ordem em que foram informados: ");
        Map<String, Integer> popula��oEstadosNE2 = new LinkedHashMap<>();
        popula��oEstadosNE2.put("PE", 9616621);
        popula��oEstadosNE2.put("AL", 3351543);
        popula��oEstadosNE2.put("CE", 9187103);
        popula��oEstadosNE2.put("RN", 3534265);
        popula��oEstadosNE2.put("PB", 4039277);
        System.out.println(popula��oEstadosNE2);

        System.out.println("Exiba todos os estados e suas popula��es na ordem alfab�tica: ");
        Map<String, Integer> popula��oEstadosNE3 = new TreeMap<>(popula��oEstadosNE);
        System.out.println(popula��oEstadosNE3);

        Collection<Integer> populacao = popula��oEstadosNE.values();
        String estadoMaiorPopulacao = "";
        String estadoMenorPopulacao = "";
        for (Map.Entry<String, Integer> entry : popula��oEstadosNE.entrySet()) {
            if (entry.getValue().equals(Collections.max(populacao))) estadoMaiorPopulacao = entry.getKey();
            if (entry.getValue().equals(Collections.min(populacao))) estadoMenorPopulacao = entry.getKey();
        }
        System.out.printf("Exiba o estado com o menor popula��o (%s) e seu respectivo valor (%d)\n",
                estadoMenorPopulacao, Collections.min(populacao));
        System.out.printf("Exiba o estado com a maior popula��o (%s) e seu respectivo valor (%d)\n",
                estadoMaiorPopulacao, Collections.max(populacao));

        int soma = 0;
        Iterator<Integer> iterator = popula��oEstadosNE.values().iterator();
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("Exiba a soma da popula��o desses estados: " + soma);
/*        int soma2 = 0;
       for(Map.Entry<String, Integer> entry : popula��oEstadosNE.entrySet()) {
           soma2 += entry.getValue();
       }
*/

        System.out.println("Exiba a m�dia da popula��o deste dicion�rio de estados: " + (soma / popula��oEstadosNE.size()));
        System.out.println("Remova os estados com a popula��o menor que 4.000.000: ");
        Iterator<Integer> iterator1 = popula��oEstadosNE.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4000000) iterator1.remove();
        }
        System.out.println(popula��oEstadosNE);

        System.out.println("Apague o dicionario de estados com suas respectivas popula��es estimadas: ");
        popula��oEstadosNE.clear();
        System.out.println(popula��oEstadosNE);

        System.out.println("Confira se a lista est� vazia: " + popula��oEstadosNE.isEmpty());

    }
	
}
