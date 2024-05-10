/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.databaseaccessthread;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author 55649
 */
public class DatabaseAccessThread {

    public static void main(String[] args) throws InterruptedException {
        
        int CountThreads = 10;
        CountDownLatch readyLatch = new CountDownLatch(CountThreads);
        CountDownLatch startLatch = new CountDownLatch(1);
        
        for(int i = 0; i < CountThreads; i++){
            
            new Thread (new Runnable() {
                
                @Override
                public void run() {
                    readyLatch.countDown();
                    try {
                        startLatch.await();
                        DatabaseConnectionManager intancia = DatabaseConnectionManager.getInstancia();
                        System.out.println("Instância de N°: " + intancia.hashCode());
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }).start();
        }
        readyLatch.await(); 
        startLatch.countDown();      
        
    }
}
