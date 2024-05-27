package com.linkedin.javacodechallenges;

public class App 
{
    public static void main( String[] args )
    {
        Person p1 = new Person("Juancho", "Tito", 30);
        Person p2 = new Person("Negro", "Cabezon", 32);

        System.out.println(p1.greet());
        System.out.println(p2.greet());
    }
}
