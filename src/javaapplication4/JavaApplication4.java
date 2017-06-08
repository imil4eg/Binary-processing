package javaapplication4;
import java.io.*;
import java.util.*;
import java.util.ArrayList;


public class JavaApplication4 {

    public static void main(String[] args) {
        In in = new In();
        Out out = new Out();
        in.addObserver(out);
        in.getIn();
        
        in.notifyObservers();
    }
    
}

class In extends Observable{
    List<Integer> al = new ArrayList<>();
    public void getIn(){
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        int size = 0,choice = 0,somenum = 5,zad=0,j=0,k=0;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Vvedite kol-vo elementom: ");//запрос на количество элементов
        
        if(sc.hasNextInt())
            size = sc.nextInt();
        
        for(int i = 0;i < size;i++)//ввод элементов в массив
        {
            System.out.println("Vvedite " + (i+1) + " element massiva");
            al.add(sc.nextInt());
        }
        
       System.out.println(al);
       
       System.out.println("V kakoi massiv zapisat chisla??");
       
       if(sc.hasNextInt())//выборка массива 
           choice = sc.nextInt();
       
       switch(choice)//проверка выбора
       {
           case 1://если choice = 1 переходит сюда
               System.out.println("Kakoi element massiva sravnit s chislom " + somenum);//задание 3
               
               if(sc.hasNextInt())//запрос на элемент массива
                   zad = sc.nextInt();
               
               if(zad > al.size())//проверка на то,если введенное число выходит за рамки массива
               {
                   System.out.println("Vvedeno nevernoe znachenie");
               }
               else
               {
                   if(al.get(zad) == somenum)//сравнение элемента массива с числом somenum
                       System.out.println("Element massiva " + al.get(zad) + " raven chisly " + somenum);
                   else
                       System.out.println("Element massiva " + al.get(zad) + " ne raven chisly " + somenum);
               }
                for(int i = 0;i < al.size();i++)//Задание из  первой лабы
                {
                    if(al.get(i) == 1)//счетчик для 1
                        j++;
                    if(al.get(i) == 0)//счетчик для 0
                         k++;
                }
                for(int i = 0;i < j;i++)//вписываем значения 1 в первый массив
                    al1.add(1);
                for(int i = 0;i < k;i++)//вписываем 0 в первый массив
                    al1.add(0);
            
                setChanged();
                notifyObservers(al1);
                break;
           case 2://если choice = 2 переходит сюда
               System.out.println("Kakoi element sravnit s chislom " + somenum);
               
               if(sc.hasNextInt())
                   zad = sc.nextInt();
               
               if(zad > al.size())
               {
                   System.out.println("Vvedeno nevernoe znachenie");
               }
               else
               {
                   if(al.get(zad) == somenum)
                       System.out.println("Element massiva " + al.get(zad) + " raven chisly " + somenum);
                   else
                       System.out.println("Element massiva " + al.get(zad) + " ne raven chisly " + somenum);
               }
                for(int i = 0;i < al.size();i++)
                {
                    if(al.get(i) == 1)
                        j++;
                    if(al.get(i) == 0)
                         k++;
                }
                for(int i = 0;i < j;i++)
                    al2.add(1);
                for(int i = 0;i < k;i++)
                    al2.add(0);
            
                setChanged();
                notifyObservers(al2);
                break;
           default://все остальные значения,которые не входят в предыдущие
               System.out.println("Vvedeno nevernoe znachenie");
               break;
       }
       
    }
}

class Out implements Observer{//обновление переменной
    public void update(Observable o,Object arg){
        List<Integer> al = new ArrayList<>();
        System.out.println(arg);
    }
}
