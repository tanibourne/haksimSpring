package com.hyuk.core.singleton;

public class SingleTonService {

    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance() {
        return instance;
    }

   private SingleTonService() {
   }

   public void logic() {
       System.out.println("Singleton 객체 로직 호출");
   }
}
